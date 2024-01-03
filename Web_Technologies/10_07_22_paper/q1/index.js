const express = require("express");
const bodyParser = require("body-parser");

const app = express();

const PORT = 3000;

app.use(bodyParser.json());

let books = [];
let idCounter = 1;
app.post("/books", (req, res) => {
  const { name, author, price } = req.body;
  console.log("in post");

  console.log(req.headers["content-type"]);
  console.log(req.body);
  const newBook = {
    id: idCounter++,
    name,
    author,
    price,
  };

  books.push(newBook);
  console.log(books);

  res.status(201).json(newBook);
});

app.listen(PORT, () => {
  console.log("on 3000");
});
