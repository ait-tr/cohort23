const t = setInterval(move, 20);
// Запускает функцию move каждые 20 миллисекунд
let pos = 0;
const box = document.getElementById('box');

// clearInterval(t); // остановить функцию setInterval
function move() {
    pos++;
    if (pos == 150) {
        clearInterval(t);
    }
    box.style.left = pos + 'px';
    box.style.top = pos + 'px';
}
console.log(new Date());

setInterval (printTime, 1000);

function printTime() {
    const d = new Date();
    const h = d.getHours();

    //TODO Дописать функцию printTime(), чтобы она
    // выводила на экран актуальное время
}

/*
= - присвоение;
== - не строгое сравнение (сравнение значений без учёта типов данных);
=== - строгое сравнение (с учётом типов данных);

Сложение числа и строки называется конкатинацией.
Результатом будет "слипшаяся" строчка

*/