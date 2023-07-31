## Ключевые поля в БД

- **первичный ключ** - идентификатор каждой сущности (объекта)
- **внешний ключ** - поле для связи между таблицами

**Задача. Вывести название и стоимость в `USD` одного самого дорогого проданного товара**

```sql
SELECT
		Products.ProductName,
    Products.Price * 1.1 AS Price_usd

FROM OrderDetails
JOIN Products ON OrderDetails.ProductID=Products.ProductID

ORDER BY Products.Price DESC
LIMIT 1
```

**Задача. Вывести два самых дорогих товара из категории `Beverages` из `USA`**

```sql
SELECT *
FROM Products

JOIN Categories ON Products.CategoryID=Categories.CategoryID
JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID

WHERE
	Categories.CategoryName LIKE 'beverages'
	AND
	Suppliers.Country LIKE 'usa'

ORDER BY Products.Price DESC
LIMIT 2
```

**Задача. Вывести список стран, которые поставляют морепродукты**

```sql
SELECT DISTINCT
	Suppliers.Country

FROM Products

JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID
JOIN Categories ON Products.CategoryID=Categories.CategoryID

WHERE
	Categories.CategoryName='Seafood'
```

## Агрегация данных в SQL

**Базовые категории запросов**

1. **CRUD** - более простые запросы
2. **Aggregation** - получение вычисленных данных (итоги, статистика, аналитика)

**Базовые операторы агрегации**

- `COUNT()` расчет ко-ва строк
- `AVG()` расчет сред/ариф. знач.
- `MAX()` расчет макс. значения
- `MIN()` расчет мин. значения
- `SUM()` расчет суммы

**Пример. Найти ко-во клиентов**

```sql
-- общее
SELECT
	COUNT(*) AS total_customers
FROM Customers

-- из Germany
SELECT
	COUNT(*) AS total_customers
FROM Customers

WHERE
	Country='Germany'
```

**Пример. Найти среднюю стоимость товаров**

```sql
SELECT
	AVG(Price) AS avg_price
FROM Products
```

**Пример. Вывести статистику по товарам**

```sql
SELECT
	AVG(Price) AS avg_price,
	MIN(Price) AS min_price,
	MAX(Price) AS max_price,
	COUNT(*) AS total_products,
	SUM(Price) as products_sum
FROM Products
```

**Задача. Вывести ко-во поставщиков из `USA`**

```sql
SELECT
	COUNT(*) AS usa_suppliers
FROM Suppliers

WHERE
	Country='USA'
```

**Задача. Вывести ко-во поставщиков из `USA`, `UK`, `Japan`**

```sql
SELECT
	COUNT(*) AS total_suppliers
FROM Suppliers

WHERE
	Country IN ('USA', 'UK', 'Japan')
```

**Задача. Вывести среднюю стоимость товаров до `150` EUR**

```sql
SELECT
	AVG(Price) AS avg_price
FROM Products

WHERE
	Price <= 150
```

**Задача. Вывести MAX-стоимость товаров с ценой от `20` до `200` EUR из категории `4`**

```sql
SELECT
	MAX(Price) AS max_price
FROM Products

WHERE
		Price BETWEEN 20 AND 200
    AND
    CategoryID=4
```

**Задача. Вывести ко-во поставщиков не из `USA` и не из `Spain`**

```sql
SELECT
	COUNT(*) AS total_not_usa_spain_suppliers
FROM Suppliers

WHERE
	NOT Country IN ('USA', 'Spain')
```

**Задача. Вывести сред/стоимость товаров из категорий `1, 2, 5`, у которых название начинается с `t`**

```sql
SELECT
	AVG(Price) AS avg_price
FROM Products

WHERE
	CategoryID IN (1, 2, 5)
	AND
	ProductName LIKE 't%'
```

**Задача. Посчитать стоимость заказа `10248`**

```sql
SELECT
	SUM(Products.Price * OrderDetails.Quantity) AS order_cost
FROM OrderDetails

JOIN Products ON OrderDetails.ProductID=Products.ProductID

WHERE
	OrderDetails.OrderID=10248
```

**Задача. Вывести среднюю стоимость товаров от поставщика `3`**

(проекция: `название_поставщика`, `сред_стоимость_товаров`)

```sql
SELECT
	Suppliers.SupplierName,
	AVG(Products.Price) AS avg_price
FROM Products

JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID

WHERE
	Suppliers.SupplierID=3
```

**Задача. Вывести среднюю стоимость напитка из `USA`**

```sql
SELECT 
	AVG(Products.Price) AS avg_price

FROM Products

JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID
JOIN Categories ON Products.CategoryID=Categories.CategoryID

WHERE
	Categories.CategoryName='Beverages'
	AND
	Suppliers.Country='USA'
```

**Задача. Вывести `ко-во заказов`, которое оформил клиент `1`**

```sql
SELECT
	COUNT(*) AS total_orders
FROM Orders

WHERE
	CustomerID=1
```

**Задача. Вывести, сколько раз был продан товар `72`**

```sql
SELECT
	COUNT(*) AS sold_count
FROM OrderDetails

WHERE
	ProductID=72
```

**Задача. На какую сумму было отправлено товаров клиентам из `USA`**

```sql
SELECT
	SUM(Products.Price * OrderDetails.Quantity) AS total_sold_to_usa

FROM OrderDetails

JOIN Orders ON OrderDetails.OrderID=Orders.OrderID
JOIN Customers ON Orders.CustomerID=Customers.CustomerID
JOIN Products ON OrderDetails.ProductID=Products.ProductID

WHERE
	Customers.Country='USA'
```

**Задача. Вывести ко-во заказов, которое компания `Speedy Express` доставила в `Brazil`**

```sql
Д/З
```

## **Пример схемы БД “онлайн-игра: шахматы”**

**Сущности**

1. `players`
    - перв/ключ
    - дата/время создания
    - псевдоним
    - статус блокировки (is_blocked)
2. `matches` матчи (партии)
3. `messages`
4. `chats`
5. `maps`