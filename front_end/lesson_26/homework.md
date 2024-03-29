Напишите небольшую веб-страницу, которая будет содержать текстовое поле ввода и кнопку "Сохранить". Используя хук useRef и localStorage, реализуйте следующую функциональность:

- 1. Когда пользователь вводит текст в поле ввода и нажимает кнопку "Сохранить", значение текстового поля должно сохраняться в локальном хранилище (localStorage).

- 2. При обновлении страницы или повторном открытии страницы после закрытия, сохраненное значение из локального хранилища должно быть автоматически восстановлено и отображено в поле ввода.

- 3. При каждом изменении значения текстового поля ввода, сохраненное значение в локальном хранилище должно обновляться.

Подсказка: Чтение и запись данных в localStorage можно выполнить с помощью методов getItem и setItem. Хук useRef позволяет сохранить ссылку на элемент или значение между рендерами компонента.

Убедитесь, что веб-страница работает корректно, сохраняя и восстанавливая значение поля ввода из локального хранилища при перезагрузке страницы или закрытии/открытии браузера.