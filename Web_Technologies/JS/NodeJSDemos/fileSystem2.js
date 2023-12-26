const fs = require("fs");
console.log("Before readfile Async");
//asychronous read
//every asyncronous function should have call functions
fs.readFile("test.txt", function (err, data) {
  if (err) {
    console.log("error occured", err);
  } else {
    console.log(data.toString());
  }
});
console.log("After readfile Async");
var txt = fs.readFileSync("test1.txt");
console.log("from readsync", txt);
fs.readFile("test1.txt", function (err, data) {
  if (err) {
    console.log("error occured", err);
  } else {
    console.log("in 2nd async function " + data.toString());
  }
});

console.log("After readSync");
