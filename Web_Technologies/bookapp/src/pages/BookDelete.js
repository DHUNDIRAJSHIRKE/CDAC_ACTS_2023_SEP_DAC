import React from "react";
import BookService from "../BookService";
//import { useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";
import { useEffect, useState } from "react";

//import BookService from "../BookService";
export default function BookView() {
  const navigate = useNavigate();
  const location = useLocation();

  var book = location.state.deleteBook;

  const deleteBook = () => {
    BookService.deleteBook();
    navigate("/table");
  };
  return (
    <div>
      <div className="card">
        <div class="card-body">
          <h5 class="card-title">{book.id}</h5>
          <h5 class="card-title">{book.name}</h5>
          <p class="card-text">{book.author}</p>
          <p class="card-text">{book.price}</p>
          <button
            class="btn btn-btn-primary"
            name="delete"
            id="delete"
            onClick={deleteBook}
          >
            Delete Confirmed
          </button>
          <Link to="/table">
            <button class="btn btn-btn-primary" name="delete" id="delete">
              Cancel
            </button>
          </Link>
        </div>
      </div>
    </div>
  );
}
