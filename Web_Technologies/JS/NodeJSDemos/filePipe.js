const fs = require("fs");
var rs = fs.createReadStream("test.txt");
var ws = fs.createWriteStream("targetData.txt");
rs.pipe(ws);
console.log("reached the end of the file");
