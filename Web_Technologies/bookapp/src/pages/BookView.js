import React from "react";
//import { useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";
//import BookService from "../BookService";
export default function BookView() {
  const navigate = useNavigate();
  const location = useLocation();
  var book = location.state.book;
  return (
    <div>
      <div className="card">
        <img calss="card-img-top" src="..." alt="Card image cap" />
        <div class="card-body">
          <h5 class="card-title">{book.id}</h5>
          <h5 class="card-title">{book.name}</h5>
          <p class="card-text">{book.author}</p>
          <p class="card-text">{book.price}</p>
        </div>
      </div>
    </div>
  );
}
