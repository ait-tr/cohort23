
[HTTP](https://drive.google.com/file/d/1ANV322YAIRkPKi3051NYc_BLD0n0vCUp/view?usp=sharing)

## CURL
[Curl Documentation](https://everything.curl.dev/how-to-read)

# The curl reqest example
cURL  is a  command-line tool for transferring data using various network protocols.

```sh
curl  www.google.com

curl -v -L -X GET www.google.com   
```
-send the GET request to www.google.com 


```sh
curl -v -X POST -H "Content-Type: application/json" -d '{"name":"test","salary":"123","age":"23"}' https://dummy.restapiexample.com/api/v1/create
```
-send the POST request to https://dummy.restapiexample.com/api/v1/create. The JSON with new employee will be send in the body of HTTP request.  -H "Content-Type: application/json"  add the header 
to the define request.

-H, --header <header/@file> Pass custom header(s) to server  
-v, --verbose            Make the operation more talkative  
-L, --location           Follow redirects    
-d, --data <data>        HTTP POST data  
  



## Java Spring и SpringBoot

Spring - модульный  фреймворков основанный на JAVA.  Spring предоставляет понятную архитектуру и гибкую, полностью настраиваемую среду  
для слздания приложений для бизнеса (aka enterprise).   
Spring Boot - расширение построенное на платформе Spring предоставляет набор предварительно созданных компонентов для слздания бизнес-приложений. Spring Boot обеспечивает более простой и быстрый способ 
установки, настройки и запуска приложений. Это устраняет сложную настройку конфигурации, которая требуется для настройки большинства приложений на основе Spring.

Spring cостоит из множества проектов, но вот список основных интересных нам для разработки бэкенда

1. [The IoC Container - Inversion of Control (IoC) - Dependency injection (DI)](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/beans.html)
2. [Web MVC framework](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html) - фреймворк для веб-разработки
3. [Data Access](https://docs.spring.io/spring-framework/docs/current/reference/html/data-access.html) - доступ до данных, например до баз данных
4. [Spring Security](https://docs.spring.io/spring-security/reference/index.html) - аутентификация и авторизация. Или проще это про логин, доступ для тех кому разрешено или запрет доступа для тех кому запрещено
5. [Spring Boot](https://spring.io/projects/spring-boot) - надстройка над Spring которая упрощает жизнь



[https://start.spring.io/](https://start.spring.io/)




