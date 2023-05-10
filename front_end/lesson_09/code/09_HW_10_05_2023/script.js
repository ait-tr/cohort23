const library = [];
let inputDate = prompt('Enter book data separate by ";"');
// console.log(inputDate);

while (inputDate) {
    //TODO
    inputDate = prompt('Enter book data separate by ";"');
}
printLibrary()
// 1;2;3;4

function printLibrary(library) {
    // TODO
}

function findBook(library, isbn) {
    // TODO return index of book, if book not exists -1 
}

function Book(isbn, title, author, year) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.year = +year;
    this.toString = function() {
        return `ISBN: ${this.isbn}, Title: ${this.title}, Author: ${this.author}, Year of publishing: ${this.year}`;
    }
}