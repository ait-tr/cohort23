## Ссылки

- [пример схемы БД “шахматы”](https://dbdiagram.io/d/64afc55302bd1c4a5e02a76f)
- установка MongoDB
    - [для ОС Windows](https://medium.com/@LondonAppBrewery/how-to-download-install-mongodb-on-windows-4ee4b3493514)
    - [для Mac OS](https://www.mongodb.com/docs/v4.2/tutorial/install-mongodb-on-os-x/)
- [Studio3T (необходимо установить)](https://studio3t.com/download/)

**Примеры**

```sql
-- **Вывести название и стоимость в USD одного самого дорогого проданного товара**
SELECT
		Products.ProductName,
    Products.Price * 1.1 AS Price_usd

FROM OrderDetails
JOIN Products ON OrderDetails.ProductID=Products.ProductID

ORDER BY Products.Price DESC
LIMIT 1
```

```sql
-- **Вывести список стран, которые поставляют морепродукты**
SELECT DISTINCT
	Suppliers.Country

FROM Products

JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID
JOIN Categories ON Products.CategoryID=Categories.CategoryID

WHERE
	Categories.CategoryName='Seafood'
```

```sql
-- **Вывести MAX-стоимость товаров с ценой от 20 до 200 EUR из категории 4**
SELECT
	MAX(Price) AS max_price
FROM Products

WHERE
		Price BETWEEN 20 AND 200
    AND
    CategoryID=4
```

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

**Задача. Вывести ко-во заказов, которое компания `Speedy Express` доставила в `Brazil`**

```sql
SELECT
	COUNT(*) AS total_shipped_to_brazil

FROM Orders

JOIN Shippers ON Orders.ShipperID=Shippers.ShipperID
JOIN Customers ON Orders.CustomerID=Customers.CustomerID

WHERE
		Shippers.ShipperName='Speedy Express'
    AND
    Customers.Country='Brazil'
```

## Группировка в SQL (механизм агрегации) / оператор `GROUP BY`

**Категории запросов**

1. **CRUD** - простые запросы
2. **Aggregation** - получение вычисленных данных

**Группировка** - объединение записей на основе общего признака с целью получения обобщеных данных

**Пример. Вывести страны покупателей**

```sql
SELECT DISTINCT	
	Country
FROM Customers
--

-- вывести количественное распределение клиентов по странам
SELECT
	Country,
	COUNT(*) AS total_customers
FROM Customers

GROUP BY Country

ORDER BY total_customers DESC
```

**Пример. Найти кол. распределение товаров по категориям**

```sql
SELECT
	CategoryID,
	COUNT(*) AS total_products
FROM Products

GROUP BY CategoryID

ORDER BY total_products DESC
```

**Задача. Вывести кол. распределение товаров по поставщикам**

```sql
SELECT
	SupplierID,
	COUNT(*) AS total_products
FROM Products

GROUP BY SupplierID

ORDER BY total_products DESC
```

**Задача. Вывести страну, где больше всего клиентов (проекция: `страна`, `ко_во_клиентов`)**

```sql
SELECT
	Country,
	COUNT(*) AS total_customers
FROM Customers

GROUP BY Country

ORDER BY total_customers DESC
LIMIT 1
```

**Задача. Найти сред/стоимость товара для каждого поставщика (проекция: `название_поставщика`, `сред_стоимость`)**

```sql
SELECT
		Suppliers.SupplierName,
    AVG(Price) AS avg_price
FROM Products

JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID

GROUP BY Suppliers.SupplierID
```

**Задача. Вывести ТОП-1 компанию (и ко-во перевезенных заказов) по количеству доставленных заказов**

(проекция: `название_перевозчика`, `ко_во_заказов`)

```sql
SELECT
		Shippers.ShipperName,
    COUNT(*) AS total_orders
FROM Orders

JOIN Shippers ON Orders.ShipperID=Shippers.ShipperID

GROUP BY Orders.ShipperID

ORDER BY total_orders DESC
LIMIT 1
```

**Задача. Вывести ТОП-3 самых продаваемых товаров (проекция: `название_товара`, `ко_во_продаж`)**

```sql
SELECT
	Products.ProductName,
	SUM(OrderDetails.Quantity) AS sold_count
	
FROM OrderDetails

JOIN Products ON OrderDetails.ProductID=Products.ProductID

GROUP BY OrderDetails.ProductID

ORDER BY sold_count DESC
LIMIT 3
```

**Задача. Вывести стоимость каждого заказа (проекция: `номер_заказа`, `стоимость_заказа`)**

```sql
SELECT
		OrderDetails.OrderID,
    SUM(OrderDetails.Quantity * Products.Price) AS order_cost
FROM OrderDetails

JOIN Products ON OrderDetails.ProductID=Products.ProductID

GROUP BY OrderDetails.OrderID

ORDER BY order_cost DESC
```

**Задача. Расчитать З/П менеджеров (ставка - `5%` от суммы проданных заказов)**

(проекция: `фамилия_менеджера`, `з_п`)

```sql
SELECT
		Employees.LastName,
    SUM(OrderDetails.Quantity * Products.Price) * .05 AS salary
FROM OrderDetails

JOIN Products ON OrderDetails.ProductID=Products.ProductID
JOIN Orders ON OrderDetails.OrderID=Orders.OrderID
JOIN Employees ON Orders.EmployeeID=Employees.EmployeeID

GROUP BY Orders.EmployeeID

ORDER BY salary DESC
```

## Фильтрация агрегированных данных / оператор `HAVING`

- аналог `WHERE`, который позволяет отфильтровать агрегированные данные

**Пример. Вывести страны, где ко-во клиентов - от `10`**

```sql
SELECT
	COUNTRY,
	COUNT(*) AS total_customers
FROM Customers

GROUP BY Country
HAVING
	total_customers >= 10
```

**Задача. Вывести заказы со стоимостью от `10000` EUR**

```sql
SELECT
		OrderDetails.OrderID,
    SUM(OrderDetails.Quantity * Products.Price) AS order_cost
FROM OrderDetails

JOIN Products ON OrderDetails.ProductID=Products.ProductID

GROUP BY OrderDetails.OrderID

HAVING
	order_cost >= 10000

ORDER BY order_cost DESC
```

## Пример схемы БД “Аналог Spotify (потоковое аудио-вещение)”

**Сущности**

1. `users`
2. `playlists`
3. `tracks`
4. `liked_tracks`