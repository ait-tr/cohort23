1. Добавление сущности при связи "ОдинКоМногим"/"МногиеКОдному"

Нужно добавлять через сущность, в которой описан "@JoinColumn"

2. Добавление сущности при связи "МногиеКоМногим"

Например, во многих курсах может быть много студентов, во многих студентах может быть много курсов
Нужно добавлять через сущность, в которой описан "@JoinTable"

Здесь:

```
class Course {
    @ManyToMany(mappedBy = "courses")
    private List<User> students;
}

class User {
    @ManyToMany
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    private List<Course> courses;
}
```

* Не сработает:

```
course.getStudents.add(student);
```

* Сработает:

```
student.getCourses().add(course);
```

### Администратор

* Хочет посмотреть страницу с курсами

`GET /api/courses`

* Хочет добавить новый курс:

`POST /api/courses`

* Захочет провалиться в курс и посмотреть о нем информацию:

```
GET /api/courses/{course-id}
GET /api/courses/{course-id}/students
GET /api/courses/{course-id}/lessons
```

* Захочет изменить информацию о курсе

`PUT /api/courses/{course-id}`

* Захочет добавить студента:

```
GET /api/users/students?notInCourse={course-id}
POST /api/courses/{course-id}/students
```

* Захочет добавить урок

```
POST /api/lessons

GET /api/lessons/withoutCourse

POST /courses/{course-id}/lessons
```

* Захочет удалить пользователя

```
DELETE /users/{user-id}
```

### Незарегистрированный пользователь

* Регистрация

```
POST /api/register
```

### Любой аутентифицированный пользователь

* Посмотреть информацию о себе

```
GET /api/users/me
```

* Удалить свой профиль

```
DELETE /api/users/me
```

### Заметки

* `@Transactional` - как правило, помечаем данной аннотацией метод в сервисе. Позволяет откатить изменения базы, если в методе произошла ошибка.
* У `@Transactional` есть побочный эффект, метод делает изменения в базе, только после return, когда все прошло хорошо.
* До этого момента мы не можем получить актуальные изменения из базы и некоторые вещи нужно делать руками.