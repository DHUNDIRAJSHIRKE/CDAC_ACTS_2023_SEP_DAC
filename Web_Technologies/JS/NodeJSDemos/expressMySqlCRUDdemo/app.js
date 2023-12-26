//import all libraries
const express = require("express");
const app = express();
const path = require("path");
const bodyParser = require("body-parser");
var routes = require("./routes/router");
//configure the application
//find all views in views folder and extension
// of the file is ejs
app.set("views", path.join(__dirname, "views"));
app.set("views engine", "ejs");
//to add static references
//app.set(express.static(path.join(__dirname, "public")));
//app.use("/css",express.static(path.join(__dirname."public/css")))
//app.use("/js",express.static(path.join(__dirname."public/js")))
response.render("index");
//define middleware if any
bodyParser.urlencoded({ extended: false });
//define route handlers
app.use("/", routes);

//start the server
app.listen(9090, function () {
  console.log("server started at port 9090");
  module.exports = app;
});
