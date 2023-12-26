const fs = require("fs");
var fname = "test.txt";
var rs = fs.createReadStream(fname);
var str = "";
rs.on("data", function (chunk) {
  str += chunk;
});
rs.on("end", function () {
  console.log("reached to the end of the file");
  console.log(str);
});
rs.on("error", function (err) {
  console.log("error occured", err);
});
