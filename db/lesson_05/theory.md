## Базовые термины

- **рефакторинг (кода)** - перевыпуск (переработка) кода
- **алгоритм** - способ (идея) решения проблемы
- **программа** - реализация алгоритма
- **стек (проекта)** - набор технологий (инструментов) для создания проекта
- **проект** - кодовая база (как пример)

**Примеры запросов**

```sql
SELECT *
FROM Customers
WHERE
	Country IN ('Germany', 'USA')
	-- Country='Germany'
	-- OR
	-- Country='USA'
```

```sql
-- Вывести ТОП-1 компанию (и ко-во перевезенных заказов) по количеству доставленных заказов
SELECT
		Shippers.ShipperName,
    COUNT(*) AS total_orders
FROM Orders

JOIN Shippers ON Orders.ShipperID=Shippers.ShipperID

GROUP BY Orders.ShipperID

ORDER BY total_orders DESC
LIMIT 1
```

```sql
-- Вывести ТОП-3 самых продаваемых товаров (проекция: название_товара, ко_во_продаж)
SELECT
	Products.ProductName,
	SUM(OrderDetails.Quantity) AS sold_count
	
FROM OrderDetails

JOIN Products ON OrderDetails.ProductID=Products.ProductID

GROUP BY OrderDetails.ProductID

ORDER BY sold_count DESC
LIMIT 3
```

```sql
-- Вывести название и стоимость в USD одного самого дорогого проданного товара
SELECT
		Products.ProductName,
    Products.Price * 1.1 AS Price_usd

FROM OrderDetails
JOIN Products ON OrderDetails.ProductID=Products.ProductID

ORDER BY Products.Price DESC
LIMIT 1
```

```sql
-- Вывести список стран, которые поставляют морепродукты
SELECT DISTINCT
	Suppliers.Country

FROM Products

JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID
JOIN Categories ON Products.CategoryID=Categories.CategoryID

WHERE
	Categories.CategoryName='Seafood'
```

```sql
-- Вывести сумму проданного товара в `USA`
SELECT
	SUM(Products.Price * OrderDetails.Quantity) AS total_sold_to_usa

FROM OrderDetails

JOIN Orders ON OrderDetails.OrderID=Orders.OrderID
JOIN Customers ON Orders.CustomerID=Customers.CustomerID
JOIN Products ON OrderDetails.ProductID=Products.ProductID

WHERE
	Customers.Country='USA'
```

## Масштабирование (проекта)

- увеличение выч/мощностей по мере увеличения роста нагрузки

**Виды**

- вертикальное (качество)
- горизонтальное (количество)

## MongoDB: документо-ориентированная (документная) СУБД

### **Принципиальные отличия MongoDB от RDBMS**

1. используется собственный язык запросов (NoSQL -`Query API`)
2. документная модель данных (не табличная)
3. динамическая схема данных (без схемы, `schemaless`) - каждый документ может содержать свой набор полей
4. для хранения используется `JSON` и `Binary JSON` (`BSON`)
5. позволяет хранить вложенные структуры данных
6. имеет встроенную поддержку масштабирования

## Базовые структуры данных

1. Скаляр (скалярное значение)
2. Массив (список значений)
3. Ассоц/массив (карта, пары ключ-значение)
4. Множество (список **уникальных** значений)

## MongoDB: CRUD

**Create**

- `insertOne()` добавить один документ
    - один аргумент
        - ассоц/массив (объект)
- `insertMany()` добавить несколько документов
    - один аргумент
        - массив ассоц/массивов

**Read**

- `findOne()` найти (выбрать) один документ
- `find()` найти (выбрать) несколько документов
    - аргументы
        - `filter`
        - `projection`
- `countDocuments()` ко-во совпадений
    - аргументы
        - `filter`

**Update**

- `updateOne()` изменить один документ
- `updateMany()` изменить несколько документов
    - аргументы
        - `filter`
        - `action`

**Delete**

