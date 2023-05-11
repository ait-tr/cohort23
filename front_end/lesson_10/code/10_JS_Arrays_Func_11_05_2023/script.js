console.log('===== Regular function =====');
console.log(multiply(3, 4));

function multiply(a, b) {
    return a * b;
}

console.log(multiply(2, 5));


console.log('===== Arrow function =====');
// console.log(multiplyArrow(4,5)); ReferenceError: нельзя вызвать функцию до инициализации

const multiplyArrow = (a, b) => a * b;

console.log(multiplyArrow(6,5));

// "" '' ``     "userName did homework"

const obj = {
    userName: 'John',
    sayHello: function() {
        console.log(this); // this = obj
        console.log(`Hello ${this.userName}`); // Hello Johns
    }
}

obj.sayHello();

const objArrow = {
    userName: 'John',
    sayHello: () => {
        console.log(this); // this - global field window
        console.log(`Hello ${this.userName}`); // Hello undefined
    }
}

objArrow.sayHello();

const person = {
    firstName: 'John',
    lastName: 'Smith',
    age: 34,
    fullName: function() {
        return `${this.firstName} ${this.lastName}`;
    }
}

let arr = Object.keys(person); // Array of keys
console.log(arr);

arr = Object.values(person); // Array of values
console.log(arr);

arr = Object.entries(person); // Array with arrays[key, value]
console.log(arr[2][1]); // [ [0, 1], [0, 1], [0, 1] ]

arr = ['one', 'two', 'threE', 'eight', 'tHree', 'three', 'six'];
console.log('===== indexOF =====');
let res = arr.indexOf('three');
// console.log(arr); // Исходный массив не меняется;
console.log(res); // Возвращает индекс искомого элемента (или -1, если такого элемента в массиве нет);

res = arr.includes('nine');
// console.log(arr); // Исходный массив не меняется;
console.log(res); // Возвращает true если искомый элемент есть в массиве (и false, если такого элемента в массиве нет);

res = arr.findIndex((x, i) => i > 2 && x.toLowerCase() === 'three');
// console.log(arr); // Исходный массив не меняется;
console.log(res); // Возвращает индекс искомого элемента (или -1, если такого элемента в массиве нет);

res = arr.findIndex(predicateLength3);
console.log(res); // Возвращает индекс искомого элемента (или -1, если такого элемента в массиве нет);

function predicateLength3(element, index) {
    return index >= 2 && element.length === 3;
}

const persons = [
    {
        userName: 'Peter',
        age: 23
    },
    {
        userName: 'John',
        age: 28
    },
    {
        userName: 'Tigran',
        age: 26
    },
    {
        userName: 'Rabindranat',
        age: 23
    }
];

res = persons.findIndex((p, i) => i > 0 && p.age < 25);
console.log(res);

res = persons.filter(p => p.age < 25);
console.log(res);

res = persons.map((p, i) => `${i+1}. Name: ${p.userName}, Age: ${p.age}`);
console.log(res);

res = persons.reduce((accum, item) => accum + item.age, 0);
console.log(res);

res = persons.sort((a, b) => a.age - b.age === 0 ? b.userName.length - a.userName.length : a.age - b.age);
console.log(res);