import React, { useState } from 'react'
import BookService from '../services/BookService';
import { useNavigate } from 'react-router-dom';

export default function BookForm() {
    const [formDetails, setFormDetails] = useState({
        name:"",
        author:"",
        price:""
    })

    const navigate = useNavigate();

    const handleChange=(event)=>{
        let name = event.target.name;
        let value = event.target.value;
        setFormDetails({...formDetails, [name]:value})
    }

    const addBook=()=>{
        BookService.addBook(formDetails).then(()=>{
            console.log("In add")
            navigate(0)
        }).catch((err)=>console.log(err))
        
    }

  return (
    <div>
        <form>
  <div className="mb-3">
    <label htmlFor="name" className="form-label">Book name</label>
    <input type="text" className="form-control" id="name" name='name' value={formDetails.name} onChange={handleChange}/>
  </div>
  <div className="mb-3">
    <label htmlFor="author" className="form-label">Author name</label>
    <input type="text" className="form-control" id="author" name='author'value={formDetails.author} onChange={handleChange}/>
  </div>
  <div className="mb-3">
    <label htmlFor="price" className="form-label">Price</label>
    <input type="text" className="form-control" id="price" name='price'value={formDetails.price} onChange={handleChange}/>
  </div>
  <button type="button" className="btn btn-primary" onClick={addBook}>Add Book</button>
</form>
    </div>
  )
}
