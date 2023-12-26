const http = require("http");
const fs = require("fs");
var server = http.createServer(function (req, resp) {
  console.log("recieved request : " + req.url);
  //resp.writeHeader(200, { "content-type": "text/html" });
  if (req.url == "/home" && req.method == "GET") {
    resp.writeHeader(200, { "content-type": "text/html" });
    resp.write("<h1>Home Page</h1>");
    resp.end("<h1>this is end </h1>");
  } else if (req.url == "/aboutus" && req.method == "GET") {
    resp.writeHeader(200, { "content-type": "text/html" });
    resp.write("<h1>About us!!!</h1>");
  } else if (req.url == "/contactus" && req.method == "GET") {
    resp.writeHeader(200, { "content-type": "text/html" });
    resp.write("<h1>Contact us!!!</h1>");
  } else if (req.url == "/hello" && req.method == "GET") {
    //read data from file and display it in the browser
    resp.writeHeader(200, { "content-type": "text/html" });
    var rs = fs.createReadStream("./public/hello.html");
    rs.pipe(resp);
    //rs.on("error",function(){})
    //resp.write(public / hello.html);
  } else {
    resp.writeHeader(404, { "content-type": "text/html" });
    resp.write("<h1>Bad Request</h1>");
  }
});

server.listen(9090, function () {
  console.log("server started on port 9090");
});
