const arr = [1, 2, 3, 'four', 'five'];
console.log(typeof arr);
console.log('===== push ======');
let res = arr.push(6, 7, 8);
console.log(arr); // Метод push добавляет элементы в конец массива;
console.log(res); // Метод push возвращает новую длину массива;
console.log('===== pop ======');
res = arr.pop();
console.log(arr); // Метод pop удаляет элемент с конца массива;
console.log(res); // Метод pop возвращает удалённый элемент;
console.log('===== shift ======');
res = arr.shift();
console.log(arr); // Метод shift удаляет элемент с начала массива;
console.log(res); // Метод shift возвращает удалённый элемент;
console.log('===== unshift ======');
res = arr.unshift(0, 1);
console.log(arr); // Метод unshift вставляет элементы в начало массива;
console.log(res); // Метод unshift возвращает новую длину массива;
console.log('===== concat ======');
const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];
res = arr1.concat(arr2);
console.log(arr1); // Метод concat не изменяет исходные массивы;
console.log(arr2); // Метод concat не изменяет исходные массивы;
console.log(res); // Метод concat возвращает новый массив;
console.log('===== slice ======');
res = arr.slice(2, 6);
console.log(arr); // Метод slice не изменяет исходный массив;
console.log(res); // Метод slice(start, finish) возвращает новый массив (старт входит, конец не входит);
console.log('===== splice ======');
res = arr.splice(1, 4);
console.log(arr); // Метод splice вырезает элементы из исходного массива;
console.log(res); // Метод splice(start, countElement) возвращает вырезанный отрезок массива;

console.log('===== spread ======');
const uniteArr = [...arr1, ...arr2];
console.log(arr1);
console.log(arr2);
console.log(uniteArr);

let arr4 = [1, 2, 3];
let arr5 = [...arr4]; // глубокая копия массива, изменение одного массива не повлечёт изменение второго
// arr5 = arr4 // поверхностная копия массива, изменение одного массива повлечёт изменение второго

arr5[0] = 100;
console.log(arr5);
console.log(arr4);

console.log('===== destructure ======');

const [id, name, family] = arr4; //arr4 =[1, 2, 3]
console.log(a, b, c, d);