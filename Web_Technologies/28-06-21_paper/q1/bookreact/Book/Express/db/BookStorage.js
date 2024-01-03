class BookStorage{
    constructor(){
        this.bookArray=[{id:"1", name:"ABC", author:"XYZ", price:999}];
    }

    getAllBooks(){
        return this.bookArray;
    }

    addBook(book){
        let id = parseInt(this.bookArray[this.bookArray.length-1].id);
        console.log("Last id: " + id)
        book.id=id+1;
        console.log(book.id)
        this.bookArray.push(book);
    }
}
module.exports = new BookStorage();