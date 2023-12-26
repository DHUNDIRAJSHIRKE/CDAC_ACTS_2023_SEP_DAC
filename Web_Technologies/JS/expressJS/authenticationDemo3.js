const express = require("express");
const app = express();
const bodyparser = require("body-parser");
var m1 = require("./module1");
//this is a middleware which helps to parse the URL and separate data from the URL.
//It will generate object by the name query in req object if method is get
//It will generate object by the name body in req object if method is post
// all this will be taken care of by 'bodyparser.urlencoded'
app.use(bodyparser.urlencoded({ extended: false }));
app.get("/login", function (req, resp) {
  resp.sendFile("/public/login.html", { root: __dirname }); //dunderscore -> double underscore
});
app.post("/validate", function (req, resp) {
  var u = m1.validateuser(req.body.unmae, req.body.upass);
  if (u === null) {
    resp.send("<h1>Invalid User</h1>");
  } else {
    resp.sendFile("/public/form.html", { root: __dirname });
    //resp.send("<h1>valid User</h1>");
  }
  //resp.send("uname: " + req.body.uname + " Password: " + req.body.upass);
});

app.get("/calculate", function (req, resp) {
  var n1 = req.query.num1;

  var btn = req.query.btn;
  if (btn === "add") {
    var n2 = req.query.num2;
    var ans = m1.addition(n1, n2);
    resp.send("<h1>Addition: " + ans + "</h1>");
  } else {
    var ans = m1.factorial(n1);
    resp.send("<h1>Factorial: " + ans + "</h1>");
  }
});

app.listen(9092, function (req, resp) {
  console.log("Listening at 9092");
});
