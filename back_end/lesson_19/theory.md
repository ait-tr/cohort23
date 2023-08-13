## Работа с JpaRepositories - Часть 3

### Структура запроса на получение всех пользователей

* В `UsersApi`:

```
ResponseEntity<UsersDto> getAllUsers(
            @RequestParam(value = "page") Integer page, // номер страницы
            @RequestParam(value = "orderBy", required = false) String orderBy, // поле, по которому будем сортировать
            @RequestParam(value = "desc", required = false) Boolean desc, // сортируем по убыванию, если desc - true
            @RequestParam(value = "filterBy", required = false) String filterBy, // по какому полю фильтруем результат
            @RequestParam(value = "filterValue", required = false) String filterValue, // значение этого поля
            @RequestParam(value = "articles", required = false) String articlesState); // можно попросить опубликованные статьи, если articles=true
```

* У метода шесть параметров. Они передаются в URL.
* Пример запроса: `GET /users?page=1&orderBy=email&desc=true&filterBy=role&filterValue=ADMIN` - мы хотим получить
  первую страницу с администраторами, отсортированными по email в обратном порядке.
* Пример запроса: `GET /users?page=1&articles=published` - получить первую страницу пользователей со всеми статьями

* Пример обработчика в `UsersController` - мы просто передаем все параметры в сервис:

```
@Override
public ResponseEntity<UsersDto> getAllUsers(Integer pageNumber,
                                                String orderBy,
                                                Boolean desc,
                                                String filterBy,
                                                String filterValue,
                                                String articlesState) {
    return ResponseEntity
        .ok(usersService.getAllUsers(pageNumber, orderBy, desc, filterBy, filterValue, articlesState));
}
```

#### Работа с обработкой запроса в сервисе/утилитах:

* Метод для получения объекта `PageRequest` из класса `PageRequestsUtil`:

```java
class PageRequestsUtil {

  @Value("${global.page.size}")
  private Integer pageSize;
    
    /**
     * Метод для получения объекта PageRequest
     * @param pageNumber номер запрашиваемой страницы
     * @param orderByField поле, по которому мы хотим сделать сортировку
     * @param desc нужно ли сортировать по убиванию
     * @param sortFields список доступных полей для сортировки            
     * @return объект PageRequest с нужными данными
     */
    public PageRequest getPageRequest(Integer pageNumber, String orderByField, Boolean desc, List<String> sortFields) {

        if (orderByField != null && !orderByField.equals("")) { // проверяем, задал ли клиент поле для сортировки?

            // sortFields мы берем из application.properties
            checkField(sortFields, orderByField); // проверяем, доступно ли нам поле для сортировки в sortFields
            
            Sort.Direction direction = Sort.Direction.ASC; // предполагаем, что сортировка будет в прямом порядке

            if (desc != null && desc) { // если клиент задал сортировку в обратном порядке
                direction = Sort.Direction.DESC; // задаем обратный порядок сортировки
            }

            Sort sort = Sort.by(direction, orderByField); // создаем объект для сортировки направление + поле

            return PageRequest.of(pageNumber, pageSize, sort); // создаем запрос на получение страницы пользователей с сортировкой
        } else {
            // если клиент не указал в запросе данные для сортировки - то создаем "запрос по умолчанию"
            return getDefaultPageRequest(pageNumber);
        }
    }

    /**
     * Проверяет, содержится ли значение <code>field</code> в списке <code>allowedFields</code>
     * @param allowedFields список разрешенных полей
     * @param field поле, которое мы проверяем
     * @throws ForbiddenFieldException если поле не содержится в списке             
     */
    public void checkField(List<String> allowedFields, String field) {
        if (!allowedFields.contains(field)) {
            throw new ForbiddenFieldException(field);
        }
    }

    /**
     * Метод для получения запроса по умолчанию
     * @param pageNumber номер страницы
     * @return запрос страницы по умолчанию
     */
    public PageRequest getDefaultPageRequest(Integer pageNumber) {
        // если запрашиваем страницу по умолчанию, то будем использовать сортировку в прямом порядке по id
        return PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "id"));
    }
}
```

* Получение пользователей в `UsersServiceImpl`:

