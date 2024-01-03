const express = require('express');
const router = express.Router();
const bookStore = require("../db/BookStorage");
//const { default: BookStorage } = require('../db/BookStorage');
router.get('/books',(request,response)=>{
    let data = bookStore.getAllBooks();
    response.status(200).send(data)
})

router.post("/books/book",(request,response)=>{
    bookStore.addBook(request.body);
    response.status(200).send("Data Added Successfully")
})

module.exports = router;