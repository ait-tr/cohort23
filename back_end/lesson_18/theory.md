## Работа с JpaRepositories - Часть 2

* Получить все опубликованные статьи по определенному пользователю

```
GET /api/users/{id}/articles/published
```

### Собственные методы в репозитории:

#### find

* Метод может начинаться с:
  * `find` - найти что-то и вернуть коллекцию, Stream<T>, Page, либо один объект
* Опционально - что конкретно найти (название сущности)
  * `findArticles`
* Можно указать просто `All`
  * `findAll`
* Добавляем ключевое слово `By` - для того, чтобы потом указать критерии, по которым будем искать
* Указываем поле, по которому будем фильтровать (+ опционально `Is`)
  * `findAllByAboutIs`
* Если у нас более одной характеристики - используем `And`
  * `findAllByAboutAndState` - найти все статьи по тому, о ком они написаны и их состоянию

#### exists

* Проверить, есть ли какая-либо сущность по какому-то параметру
* Например: существует ли статья за определенную дату у определенного пользователя?

```
boolean existsByPublishDateAndAbout(LocalDate date, User about);

User user = usersRepository.findById(7L).orElseThrow(() -> new NotFoundException("User", 7L));
boolean result = articlesRepository.existsByPublishDateAndAbout(LocalDate.of(2023, 7, 31), user);
```

#### count

* Получение количества сущностей по определенным параметрам
* Например: получить количество статей, даты публикаций которых находятся в определенном промежутке

```
int countByPublishDateBetween(LocalDate from, LocalDate to);

int count = articlesRepository.countByPublishDateBetween(LocalDate.parse("2023-01-01"), LocalDate.parse("2024-01-01"));
System.out.println(count);
```

### delete

* Удаление по каким-то характеристикам
* Удаление всех статей, у которых дата публикации ранее заданной

```
void deleteByPublishDateBefore(LocalDate date);
```

#### Дополнительные ключевые слова

* `And` - И
* `Or` - ИЛИ
* `Between` - МЕЖДУ, применимо для числовых типов и дат/времен
* `Before` - ДО, применимо для числовых типов и дат/времен
* `After` - ПОСЛЕ, применимо для числовых типов и дат/времен

#### Параметры, которые заданы для подсущностей

* Например - показать все статьи, которые написаны о подтвержденных менеджерах:

```
List<Article> findAllByAbout_RoleAndAbout_State(User.Role role, User.State state);

List<Article> articles = articlesRepository.findAllByAbout_RoleAndAbout_State(User.Role.MANAGER, User.State.CONFIRMED);
```

* Например, второй - показать всех пользователей, у которых есть статьи в заданном промежутке

```
List<User> findAllByArticles_PublishDateBetween(LocalDate from, LocalDate to);

List<User> users = usersRepository.findAllByArticles_PublishDateBetween(
                LocalDate.parse("2021-01-01"),
                LocalDate.parse("2023-12-31"));
```

#### Distinct, First, Top, Contains - РАССМОТРИМ ПОЗЖЕ

#### 

* Реализовать endpoint для получения пользователей со всеми ОПУБЛИКОВАННЫМИ статьями

```
GET /users?articles=published
```