```java
class UsersServiceImpl {
  /**
   * Метод для получения списка всех пользователей с пагинацией и сортировкой
   * @param pageNumber номер страницы
   * @param orderByField поле, по которому нужно отсортировать
   * @param desc сортировка в обратном порядке
   * @param filterBy по какому полю нужно сделать фильтрацию
   * @param filterValue значение поля, по которому нужно сделать фильтрацию
   * @param articlesState если задано значение published, то кладем опубликованные статьи
   * @return список пользователей со статьями или без
   */
  @Override
  public UsersDto getAllUsers(Integer pageNumber,
                              String orderByField,
                              Boolean desc,
                              String filterBy,
                              String filterValue,
                              String articlesState) {

    // получаем запрос на страницу с пользователями с помощью класса-утилиты
    PageRequest pageRequest = pageRequestsUtil.getPageRequest(pageNumber, orderByField, desc, sortFields);
    // получаем страницу с пользователями на основе запроса на страницу
    Page<User> page = getUsersPage(filterBy, filterValue, articlesState, pageRequest);
    // формируем результат, который превратиться в JSON
    UsersDto result = UsersDto.builder()
            .count(page.getTotalElements()) // берем количество пользователей в базе
            .pagesCount(page.getTotalPages()) // берем общее количество страниц
            .build();

    if (isRequestForPublishedArticles(articlesState)) { // если попросили опубликованные статьи
      result.setUsers(fromWithArticles(page.getContent())); // берем пользователей с их статьями
    } else { // если не просили статьи
      result.setUsers(from(page.getContent())); // не берем статьи
    }

    return result;
  }

  /**
   * Проверяем, запросили ли опубликованные статьи
   * @param articlesState published - значит просим опубликованные
   * @return <code>true</code> если запросили опубликованные статьи
   */
  private static boolean isRequestForPublishedArticles(String articlesState) {
    return articlesState != null && articlesState.equals("published");
  }

  /**
   * Получение страницы с пользователями исходя из условий выборки
   * @param filterBy по какому полю отбираем
   * @param filterValue значения поля, которое отбираем
   * @param articles если задано published - то возвращаем со статьями (опубликованными)
   * @param pageRequest запрос на получение страницы (сортировка + пагинация)
   * @return страница с пользователями
   */
  private Page<User> getUsersPage(String filterBy, String filterValue, String articles, PageRequest pageRequest) {
    // создаем пустую страницу, если запрос был сформирован не правильно - можем просто вернуть пустую страницу
    Page<User> page = Page.empty();
    if (isRequestForPublishedArticles(articles)) { // если запросили с опубликованными статьями
      page = usersRepository.findAll(pageRequest); // пока возвращаем все, что есть
    } else if (filterBy == null || filterBy.equals("")) { // если не указали параметр фильтрации
      page = usersRepository.findAll(pageRequest); // пока возвращаем все, что есть
    } else { // если не просили статьи и при этом указали параметры фильтрации
      pageRequestsUtil.checkField(filterFields, filterBy); // проверяем, что по этим полям можно фильтровать
      if (filterBy.equals("role")) { // если хотят получить по роли
        User.Role role = User.Role.valueOf(filterValue); // преобразуем строку в enum
        page = usersRepository.findAllByRole(role, pageRequest); // запрашиваем по роли из репозитория
      } else if (filterBy.equals("state")) { // если хотят получить по состоянию
        User.State state = User.State.valueOf(filterValue); // преобразуем строку в enum
        page = usersRepository.findAllByState(state, pageRequest); // запрашиваем по состоянию из репозитория
      }
    }
    return page; // возвращаем страницу
  }
}
```

#### Встроенные классы

* `PageRequest` - стандартный класс для Spring Data Jpa, позволяет отправить запрос с настройками:
  * номер страницы
  * максимальный размер страницы
  * сортировка
  * по сути - пагинация + сортировка
* `Sort.Direction` - стандартный класс для Spring Data Jpa, позволяет указать направление сортировки
* `Sort` - стандартный класс для Spring Data Jpa, позволяет указать поле для сортировки и направление
* `Page` - стандартный класс для Spring Data Jpa, содержит страницу, полученную из репозитория

```
GET /users?articles=published
```

#### Получение всех пользователей и их опубликованных статей на SQL

```
select *
from ACCOUNT acc
       left join (select * from ARTICLE art where art.STATE = 'PUBLISHED') published_articles
                 on acc.id = published_articles.ABOUT_ID;
```

* Получение всех опубликованных статей

```
select * from ARTICLE art where art.STATE = 'PUBLISHED'
```

* Далее, мы делаем `alias` для выборки опубликованных статей - `published_articles`
* Потом, делаем `left join` таблицы пользователей с выборкой опубликованных статей

#### JPQL

* Java Persistence Query Language - специальный язык запросов, который позволяет писать SQL-подобные запросы, основываясь не на таблицах, а на классах.

* Получение всех пользователей у которых есть хотя бы одна опубликованная статья

```
@Query(value = "select distinct user from User user left join user.articles article where article.state = 'PUBLISHED'")
Page<User> findAllWithPublishedArticles(Pageable pageable);
```

* `select user from User user` - получить объекты типа `User`
* `left join user.articles article` - присоединить к пользователям статьи
* `where article.state = 'PUBLISHED'` - присоединяем только нужные статьи (опубликованные)


#### Distinct, First, Top, Contains - РАССМОТРИМ ПОЗЖЕ

* Реализовать endpoint для получения пользователей со всеми ОПУБЛИКОВАННЫМИ статьями

