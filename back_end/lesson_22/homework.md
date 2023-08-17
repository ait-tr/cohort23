# Задание

* Реализовать:

### Работа с уроками

* Добавить урок в систему

`POST /lessons`

* Редактировать урок:

`PUT /lessons`

* Посмотреть список всех уроков, которые не в курсе

`GET /lessons?notInCourse={course-id}`

* Добавить урок в курс

`POST /courses/{course-id}/lessons`

* Получить все уроки курса:

`GET /courses/{course-id}/lessons`
