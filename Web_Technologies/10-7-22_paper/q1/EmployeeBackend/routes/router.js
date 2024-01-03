const express = require("express");
const app = express();
var router = express.Router();
let bodyParser = require("body-parser");
const empServices = require("../services/empServices");
router.get("/employees", function (req, res) {
  var arr = empServices.getAllEmployees();
  res.send(arr);
});
router.post("/employees/employee/:id", function (req, res) {
  empServices.insertEmployee(req.body);
  res.send("data added successfully");
});
router.put("/employees/employee/:id", function (req, res) {
  empServices.updateEmployee(req.body);
  res.send("Employee updated successfully!!");
});
router.delete("/employees/employee/:id", function (req, res) {
  empServices.deleteEmployee(req.params.id);
  res.send("Employee deleted successfully!");
});
module.exports = router;
