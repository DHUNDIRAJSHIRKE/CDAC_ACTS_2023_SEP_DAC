class BookService {
  constructor() {
    this.bookArray = [
      { id: 1, name: "Never Go Back", author: "Lee Child", price: 599 },
      { id: 2, name: "Kane and Abel", author: "Jeff Archer", price: 349 },
      { id: 3, name: "Fantastic Five", author: "Enid Blyton", price: 899 },
      {
        id: 4,
        name: "Murder of Rojer Ackroyd",
        author: "Agatha Christie",
        price: 999,
      },
    ];
  }
  getAllBooks() {
    return this.bookArray;
  }
  addBook(book) {
    this.bookArray.push(book);
  }
}
export default new BookService();
