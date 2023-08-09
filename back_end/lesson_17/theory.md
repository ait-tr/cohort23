## Работа с JpaRepositories

* У нас есть базовый набор методов для работы с данными в JpaRepository
  * `List<T> findAll();` - получить все данные из репозитория
  * `<S extends T> S save(S entity);` - сохранить сущность (аналог `INSERT`) в базу данных. Также можно сохранить "потомка".
  * `Optional<T> findById(ID id);` - найти одну сущность по идентификатору.
  * `boolean existsById(ID id);` - проверить существование сущности по идентификатору
  
    ```
    if (!usersRepository.existsById(newArticle.getAboutUserId())) {
            throw new IncorrectUserIdException(newArticle.getAboutUserId());
        }
    ```
  
  * `long count();` - общее количество сущностей, которые есть в репозитории
  * `void deleteById(ID id);` - удаление по идентификатору
  * `void delete(T entity);` - удаление сущности
  * `void deleteAllById(Iterable<? extends ID> ids);` - удалить множество сущностей по их идентификаторам
  * `List<T> findAll(Sort sort);` - получение с сортировкой
  * `Page<T> findAll(Pageable pageable);` - получение с пагинацией

* Дополнительно надо изучить:
  * `List<T> findAllById(Iterable<ID> ids);`
  * `<S extends T> List<S> saveAll(Iterable<S> entities);`

## Как сделать сортировку в REST API?

* `GET /users?orderBy={поле}&desc=true`, например:
* `GET /users?orderBy=role&desc=true` - получить всех пользователей, отсортированных по ролям в обратном порядке

## А что такое пагинация?

* Пагинация (анг. Pagination, от Page - страница) - возможность получать данные блоками (страницами) относительного мало размера.
* Все множество данных мы разбиваем "на страницы", чтобы не отправлять большую "пачку данных"
* Ведь например пользователей может быть и миллион, разом отправлять JSON размером миллион - это много
* На уровне базы данных это реализуется с помощью "limit, offset"
* `limit` - размер выборки
* `offset` - это отступ выборки от начала
* Например: `select * from ACCOUNT limit 2 offset 3;` - пропустить первые три записи и получить две следующие

* Для запроса с пагинацией генерируется SQL:

```
select
        user0_.id as id1_0_,
        user0_.email as email2_0_,
        user0_.password as password3_0_,
        user0_.role as role4_0_,
        user0_.state as state5_0_ 
    from
        account user0_ 
    order by
        user0_.state desc limit ? offset ?
```

* `Sort` - позволяет задать сортировку
* `PageRequest` - позволяет сформировать запрос на получение страницы
* `Page` - результат запроса страницы

* Иногда мы хотим фильтровать данные, например найти всех пользователей, у которых состояние - NOT_CONFIRMED
* Запрос будет выглядеть так:

```
GET /users?filterBy=state&filterValue=NOT_CONFIRMED
```

* Если хотим получить всех менеджеров:

```
GET /users?filterBy=role&filterValue=MANAGER
```

### С чем мы сегодня работали?

* `UserApi`/`UserController`/`UsersService`/`UsersServiceImpl` -> `getAllUsers`

Реализовали в `UsersServiceImpl`:
- `private Page<User> getUsersPage(String filterBy, String filterValue, PageRequest pageRequest)`
- `private PageRequest getPageRequest(Integer pageNumber, String orderByField, Boolean desc)`
- `private void checkField(List<String> allowedFields, String field)`

Добавили в `UsersRepository`:
- `Page<User> findAllByRole(User.Role role, Pageable pageable)`
- `Page<User> findAllByState(User.State state, Pageable pageable)`;