//import express library
const express = require("express");
//create express object
var app = express();
const bodyparser = require("body-parser");
//define middleware : they are the functions which you want to execute for every request.
//common task you want to perform for every request.
//common functionality for all URL's
app.use(function (req, resp, next) {
  console.log("this is first middleware!");
  console.log("URL : " + req.url);
  next();
});
app.use(function (req, resp, next) {
  console.log("this is second middleware!");
  console.log("URL : " + req.url);
  next();
});
//router modules
app.get("/home", function (req, resp) {
  resp.send("<h1>Home Page</h1>"); //send function can be used only once.
  //   var str = resp.send()
});
app.get("/aboutus", function (req, resp) {
  var str = "<h1>Hello World!!!</h1>";
  str += "<h2>Welcome to ExpressJS Programming</h2>";
  resp.send(str);
});
//To start the server
app.listen(9091, function () {
  console.log("Listening at 9091");
});
