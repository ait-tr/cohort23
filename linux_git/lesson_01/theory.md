### Проект - кодовая база

### Базовый состав любого проекта

1. `BE` - бизнес-логика
2. `FE` - интерфейс
    1. веб-сайты  - человеко-чит.
    2. приложения (вкл. моб) - человеко-чит.
    3. `API` - машино-чит.  (`JSON`/`XML`)
3. `DB` - хранилище
4. `Deployment` - развертывание ←Linux

### КЛИЕНТ-СЕРВЕРНАЯ АРХИТЕКТУРА

По сути, взаимодействие “ЗАПРОС-ОТВЕТ”

**Роли**

1. Клиент (активная роль) - выполняет запросы
2. Сервер (пассивная роль) - получает и обрабатывает запросы



### Базовые выч/ресурсы

1. Процессорное время
2. Оперативная память
3. Постоянно-запом. уст-во
4. Сетевая подсистема



### Linux - операционная система с открытым исходным кодом

**Linux** - семейство операционных система

Является самой распространенной ОС для серверов

### Программные интерфейсы

1. **`GUI (Graphical User Interface)**` - графический интерфейс пользователя
2. `**CLI (Command Line Interface)**` - интерфейс комадной строки

### GIT/GITHUB

**GIT** - прикладное ПО (приложение) - система контроля версий

- командная работа
- Source code management
- “машина времени” (откат до определенной версии)

**GitHub** - интернет-площадка (позволяет поделиться кодом и т.д.)

### Работа с Git/GitHub

1. **Подготовительный этап**
    - (для ОС Windows) установка на компьютер [https://git-scm.com/downloads](https://git-scm.com/downloads)
    - настройка **Git** на компьютере
        - `git config --global user.name 'Ivan Ivanov'` настройки имени
        - `git config --global user.email 'user@example.org'` настройка почты
        - `**git config --global -l`** посмотреть текущие настройки
    - наличие аккаунта на **GitHub**
    - выгрузить публичный ключ на **GitHub**
        - `ssh -T git@github.com` проверить, что ключ выгружен
        - `cat ~/.ssh/id_rsa.pub` просмотр публичного ключа (если нет, надо сгенерировать)

### Базовый порядок работы с GIT/GITHUB

Как создать и выгрузить репо на GitHub

1. `git init` создать пустой репо (выполняется один раз для нового проекта)
    1. **репозиторий** - файловая БД с историей изменений по проекту (`.git/`)
2. `**git add .**` “поставить все файлы проекта на контроль” / добавить файлы в индекс
    1. `git add название_файла/каталога` - добавить избирательно (НЕОБЯЗАТЕЛЬНО)
3. `**git commit -m 'описание изменений'**` сохранить (выполнить “коммит”)
4. Создание нового репо на **GitHub** (один проект - один репо)
5. `git remote add origin <ссылка>` выполнить привязку `LOCAL ↔ REMOTE` (делается один раз для нового репо)
6. `git push -u origin **ветка**` выгрузить ветку на GitHub (`master` или `main`)
    1. `**git push**` (короткий вариант для повторного использования)



**Коммит (точка сохранения)**



### Популярные способы авторизации в Интернет

1. Парольный
2. По публичному ключу (ключ - файл) - беспарольная `RSA`

### RSA/SSH-ключи (ключевые файлы)

1. Публичный (public) - можно делиться со всеми
2. Приватный (private) - храним в секрете

### Генерация пары RSA/SSH ключей

Выполняется один в “начале карьеры”

`ssh-keygen -t rsa`  сгенерировать пару ключей

### GitHub Pages

Бесплатный хостинг `html/css/js`

### Дополнительные команды

- `git status` вывести состояние раб/каталога
    - `git status -s` (сжатый вывод)
- `git reset` очистить индекс
    - `git reset filename`
- `git log` просмотр журнала коммитов
- `git diff` просмотр изменений (между раб/каталогом и индексом)
    - `git diff --staged` (или `--cached`) (между индексом и посл/коммитом)
- `git show commit_id` просмотр содержимого коммита
    - `git show` (изменения у последнего коммита)

### Легенда `git status -s`

`M` Modified

`??` Untracked

`D` Deleted

`A` Added

**красный** - не проиндексированный файл

**зеленый** - проиндексированный файл

### Состояния файлов в GIT

- Неотслеживаемые
- Отслеживаемые
- Игнорируемые

### Список игнорируемых файлов

`.gitignore`
