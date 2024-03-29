## План работ

![image](https://raw.githubusercontent.com/ait-tr/cohort23/main/back_end/lesson_16/img/1.png)

### Сделать формат информации об ошибках одинаковым для всех типов ошибок:

* Стандартный вид

```json
{
  "timestamp": "2023-08-08T07:35:26.603+00:00",
  "status": 422,
  "error": "Unprocessable Entity",
  "path": "/api/articles"
}
```

* Как мы сделали:

```json
{
  "message": "User with id <1> not found."
}
```

* Этапы выполнения:
  * Подготовили `ErrorDto`
  * Сделали Handler для обработки ошибок
  * Над своими исключениями убираем `@ResponseStatus
  * В исключении `IncorrectUserIdException` мы получаем информацию об ID и только ID.
  * Из ArticlesServiceImpl убрали текст ошибки, чтобы сервис не думал о том, какой текст для этого исключения нужно готовить.
  * В ArticlesApi добавили документацию (Content) для ответа 422.

### Написать адекватные интеграционные тесты

* Модульный тест/юнит-тест проверяет только один класс со всеми его методами независимо от других, выполняется быстро.
* Интеграционные тесты - проверяет связку различных компонентов и позволяет проверить всю систему в целом, выполняется очень медленно.
* Если в интеграционном тесте использовать реальную базу данных на жестком диске, получим проблемы:
  * Используем внешнюю тяжеловесную СУБД
  * Медленные тесты
  * Необходимость настройки и установки БД
  * Необходимость ручного создания пользователя с паролем и логином
  * Постоянно очищать базу
  * Непереносимость тестов (каждому разработчику нужно будет настраивать свою тестовую БД)
* Решение - использовать InMemory H2-базу данных

#### Этапы

* Из application.properties убираем необходимость вывода SQL, поскольку такая информация нужна только для отладки и на реальном сервере ее смотреть никто не будет (она будет только занимать место)
* В папке `test` создаем файл `application-test.properties`. В данном случае test - это "профиль"
* Приложение может быть запущено в разных профилях:
  * prod/server - это запуск уже полноценно работающего приложения (отладочная информация не выводится, закрыты порты, максимальные настройки безопасности и т.д.)
  * dev - запуск на компьютере разработчика или в тестовом окружении на сервере (максимум отладочной информации)
  * test - профиль для работы тестов со своими настройками
* В файле `application-test.properties` указали настройки для тестов. Главное - указали другую БД, которую нужно использовать для тестов.
* Как сделать так, чтобы тесты работали именно с `test.properties`? - указать в тесте `@ActiveProfiles("test)`
* Подготовили файл `data_for_articles.sql` с тестовыми данными для тестов
* Над тест-методом поставим `@Sql(scripts = "/data_for_articles.sql")` для загрузки в базу тестовых данных
* `@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)` - нужно, чтобы база пересоздавалась после каждого запуска теста
* Во всех методах, которые изменяют базу данных, ставим аннотацию DirtiesContext, чтобы все тесты были изолированы друг от друга