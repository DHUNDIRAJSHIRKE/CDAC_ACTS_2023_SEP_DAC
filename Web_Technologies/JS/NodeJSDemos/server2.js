const http = require("http");
var server = http.createServer(function (req, resp) {
  console.log("recieved request : " + req.url);
  resp.writeHeader(200, { "content-type": "text/html" });
  if (req.url == "/home" && req.method == "GET") {
    resp.write("<h1>Home Page</h1>");
    resp.end("<h1>this is end </h1>");
  } else {
    console.log("Bad Request");
  }
});

server.listen(9090, function () {
  console.log("server started on port 9090");
});
