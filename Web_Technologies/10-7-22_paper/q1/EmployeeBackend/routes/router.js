const express = require("express");
const app = express();
var router = express.Router();
let bodyParser = require("body-parser");
const empServices = require("../services/empServices");
router.get("/employees", function (req, res) {
  var arr = empServices.getAllEmployees();
  return arr;
});
router.post("/form");
router.put("/updateEmployee");
router.delete("/deleteEmployee");
module.exports = router;
