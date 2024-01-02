import React from "react";
import { useState, useEffect } from "react";
import BookService from "../BookService";
import { Link } from "react-router-dom";
export default function BookTable() {
  const [bookArr, setBookArr] = useState([]);
  const [searchArr, setSearchArr] = useState([]);
  const [searchBook, setSearchBook] = useState("");

  //Initializing bookArr and SearchArr
  useEffect(() => {
    console.log("in useEffect");
    let newarr = BookService.getAllBooks();
    setBookArr([...newarr]);
    setSearchArr([...newarr]);
    //console.log("at the ");
  }, []);
  useEffect(() => {
    if (searchBook !== "") {
      let newArr = bookArr.filter((book) => book.name.includes(searchBook));
      setSearchArr(newArr);
    } else {
      if (bookArr.length > 0) {
        setSearchArr([...bookArr]);
      }
    }
  }, [searchBook]);
  return (
    <div>
      <input
        name="searchbook"
        id="searchBook"
        type="text"
        value={searchBook}
        onChange={(e) => {
          setSearchBook(e.target.value);
        }}
      />
      <Link to="/form">
        <button type="button" name="add" id="add">
          Add new Book
        </button>
      </Link>

      <table className="table">
        <thead>
          <tr className="table">
            <th scope="col">ID</th>
            <th scope="col">Book Name</th>
            <th scope="col">Author</th>
            <th scope="col">Price</th>
            <th scope="col" colSpan={3}>
              Action
            </th>
          </tr>
        </thead>
        <tbody>
          {searchArr.map((book) => (
            <tr key={book.id} className="table">
              <td>{book.id}</td>
              <td>{book.name}</td>
              <td>{book.author}</td>
              <td>{book.price}</td>
              <td>
                <Link to={`/view/${book.id}`} state={{ book: book }}>
                  <button
                    type="button"
                    className="btn btn-info"
                    id="btn"
                    name="btn"
                  >
                    View
                  </button>
                </Link>
              </td>
              <td>
                <Link to={`/update/${book.id}`} state={{ updatedBook: book }}>
                  <button
                    type="button"
                    className="btn btn-warning"
                    id="btn"
                    name="btn"
                  >
                    Update
                  </button>
                </Link>
              </td>
              <td>
                <Link to={`/delete/${book.id}`} state={{ deleteBook: book }}>
                  <button
                    type="button"
                    className="btn btn-danger"
                    id="btn"
                    name="btn"
                  >
                    Delete
                  </button>
                </Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
