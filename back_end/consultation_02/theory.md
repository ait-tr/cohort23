## Java Stream API

* Функциональный интерфейс - это интерфейс с одним методом.
* Для такого интерфейса очень просто написать реализацию с помощью анонимного класса.

## Встроенные функциональные интерфейсы и Stream API

* Stream - концепция "потока данных"

* `Predicate<T>` - позволяет описать функцию, которая возвращает true или false для какого-либо объекта
* `Function<T, R>` - позволяет описать функцию, которая возвращает объект типа R, созданный на основе типа T
* `Consumer<T>` - позволяет выполнять операцию над объектом без возврата значения

```
Подготовить файл с записями, имеющими следующую структуру:
[НОМЕР_АВТОМОБИЛЯ]|[МОДЕЛЬ]|[ЦВЕТ]|[ПРОБЕГ]|[СТОИМОСТЬ]

Используя Java Stream API, вывести:

1) Номера всех автомобилей, имеющих черный цвет или нулевой пробег.
2) Количество уникальных моделей в ценовом диапазоне от 700 до 800 тыс.
3) Вывести цвет автомобиля с минимальной стоимостью.
4) Среднюю стоимость Camry
```
