console.log("Hello world!");
let x;
console.log(x);
x = 7;
x = "bye";
console.log(x);

const pi = 3.1415926;
// pi = 3.14; пример ошибки

let y = x;
console.log(y);

console.log("pi = " + pi);

const exp = pi;
console.log(`exp = ${exp} or ${pi}`);

x = true;
console.log(x);

x = null;
console.log(x);

let res = 7 % 2; // остаток от деления
console.log(`res = ${res}`);

res = "true" + 5;
console.log(`res = ${res}`);

res = true + 5; // false - 0, true - 1;
console.log(`res = ${res}`);

x = "2" === 2;
console.log(`x = ${x}`);

x = "2" == 2;
console.log(`x = ${x}`);

res = +'5'; // Number('5') - 5
res = 5 + ''; // String(5) - '5'

switch (res) {
    case 5:
        console.log(`number: ${res}`);
        break;
    case '5':
        console.log(`string: ${res}`);
        break;
    default:
        console.log('Not a 5');
}

let age = 17;
let vol = age > 17 ? 42 : 1.5;
console.log(`vol = ${vol}`);

console.log(+pi.toFixed(2));

res = -age;
console.log(res);

++age; // Вначале прибавляем 1, потом используем значение age
age++; // Вначале используем значение age, потом прибавляем 1

x = 10;
res = x++ + ++x; // res = 10 + 12 = 22
console.log(`res = ${res}`);

console.log(typeof age);
age = '5';
console.log(typeof age);
age = true;
console.log(typeof age);
age = undefined;
console.log(typeof age);
age = null;
console.log(typeof(age));

x = 10;
y = 5;
res = add(x, y);
console.log(`res = ${res}`);

function add(a, b) {
    return a + b;
}

x = !!x; // неявное приведение переменной к boolean значению;
console.log(x); // любое число будет true, кроме 0 (false)

let example = 'hello';
console.log(!!example);

// false = null, undefined, NaN, 0, -0, false, ''

let userName = null;
let nickName = userName || 'Anonymous';
// console.log(nickName);
greeting();
greeting('Rabindranat');


function greeting(nickName1 = 'Anonymous') {
    // nickName1 = nickName1 || 'Anonymous';
    console.log(`Hello ${nickName1}`);
}

// int[] arr = new int[5];
// int[] arr = {2, 3, 4, 5};

const arr = [1, 2, 3, 'four', 'five', true];
console.log(typeof arr);
console.log(arr[3]);
console.log(typeof arr[3]);
arr[3] = 4;
console.log(arr[3]);
console.log(arr.length);
arr[10] = 100500;
console.log(arr[10]);
console.log(arr);
printArray(arr);
console.log(arr[9]);
arr.length = 3;
console.log(arr);
// printArray(arr);

function printArray(arr) {
    for (let i = 0; i < arr.length; i++) {
        console.log(arr[i]);
    }
}

res = sumDigits(1234);
console.log(`res = ${res}`); // res = 10;
res = luckyNumber(123871); 1 + 2 + 3 == 8 + 7 + 1;
// res = luckyNumber(1234321); 1 + 2 + 3 == 3 + 2 + 1;
console.log(res ? 'Lucky' : 'Unlucky');

function sumDigits(x) {
    // TODO
}

function luckyNumber(x) {
    //TODO
}

function banana() {
    let a = 'a';
    let b = 'b';
    //TODO
}
// 'b', 'a' => banana;