- `deleteOne()` удалить один документ
- `deleteMany()` удалить несколько документов
    - аргументы
        - `filter`
    
    ![Screenshot from 2023-08-14 12-44-47.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c47e663b-4b0a-4498-9d7e-bc93c809f021/Screenshot_from_2023-08-14_12-44-47.png)
    
    **Пример. Добавить несколько пользователей**
    
    ```jsx
    db.users.insertMany([
        {_id: 1, fullname: 'Ivan Ivanov', country: 'Germany'},
        {_id: 2, fullname: 'Petr Petrov', country: 'USA'},
        {_id: 3, fullname: 'Sidr Sidorov', country: 'China'}
    ])
    ```
    
    **Пример. Добавить несколько товаров**
    
    ```jsx
    db.products.insertMany([
        {_id: 1, title: 'Product 1', price: 100},
        {_id: 2, title: 'Product 2', price: 150},
        {_id: 3, title: 'Product 3', price: 200}
    ])
    ```
    
    **Пример. Вывести всех юзеров**
    
    ```jsx
    db.users.find()
    ```
    
    **Пример. Вывести всех юзеров из `Germany`**
    
    ```jsx
    db.users.find(
        { country: 'Germany' } // filter
    )
    ```
    
    **Пример. Вывести имена юзеров из `Germany`**
    
    ```jsx
    db.users.find(
        { country: 'Germany' }, // filter
        { fullname: 1, _id: 0 } // projection
    )
    ```
    
    **Пример. Вывести имена всех юзеров**
    
    ```jsx
    db.users.find(
        {}, // filter
        { fullname: 1, _id: 0 } // projection
    )
    ```
    
    **Пример. Вывести имя юзера `1`**
    
    ```jsx
    db.users.findOne(
        { _id: 1 }, // filter
        { fullname: 1, _id: 0 } // projection
    )
    ```
    
    ## Основные операторы модификации
    
    - `$set` установить поля
    - `$unset` удалить (снять) поля
    - `$inc` инкремент значений
    - `$mul` умножение
    - `$push` добавить элементы в массив
    - `$addToSet` добавить элементы в множество
    - `$pull` удалить элементы из массива
    - `$pullAll` удалить несколько элементов из массива
    - `$each` (используется в связке c `$push` и `$addToSet`)
    
    **Пример. Заблокировать юзера `1`**
    
    ```jsx
    db.users.updateOne(
        { _id: 1 }, // filter
        { $set: { is_blocked: true } } // action
    )
    ```
    
    **Пример. Вывести заблокированных юзеров**
    
    ```jsx
    db.users.find(
        { is_blocked: true } // filter
    )
    ```
    
    ## Операторы сравнения
    
    `$eq` равно (equal)
    
    `$ne` не равно (not equal)
    
    `$gt` больше (greater than)
    
    `$gte` больше или равно (greater than or equal)
    
    `$lt` меньше (less than)
    
    `$lte` меньше или равно (less than or equal)
    
    **Пример. Вывести незаблокированных юзеров**
    
    ```jsx
    db.users.find(
        { is_blocked: { $ne: true } } // filter
    )
    ```
    
    **Задача. Вывести имена юзеров из `China`**
    
    ```jsx
    db.users.find(
        { country: 'China' }, // filter
        { fullname: 1, _id: 0 } // projection
    )
    ```
    
    **Задача. Вывести названия всех товаров**
    
    ```jsx
    db.products.find(
        {},
        { title: 1, _id: 0 }
    )
    ```
    
    **Пример. Вывести товары с ценой до `500` EUR**
    
    ```jsx
    db.products.find(
        { price: { $lte: 500 } }
    )
    ```
    
    **Задача. Вывести названия и стоимость товаров от `150` EUR**
    
    ```jsx
    db.products.find(
        { price: { $gte: 150 } },
        { _id: 0 }
    )
    ```
    
    **Задача. Вывести товары с ценой от `150` до `200` EUR**
    
    ```jsx
    db.products.find(
        { price: { $gte: 150, $lte: 200 } }
    )
    ```
    
    **Пример. Увеличить стоимость на `50` EUR для товара `1`** 
    
    ```jsx
    db.products.updateOne(
        { _id: 1 }, // filter
        { $inc: { price: 50 } } // action
    )
    ```
    
    **Задача. Применить скидку в `25%` ко всем товарам**
    
    ```jsx
    db.products.updateMany(
        {}, // filter
        { $mul: { price: .75 } } // action
    )
    ```
    
    **Задача. Увеличить стоимость на `0.5%` для товаров с ценой от `10` до `300` EUR**
    
    ```jsx
    db.products.updateMany(
        { price: { $gte: 10, $lte: 300 } }, // filter
        { $mul: { price: 1.005 } } // action
    )
    ```
    
    **Задача. Разблокировать всех юзеров, кроме тех, что из `Spain`**
    ```jsx
// вар. 1
db.users.updateMany(
    { country: { $ne: 'Spain' } }, // filter
    { $set: { is_blocked: false } } // action
)
// вар. 2
db.users.updateMany(
    { country: { $ne: 'Spain' } }, // filter
    { $unset: { is_blocked: null } } // action
)
```