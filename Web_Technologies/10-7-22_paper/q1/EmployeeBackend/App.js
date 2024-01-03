const express = require("express");
const bodyParser = require("body-parser");
const routes = require("./routes/router");
const PORT = 8080;
const app = express();
app.use(bodyParser.json());
app.use(function (req, res, next) {
  res.setHeader("Access-Control-Allow-Origin", "*");
  res.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE");
  res.setHeader("Access-Control-Allow-Headers", "Content-Type");
  res.setHeader("Access-Control-Allow-Credentials", true);
  next();
});

let books = [];
let idCounter = 1;
app.use("/", routes);
app.listen(8080, function () {
  console.log("server Started at 9090");
});
