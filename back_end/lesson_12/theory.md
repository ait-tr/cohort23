## Базы данных и ваше приложение

* База данных - это отдельное приложение, с которым ваше Java-приложение взаимодействует через "Connection/Подключение"
* `JDBC` - `Java Database Connectivity` - технология, которая уже встроена в Java и она позволяет "подключаться" к различным базам данных
* `JDBC` - это технология взаимодействия Java-приложения с SQL-базой данных
* Когда вы подключаетесь к какой-либо базе через `JDBC` нужно указать URL для подключения к этой базе. Например:

```
jdbc:h2:mem:tracker_db
```

Он очень похож:

```
https://vk.com/im
https://google.com/search
```

И то и то - это URL, то есть адрес того, к чему мы хотим обратиться.

В случае JDBC:

```
jdbc:h2:mem:tracker_db

jdbc:h2:mem - протокол, по которму будет взаимодействие (аналог http)
tracker_db - название базы данных (аналог im или search)
```

* `datasource` - источник данных, важное понятие JDBC, datasource содержит "подключения к базе данных"

* Когда мы работаем с H2 базой через Spring Boot - он сам создает эту базу с теми данными, которые мы прописали в properties.
* Важный момент - `jdbc:h2:mem` - `in memory`, база данных размещена в оперативной памяти.
* При перезапуске приложения база будет очищена.

* Есть возможность сохранять базу в файле:

```
jdbc:h2:file:~/databases/tracker_db;AUTO_SERVER=TRUE
```

* `jdbc:h2:file:` - говорим, что храним в файле
* `~/databases/tracker_db` - путь к вашей базе данных, `~` - означает папку пользователя.
* `AUTO_SERVER=TRUE` - чтобы можно было подключиться из IntelliJ IDEA (специфичный для H2)
* Важный момент - если по заданному адресу(пути) базы данных еще нет - Spring Boot создаст ее с указанными логином и паролем
* Если база данных уже была - он попытается к ней подключиться.

## Классы для работы с базами данных из Java-приложения

* `JdbcTemplate` - удобный класс (низкоуровневый) для отправки запросов в базу данных и обработки их результатов
* Правило отображения строки таблицы в Java-объект вы описываете самостоятельно:

```
row - строка результирующей таблицы
rowNumber - номер этой строки

jdbcTemplate используя правило, описанное в лябмда-выражении ниже, создаст список Java-объект из набора строк из БД
(row, rowNumber) -> User.builder()
                .id(row.getLong("id"))
                .firstName(row.getString("first_name"))
                .lastName(row.getString("last_name"))
                .build()
```

![image](https://raw.githubusercontent.com/ait-tr/cohort23/main/back_end/lesson_12/img/1.png)