## Ссылки

- [пример схемы БД “песочница: онлайн-магазин”](https://dbdiagram.io/d/64c0f3cb02bd1c4a5eb927a2)

## SQL - файл

Текстовый файл с SQL-запросами

```sql
-- homework.sql
-- Задача 1. Вывести ..
SELECT *
FROM Customers;
```

## SQL: CRUD

- **Create**
    - `INSERT INTO`
- **Read**
    - `SELECT`
    - `SELECT DISTINCT`
- **Update**
    - `UPDATE`
- **Delete**
    - `DELETE FROM`
    
    ![Screenshot from 2023-07-26 11-52-41.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a569eab8-96a1-4184-a66a-88f3444d6df3/Screenshot_from_2023-07-26_11-52-41.png)
    
    **Задача. Вывести номер и дату самого последнего заказа**
    
    ```sql
    SELECT
    		OrderID,
        OrderDate
    FROM Orders
    
    ORDER BY OrderDate DESC
    
    LIMIT 1
    ```
    
    **Задача. Вывести имена и фамилии сотрудников, у которых в фамилии есть вхождение строки `lio`**
    
    ```sql
    SELECT
    		FirstName,
        LastName
    FROM Employees
    WHERE
    	LastName LIKE '%lio%'
    ```
    
    **Задача. Вывести три самых дешевых товара с ценой от `50` до `150` из категорий `3` и `6`**
    
    ```sql
    SELECT *
    FROM Products
    
    WHERE
    		Price >= 50 AND Price <= 150
        AND
        CategoryID IN (3, 6)
    
    ORDER BY Price ASC
    LIMIT 3
    ```
    
    ## Работа с диапазоном значений / оператор `BETWEEN`
    
    **Пример. Выбрать товары по диапазону цены**
    
    ```sql
    -- без оператора BETWEEN
    SELECT *
    FROM Products
    WHERE
    		Price >= 100
        AND
        Price <= 200
    
    -- с BETWEEN
    SELECT *
    FROM Products
    WHERE
    		Price BETWEEN 100 AND 200
    ```
    
    **Задача. Вывести товары из категории `1` и `5` с ценой от `10` до `150` EUR**
    
    ```sql
    SELECT *
    FROM Products
    WHERE
    		Price BETWEEN 10 AND 150
    		AND
    		CategoryID IN (1, 5)
    ```
    
    ## SQL CRUD: Delete / удаление записей / Оператор `DELETE FROM`
    
    **Пример. Удалить указанных клиентов**
    
    ```sql
    DELETE FROM Customers
    WHERE
    	CustomerID IN (1, 2, 4)
    ```
    
    ### Первичный ключ в БД / PRIMARY KEY
    
    Это поле, которое однозначно идентифицирует каждую запись
    
    - в качестве значения используют
        - авто-инкремент
        - случайные значения (стандарт `UUID` и т.д.)
        
    
    **Свойства:**
    
    - уникальность
    - непустой
    - неизменяемость
    
    ## САМАЯ РАСПРОСТРАНЕННАЯ АРХИТЕКТУРА ХРАНЕНИЯ ДАННЫХ
    
    - **ОДИН ОБЪЕКТ (СУЩНОСТЬ) == ОДНА ЗАПИСЬ**
    
    ## SQL CRUD: Update / модификация / Оператор `UPDATE`
    
    **Пример**
    
    ```sql
    -- очистить имя клиента 1
    UPDATE Customers
    SET CustomerName=''
    WHERE
    	CustomerID=1
    ```
    
    ```sql
    UPDATE Customers
    SET
    		CustomerName='',
        ContactName=''
    WHERE
    	CustomerID=1
    ```
    
    **Задача. Для поставщиков из `Japan` и `Spain` изменить телефон и контактное имя на произвольные значения**
    
    ```sql
    UPDATE Suppliers
    SET
    	ContactName='Ivan Ivanov',
    	Phone='0000000000'
    WHERE
    	Country IN ('Japan', 'Spain')
    ```
    
    **Задача. У всех товаров от `50` до `60` (EUR) очистить `название` и установить `категорию 2`**
    
    ```sql
    UPDATE Products
    SET
    		ProductName='',
    	  CategoryID=2
    WHERE
    	Price BETWEEN 50 AND 60
    ```
    
    ## Внешний ключ (FOREIGN KEY)
    
    - поле для связи между таблицами
    
    ## Горизонтальное объединение таблиц / Оператор `JOIN`
    
    - синтаксис `JOIN`
    
    ```sql
    SELECT <проекция>
    FROM <таблица_1>
    JOIN <таблица_2> ON <таблица_1.внешний_ключ>=<таблица_2.первичный_ключ>
    ```
    
    **Пример. Вывести информацию о товарах и их поставщиках**
    
    (проекция: `название_товара`, `стоимость_товара`, `название_компании_поставщика`)
    
    ```sql
    SELECT
    		Products.ProductName,
        Products.Price,
        Suppliers.SupplierName
    FROM Products
    
    JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID
    ```
    
    **Пример. Вывести информацю о заказах**
    
    ```sql
    SELECT *
    FROM Orders
    
    JOIN Customers ON Orders.CustomerID=Customers.CustomerID
    JOIN Employees ON Orders.EmployeeID=Employees.EmployeeID.
    ```
    
    **Пример. Вывести информацию о заказах из `Germany`**
    
    ```sql
    SELECT *
    FROM Orders
    
    JOIN Customers ON Orders.CustomerID=Customers.CustomerID
    
    WHERE
    	Customers.Country='Germany'
    ```
    
    **Задача. Вывести все заказы, которые повезет `Speedy Express`**
    
    ```sql
    SELECT * 
    FROM Orders
    
    JOIN Shippers ON Orders.ShipperID=Shippers.ShipperID
    ****
    WHERE
    	Shippers.ShipperName='Speedy Express'
    ```
    
    **Задача. Вывести информацию о товарах:**
    
    - `название_товара`
    - `стоимость_товара_в_долларах`
    - `название_категории`
    
    ```sql
    SELECT
    		Products.ProductName,
        Products.Price * 1.1 AS Price_usd,
        Categories.CategoryName
    
    FROM Products
    
    JOIN Categories ON Products.CategoryID=Categories.CategoryID
    ```
    
    **Задача. Вывести информацию о товарах с ценой от `10` до `150` EUR, которые были поставлены из `Japan`:**
    
    - `название_товара`
    - `цена_товара`
    - `цена_со_скидкой_15_процентов`
    - `название_поставщика`
    
    ```sql
    SELECT
    		Products.ProductName,
        Products.Price AS Price_full,
        Products.Price * .85 AS Price_discounted,
        Suppliers.SupplierName
    
    FROM Products
    
    JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID
    
    WHERE
    	Suppliers.Country ='Japan'
    	AND
    	Products.Price BETWEEN 10 AND 150
    ```
    
    **Задача. Вывести заказы клиентов из `USA`, `Germany`, `UK`**
    
    - `номер_заказа`
    - `полное_имя_клиента`
    - `страна_клиента`
    - `имя_менеджера`
    - `фамилия_менеджера`
    
    ```sql
    SELECT
    	Orders.OrderID,
    	Customers.CustomerName,
    	Customers.Country,
    	Employees.FirstName,
    	Employees.LastName 
    
    FROM Orders
    
    JOIN Customers ON Orders.CustomerID=Customers.CustomerID
    JOIN Employees ON Orders.EmployeeID=Employees.EmployeeID
    ****
    WHERE
    	Customers.Country IN ('Germany', 'UK', 'USA');
    ```
    
    ## Семантическое версионирование (SemVer)
    
    - Методология (де-факто пром/стандарт) нумерации версий проекта (версионирование)
    
    ### v`MAJOR`.`MINOR`.`PATCH`
    
    `PATCH` - исправление багов, прочие мелкие правки
    
    `MINOR` - улучшения (без нарушения обратной совместимости)
    
    `MAJOR` - координальные изменения (с нарушением обратной совместимости)
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b0a30caa-382b-4f5b-bad8-845170131240/Untitled.png)
    
    **Контрольные вопросы по SemVer**
    
    1. Какой будет след/версия, если был добавлен новый функционал?
        
        **`v3.5.4` →v3.6.0**
        
    2. Какой будет след/версия, если было исправлено три бага?
    `**v8.2.6` →v8.2.7**
    3. Какой будет след/версия, если приложение было полностью переработано?
    `**v8.2.6` →v9.0.0**