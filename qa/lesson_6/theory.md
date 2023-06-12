## WHITE-BOX testing
Как правило, он используется на уровне тестирования компонентов(т.н. модульного тестирования), но его также можно применять на любом другом уровне, используя различные модели ПО «белого ящика»

- Покрытие операторов(statement coverage) включает выполнение всех операторов хотя бы один раз в исходном коде. Оно требует, чтобы каждый исполняемый оператор выполнялся хотя бы один раз по крайней мере в одном тесте

- Покрытие ветвей(branch coverage) также известно как покрытие решений(decision coverage) или покрытие всех границ(all-edges coverage). Оно охватывает как истинные, так и ложные условия, маловероятные для покрытия операторов

[Презентация](https://docs.google.com/presentation/d/1rvzQNyS3-kYkIR_N785r6kUkZVJxfJhG/edit?usp=drive_link&ouid=100462493827587974016&rtpof=true&sd=true)

[Примеры](https://drive.google.com/file/d/1FRefYRrUskJAaWokmLihglBEyazDr3f0/view?usp=drive_link)

## Комбинирование данных

Основные методы комбинирования:

##### Полный перебор значений
• Тестирование всех возможных комбинаций всех значений всех параметров

• Максимальное покрытие

• Максимум тестов

##### Метод минимальных проверок
• По одному значению каждого параметра использовано хотя бы в одном тест-кейсе

• Минимальное покрытие

• Минимум тестов

##### Атомарные проверки
• Тест-кейсы строятся на основе выбора всех базовых значений, кроме одного, которое изменяется

• Легко локализуемое покрытие

##### Pairwise
• Вместо проверки всех комбинаций - выбираем уникальные пары всех параметров

• Согласно исследованиям компании IBM 97% ошибок в ПО возникает при взаимодействии всего двух значений

Pairwise online https://pairwise.teremokgames.com/

Allpairs download https://www.satisfice.com/download/allpairs

#### Алгоритм применения техники

- Определить переменные

- Определить их значения

- Оптимизировать значения

- Описать условия и зависимости

- Построить тестовую таблицу

[Презентация](https://docs.google.com/presentation/d/1sBLdvYByWqpekDiX1i1LPsaWt_ajYkEc/edit?usp=drive_link&ouid=100462493827587974016&rtpof=true&sd=true)

[Примеры](https://docs.google.com/spreadsheets/d/12zbJjgMrHAOKcntSo0ANF0NNRzfXylMCly6F2qhVEKM/edit?usp=drive_link)