create table account
(
    -- столбец id, identity - целое число, которое генерируется базой данных,
    -- primary key - первичный ключ (требует уникальности)
    id identity primary key,

    -- столбец first_name (имя), varchar(20) - текстовая строка с максимальной длиной 20
    first_name varchar(20),

    -- столбец last_name (имя), varchar(20) - текстовая строка с максимальной длиной 20
    last_name  varchar(20)
);