import React from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import BookService from "../BookService";
import { useLocation } from "react-router-dom";
import { useEffect } from "react";

export default function BookForm() {
  const location = useLocation();
  const navigate = useNavigate();
  const [formDetails, setFormDetails] = useState({
    //id: "",
    //name: "",
    //author: "",
    //price: "",
  });
  const updateBook = () => {
    BookService.updateBook(formDetails);
    navigate("/table");
  };
  const handleChange = (event) => {
    let name = event.target.name;
    let value = event.target.value;
    setFormDetails((prevValues) => ({ ...prevValues, [name]: value }));
  };
  useEffect(() => {
    setFormDetails({ ...location.state.updatedBook });
  }, []);
  return (
    <div>
      <form>
        <div class="form-group">
          <label for="id">ID</label>
          <input
            type="Number"
            class="form-control"
            id="id"
            name="id"
            readOnly
            placeholder="e.g. 123"
            value={formDetails.id}
            onChange={handleChange}
          />
        </div>
        <div class="form-group">
          <label for="name">Name</label>
          <input
            type="text"
            class="form-control"
            id="name"
            name="name"
            placeholder="e.g. The Bible"
            value={formDetails.name}
            onChange={handleChange}
          />
        </div>
        <div class="form-group">
          <label for="author">Author</label>
          <input
            type="text"
            class="form-control"
            id="author"
            name="author"
            placeholder="e.g. George RR Martin"
            value={formDetails.author}
            onChange={handleChange}
          />
        </div>
        <div class="form-group">
          <label for="price">Price</label>
          <input
            type="Number"
            class="form-control"
            id="price"
            name="price"
            placeholder="format : 0.00"
            value={formDetails.price}
            onChange={handleChange}
          />
        </div>
        <br />
        <button type="button" class="btn btn-primary" onClick={updateBook}>
          Update Book
        </button>
      </form>
    </div>
  );
}
