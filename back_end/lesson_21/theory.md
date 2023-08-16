# Этапы создания проекта

1. Добавить зависимости на `validation` и `openapi-ui`
2. Настроить `application.yml`
3. Описать модели и репозитории
4. Настроить безопасность
  - сделать метод `findByEmail`
  - проверить пакеты
  - Добавить `StandardResponseDto`
  - Сделать бин на `PasswordEncoder`
5. Сделать Endpoint на регистрацию
  - Делаем `RegistrationApi`
  - Делаем `RegistrationController`
  - Делаем `RegistrationService`
  - Делаем `RegistrationServiceImpl`
  - Делаем `RegisterDto`
  - Делаем `UserDto`
6. Прикрутить валидацию
  - Оставить `dto`
  - Оставить `handler`
7. Проверили через `http`
8. Проверили через `swagger`
9. Написать простой тест:
  - Создать папку `/resources`
  - Создать `application-test.yml` с `In Memory H2`
  - Написать тест, который проверяет статус ответа
10. Сделать контроллер `UsersController` + все пункты 5-9
11. Сделать пакет `handler`
12. Перенести конфигурацию `Swagger`