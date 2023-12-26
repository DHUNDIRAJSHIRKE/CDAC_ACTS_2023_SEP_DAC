//import express
const express = require("express");
const app = express();
const bodyparser = require("body-parser");
app.use(function (req, resp, next) {
  console.log("this is middleWare");
  next();
});
app.get("/hello", function (req, resp) {
  resp.sendFile("/public/hello.html", { root: __dirname }); //__dirname will print the current folder
});
app.get("/aboutus", function (req, resp) {
  resp.send("<h1>in about us</h1>");
});
app.listen(9089, function () {
  //function(){...} isn't required, it is for our understanding
  console.log("Listening at 9089");
});
