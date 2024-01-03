import axios from "axios";

class BookService{
    constructor(){}

    addBook(book){
        return axios.post("http://localhost:9090/books/book",book)
    }

    getBooks(){
        return axios.get("http://localhost:9090/books");
    }
}

export default new BookService()