`root` - главный администратор сервера (супер-пользователь)

### Базовые команды Linux

`pwd` (print working directory) - просмотр текущей директории

`cd` (change dir) - перейти в другой каталог

- по умолчанию переход в дом/каталог
- `cd <target_dir>`

`ls` (listing) - просмотр содержимого каталога

- `ls -l` структурированный вывод
- `ls -l /`
- `**ls -lah**`
    - `-a` показать скрытые
    - `-h`  human-readable
- `ls -R`
    - `-R` recursive

`clear` (или `CTRL+L`) - очистка консоли

`CTRL+C` прервать выполнение команды (любой)

`mkdir` (make dir) - создать каталог

- `mkdir new_dir`
- `mkdir -p ait/frontend/homeworks` создать иерархию
    - `-p` parent

`touch` - создать пустой файл

- `touch filename`

**Задача. В домашнем каталоге пользователя создать иерархию каталогов `dir/dir1/dir2` и в каждом их них создать по произвольному пустому файлу.**

**Ответ - последовательность команд**

```bash
mkdir -p dir/dir1/dir2
touch dir/level_1.txt
touch dir/dir1/level_2.txt
touch dir/dir1/dir2/level_3.txt
```

`cat` - вывод содержимого файла (в терминал)

- `cat filename`

### Редактирование текстовых файлов

- `nano` - базовый
    - `nano filename`
    - `CTRL+S` - сохранить
    - `CTRL+X` - выйти
- `vim` - продвинутый

`df` (disk free) - просмотр статистики по дискам 

- `df -h`
    - `-h` human-readable

`du` (disk usage) - просмотр занятого места

- `du <target>`
- `du -hs <target>`
    - `-s` (summarize)

**Задача. Создать иерархию каталогов `hello1/hello2/hello3`. В каталоге `hello1` создать файл `hello1.txt`, в каталоге `hello3` - `hello.txt`.**

```bash
mkdir -p hello1/hello2/hello3
touch hello1/hello1.txt
touch hello1/hello2/hello3/hello.txt
```

`rm` (remove) - удалить файл/каталог

- `rm filename`
- `rm -rf dir_name`
    - `-r` recursive
    - `-f` force

### Работа с Git

**Изменение привязки**

```bash
git remote rm origin # удалить старую
git remote add origin <скопированная_ссылка> # добавить новую
```

**Проект** - кодовая база

**Репозиторий** - файловая БД с историей разработки проекта (`.git/`)

### Ветвление в Git

**Ветка** - поток изолированный разработки (еще одна версия проекта)

- ссылка на коммит


### Стратегии ветвления в Git

1. **Git Flow**
    1. `main/master/stable` - long-term
    2. `develop/current` - long-term
    3. `login/payments/bugfix01` - short-term
2. **GitHub Flow**
    - `master`
    - `short-term`

### Базовые команды по работе с ветками в Git

- `git branch` просмотр веток
- `git branch новая_ветка`  создать ветку
- `git checkout ветка` переключиться на ветку
    - **ПЕРЕКЛЮЧАТЬСЯ НЕОБХОДИМО С “ЧИСТЫМ СТАТУСОМ”**
- `git checkout -b новая_ветка` создать и переключиться
- `git branch -D ветка` удалить ветку (локально)
- `git push origin --delete ветка` удалить ветку на GitHub
- `git merge название_ветки` слияние веток
    - `git merge --abort` прервать слияние

**Задача. Создать ветку `contact` с файлом `contact.html` и затем выполнить слияние с веткой `main`**

**Ответ - последовательность команд**

```bash
git checkout -b contact # создать и переключиться на новую ветку
# добавляю новую файл contact.html и наполняю его содержимым
git add .
git commit -m 'создал файл contact.html'
git checkout main
git merge contact
```

### Справочная документация

- [linux-песочница](https://bellard.org/jslinux/vm.html?url=alpine-x86.cfg&mem=192)
- [ветвление в Git](https://git-scm.com/book/ru/v2/%D0%92%D0%B5%D1%82%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5-%D0%B2-Git-%D0%9E%D1%81%D0%BD%D0%BE%D0%B2%D1%8B-%D0%B2%D0%B5%D1%82%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D1%8F-%D0%B8-%D1%81%D0%BB%D0%B8%D1%8F%D0%BD%D0%B8%D1%8F)
- [иерархия каталогов в Linux](https://linuxthebest.net/struktur%D1%8B-katalogov-linux-y-vazhn%D1%8Be-puty-k-fajlam/)