import React from "react";
import BookService from "../BookService";
export default function BookList() {
  let bookArray = BookService.getAllBooks();
  const list = (
    <div>
      <h1>Book List</h1>
      <ul class="list-group">
        {bookArray.map((book) => (
          <li class="list-group-item">
            Book ID: {book.id} | Book Name: {book.name} | Book Author:
            {book.author}
            {book.author} | Book Price: {book.price}
          </li>
        ))}
      </ul>
    </div>
  );
  return list;
}
