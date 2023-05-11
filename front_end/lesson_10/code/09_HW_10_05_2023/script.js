const library = [];
let inputDate = prompt('Enter book data separate by ";"');

while (inputDate) {
    //TODO
    // let count = 0;
    // for (let i = 0; i < inputDate.length; i++) {
    //     if (inputDate[i] === ';') {
    //         count++;
    //     }
    //     if (count > 3) {
    //         console.log('Date is not valid');
    //         return;
    //     }
    // }
    // if (count !== 3) {
    //     return
    // }
    const [isbn, title, author, year] = inputDate.split(';');
    // if (arr.length !== 4) {
    //     return;
    // };
    if ( inputDate.split(';').length === 4 &&
         isbn &&
         title &&
         author &&
         year &&
         findBook(library, isbn) === -1
        ) {
        const book = new Book(isbn, title, author, year);
        library.push(book);
    }
    inputDate = prompt('Enter book data separate by ";"');
}

printLibrary(library);
// 1;'kolobok';'nation';4    =>   3 ';'

function printLibrary(library) {
    for (let i = 0; i < library.length; i++) {
        console.log(library[i].toString());
    }
}

function findBook(library, isbn) {
    for (let i = 0; i < library.length; i++) {
        if (library[i].isbn === isbn) {
            return i;
        }        
    }
    return -1;
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