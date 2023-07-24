## Ссылки

- [безопасное хранение паролей](https://www.kaspersky.ru/blog/the-wonders-of-hashing/3633/)
- [песочница-онлайн](https://www.w3schools.com/sql/trysql.asp?filename=trysql_select_all)

## Базовый состав типового проекта

- `FE` - интерфейс
    - веб-сайты - человеко-чит.
    - приложения - человеко-чит.
    - `API` (`JSON`/`XML`) - машино-чит.
- `BE` - бизнес-логика
- `**DB` - хранилище**
- `Deployment` - развертывание

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e67e4a82-2b74-4374-83b9-c17c017a217d/Untitled.png)

## Базы данных (Data Bases, DB)

**БД** - **структурированный** набор данных, предназначенный для автоматизированной обработки

- фактически, представляет собой **данные**
- цифровая копия сущностей (объектов) реального мира

**СУБД (DBMS, Data Base Management Software)** - прикладное ПО (приложение)

- Система Управления Базой Данных

## Схема работы с БД (СУБД)

BE → DBMS →BE

## Типы СУБД

- Первичная (primary) - напр., `MySQL`
- Вторичная (secondary) - напр., `Redis`

## Стек (проекта)

- основной набор технологий (программ), которые используются для создания программного продукта

## Модели данных (БД)

Это способ описания (хранения, структурирования) данных

1. Реляционная (табличная) - напр., `MySQL`
2. Документная - `MongoDB`
3. Графовая (теория графов) - `OrientDB`
4. Плоская - `Redis`

## Типы операций в СУБД

- Чтение
- Запись

## Категории операци в СУБД

1. `CRUD` (Create Read Update Delete) - более простые
2. Aggregation (аналитика, итоги, статистика) - вычисленных данных

## Способы подключения к СУБД

1. Из программного кода (`BE`) - целевой способ
2. Из `GUI/CLI`-клиентов - вспомогательный способ

## SQL: CRUD

- `SQL` - язык структурированных запросов
- Как правило, применяется в реляционных СУБД

## Проекция полей (в БД)

- инструмент оптимизации запросов для
    - уменьшение времени выполнения запроса
    - снижение нагрузки на выч/ресурсы

**Read**

`SELECT`

`SELECT DISTINCT` (только уникальные значения)

**Примеры**

```sql
-- выбрать имена и страны клиентов
SELECT
		CustomerName,
    Country -- проекция (полей)
FROM Customers
```

```sql
-- вывести страны клиентов
SELECT DISTINCT
	Country -- проекция
FROM Customers
```

**Задача. Вывести информацию о поставщиках**

(проекция: `название_компании`, `страна`)

```sql
SELECT
		SupplierName, -- проекция
    Country
FROM Suppliers
```

## Фильтрация в SQL / Оператор `WHERE`

**Пример. Вывести клиентов из `Germany`**

```sql
SELECT * -- проекция полей
FROM Customers
WHERE
	Country='Germany' -- фильтрация по стране
```

**Задача. Вывести город и почтовый индекс клиентов из `France`**

```sql
SELECT
		City,
    PostalCode -- проекция
FROM Customers
WHERE
	Country='France' -- фильтрация
```

## Логические операторы в SQL (приоритет - сверху вниз)

- `NOT` логическое отрицание (унарный)
- `AND` логическое И (бинарный)
- `OR` логическое ИЛИ (бинарный)

**Пример. Вывести клиентов не из `Germany`**

```sql
SELECT *
FROM Customers
WHERE
	NOT Country='Germany'
```

**Пример. Вывести товары с ценой от `50` до `100` EUR**

```sql
SELECT *
FROM Products
WHERE
		Price >= 50
    AND
    Price <= 100
```

**Задача. Вывести клиентов из `Germany` и `France`**

```sql
SELECT *
FROM Customers
WHERE
		Country='Germany'
    OR
    Country='France'
```

**Задача. Вывести клиентов, кроме тех, что из `UK` и `USA`**

```sql
SELECT *
FROM Customers
WHERE
	NOT Country='UK'
	AND
	NOT Country='USA'
```

## Оператор `IN`

- проверка принадлежности к списку значений

```sql
SELECT *
FROM Customers
WHERE
		Country='Germany'
    OR
    Country='France'
--

SELECT *
FROM Customers
WHERE
	Country IN ('Germany', 'France')
```

```sql
SELECT *
FROM Customers
WHERE
	NOT Country='UK'
	AND
	NOT Country='USA'
--
SELECT *
FROM Customers
WHERE
	NOT Country IN ('UK', 'USA')
```

**Задача. Вывести название и стоимость товаров из категорий `1` и `3` со стоимостью до `50` EUR**

```sql
SELECT
		ProductName,
    Price
FROM Products
WHERE
		CategoryID IN (1, 3)
    AND
    Price <= 50
```

**Задачи. Вывести товары с ценой от `80` до `190` EUR не из категории `5`**

```sql
SELECT *
FROM Products
WHERE
		Price >= 80 AND Price <= 190
    AND
    NOT CategoryID=5
```

### Операторы сравнения

`=` равно

`!=` `<>` не равно

`>`больше

`<`меньше

`>=` больше или равно

`<=` меньше или равно

### Сортировка в SQL / Оператор `ORDER BY`

```sql
SELECT *
FROM Products
ORDER BY Price ASC
-- ASC по возрастанию (по умолчанию)
-- DESC по убыванию
```

## Лимитирование вывода / Оператор `LIMIT`

```sql
SELECT *
FROM Products
ORDER BY Price ASC
LIMIT 10 OFFSET 0 -- для первой страницы
-- LIMIT 10 OFFSET 10 -- для второй страницы
```

**Пример. Вывести ТОП-3 дорогих товаров**

```sql
SELECT *
FROM Products
ORDER BY Price DESC
LIMIT 3
```

**Задача. Вывести название и стоимость самого дорогого товара из категории `1`**

```sql
SELECT
		ProductName, -- проекция
   	Price        -- полей
FROM Products

WHERE
	CategoryID=1   -- фильтрация

ORDER BY Price DESC -- сортировка
LIMIT 1             -- лимитирование
```

### Псевдонимы в SQL / Оператор `AS`

```sql
SELECT
	Price AS Price_eur,
	ProductName
FROM Products
```

```sql
SELECT *,
	Price * 1.1 AS Price_usd
FROM [Products]
```

```sql
SELECT *,
	Price * 0.95 AS Price_down
FROM [Products]
```

**Задача. Вывести названия товаров, а также их стоимость:**

- полную
- со скидкой в `25%`
- с наценкой в `15%`

```sql
SELECT
		ProductName,
    Price AS Price_full,
    Price * .75 AS Price_low,
    Price * 1.15 AS Price_up
FROM Products
```

**Задача. Вывести название и стоимость со скидкой в `0.5%` самого дешевого товара из `4` категории** 

```sql
SELECT
		ProductName, -- проекция
    Price * .995 AS Price_down
FROM Products

WHERE
	CategoryID=4   -- фильтрация

ORDER BY Price ASC -- сортировка
LIMIT 1 -- лимитирование
```

## Поиск по шаблону / Оператор `LIKE`

- поиск по нестрогому соответствию

```sql
SELECT *
FROM Customers

WHERE
	Country LIKE 'usa'
```

**Базовые подстановочные символы (знаки)**

- `%` нулевой, один или несколько символов
- `_` один символ

**Пример. Вывести клиентов, имя которых начинается с `T`**

```sql
SELECT *
FROM Customers
WHERE
	CustomerName LIKE 't%'
```

**Пример. Вывести клиентов по части имени `eds`**

```sql
SELECT *
FROM Customers
WHERE
	CustomerName LIKE '%eds%'
```

**Задача. Вывести всех сотрудников, у которых в фамилии есть вхождение `ler`**