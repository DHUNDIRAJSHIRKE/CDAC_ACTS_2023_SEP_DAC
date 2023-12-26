const express = require("express");
var router = express.Router();
var connection = require("../db/dbconnect");
router.get("/product", function (req, resp) {
  connection.query("select * from product", (err, data, fields) => {
    if (err) {
      console.log(err);
      resp.status(500).send("<h3>No data Found!!</h3>");
    } else {
      console.log(data);
      //this will generate ./views/index.ejs

      resp.render("index", { empdata: data });
      resp.send;
    }
  }); //fields is optional
});
//this is same object routes in app.js
module.exports = router;
//router.add("");
