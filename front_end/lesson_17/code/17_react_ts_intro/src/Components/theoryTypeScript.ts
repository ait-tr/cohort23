// задаем тип данных, в данном случае не обязательно, потому что примет тип значения
let firstname: string = 'Danny'; // typeof firstname = string

let age: number | string; // typeof age = number or string 
age = 26;
age = '26';

let userName: any = 'Andrew'; // typeof userName = любой тип данных;
userName = 23;
userName = false;

let direction: 'UP' | 'DOWN'; // direction = 'UP' or 'DOWN';
direction = 'UP';
direction = 'DOWN';

let person: { // Описали переменную person: объект с полями fullName и isProgrammer соответствующих типов данных
    fullName: string,
    isProgrammer: boolean
};

person = { // создали экземпляр объекта person, который соответствует заданной типизации
    fullName: 'Bill Parker',
    isProgrammer: false
}

// person.age = 10;
//ERROR - нет ключа age в описании объекта person

// person.isProgrammer = 'Yes';
//ERROR - ключ isProgrammer в описании объекта person является boolean, а не string

let ids: number[] = [];
ids.push(1);
// ids.push('2'); not a number

let option: (string | number)[];
option = [10, 'left'];

let persons = ['Delia', 'Alex'];
// persons[0] = 43; неявная типизация по значению элемента по тому же индексу при создании массива

function circle(diam: number): string | number {
    return 'Circle = ' + Math.PI * diam;
}

let sayHi: (name: string) => void; // описали тип стрелочной функции
sayHi = (name: string) => console.log('Hi ' + name); // прописали её

// npx create-react-app homework - для javascript project (где homework - имя проекта)
// npx create-react-app homework_ts --template typescript - для typescript project (где homework_ts - имя проекта)

interface IPerson {
    fullName: string,
    isProgrammer: boolean
}

let p1: IPerson = {
    fullName: 'Vasya',
    isProgrammer: true
}

// p1.fullName = 'Vasiliy'; Error - read only!

// Предположим, в переменную age попадает результат функции getUserAge(),
// который может быть строкой или числом
// age = getUserAge(); 
// age => string | number

// if (typeof age === 'string') {
//  age = +age
// }

// <T> - это синтаксис дженерика. Дженерик позволяет более универсально описывать interface будущих элементов,
// если информация о типе 1 или нескольких переменных будет известна только при создании нового экземпляра
interface IDog<T> {
    breed: string,
    treats: T
}

// При создании объекта labrador указываем недостающий тип поля объекта
let labrador: IDog<string> = {
    breed: 'labrador',
    treats: 'chew sticks, tripe'
}

// При создании объекта scottieDog указываем недостающий тип поля объекта
let scottieDog: IDog<string[]> = {
    breed: 'scottish terrier',
    treats: ['turkey', 'haggis']
}
// Есть готовые типы для всех html tags, всегда начинаются с HTML...Element (... => имя тэга с большой буквы)
// const form = document.getElementById('form') as HTMLFormElement