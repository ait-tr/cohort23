## 01. Ответ вопрос "Терминология Spring, Spring Boot и т.д."

![image](https://raw.githubusercontent.com/ait-tr/cohort23/main/back_end/consultation_03/img.png)

1. Spring - фреймворк для "автосвязывания бинов" - ApplicationContext (контейнер бинов).
2. Spring Boot - тоже фреймворк, "надстройка"/переосмысление Spring - добавили возможность автоконфигураций и получили Spring Boot - позволяет просто запускать веб-приложение и подключаться к базе данных, @SpringBootApplication
3. REST API/REST/RESTful - способ описания HTTP-методов сервера для взаимодействия к клиентами. Основные моменты:
   - Использование HTTP-методов GET, POST, PUT, DELETE
   - возврат статусов ответов - 200 OK, 201 СREATED, 404 - NOT FOUND, 400 - Bad Request
   - именование URL - /users, users/1, users/1/friends
4. Spring Web - библиотека-фреймворк содержит аннотации для работы с WEb и реализацией MVC/Rest.
5. Spring Data JPA - библиотека-фреймворк для работы с JpaRepository

## 02. DTO

* DTO - Data Transfer Object, понятие. Объект передачи данных. 
* Например, у вас есть entity/domain/model User (id, firstName, lastName, password, email).
* Клиент (браузер/фронтэнд/мобильное приложение) хочет получить информацию о пользователе
* Но, вы не хотите передавать его пароль, а имя и фамилию клиент отображает как одно поле.
* То есть, те данные, которые есть у вас, и те данные, которые нужны клиенту - разные
* Создаем класс UserDto (id, name, email). При этом делаем метод, который превращает User -> UserDto

## 03. OneToMany, ManyToOne

* Как правильно расставить аннотации
* Есть курс, а есть уроки.
* В одном курсе - много уроков. Но у урока - только один курс.
* Опишем классы без аннотаций:

```java
import java.time.LocalTime;

class Course {
    @Id
    private Long id;
    private String title;
    private String description;

    private List<Lesson> lessons;
}

class Lesson {
    @Id
    private Long id;
    private String name;
    private LocalTime startTime;
    private LocalTime finishTime;
    
    private Course linkedCourse;
}
```

* С точки зрения ООП мы описали наши классы - все ок.
* Надо подумать, как это будет выглядеть в таблицах БД:
* В таблице LESSON будет "внешний ключ/foreign key" который ссылается на конкретный id курса - `linked_course_id`
* Ставим аннотацию в "зависимой" сущности, т.е. той, которой "много", у которой должен быть внешний ключ:

```java
class Lesson {
    private Long id;
    private String name;
    private LocalTime startTime;
    private LocalTime finishTime;
    
    @ManyToOne
    @JoinColumn(name = "linked_course_id")
    private Course linkedCourse;
}
```

* Сгенерируется SQL - "FOREIGN KEY(linked_course_id) references COURSE (id)"
* Аналогично прописываем у главной сущности, той, которая "одна", указываем название поля в "зависимой сущности" :

```java
class Course {
    @Id
    private Long id;
    private String title;
    private String description;

    @OneToMany(mappedBy = "linkedCourse")
    private List<Lesson> lessons;
}
```

* Как писать методы репозитория:

```java
interface LessonsRepository {
    // получить все уроки по курсу
    List<Lesson> findAllByLinkedCourse(Course course);
    // получить все уроки по id курса, к которому они привязаны
    List<Lesson> findAllByLinkedCourse_Id(Long courseId);
}
```