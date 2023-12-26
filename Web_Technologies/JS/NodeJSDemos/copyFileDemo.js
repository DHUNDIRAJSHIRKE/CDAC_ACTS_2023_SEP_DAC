const fs = require("fs");
fs.copyFile("test.txt", "target.txt", function (err) {
  if (err) {
    console.log(err);
  } else {
    fs.readFile("target.txt", function (err, data) {
      if (err) {
        console.log(err);
      } else {
        console.log("Data from target File: ");
        console.log(data.toString());
      }
    });
  }
});
