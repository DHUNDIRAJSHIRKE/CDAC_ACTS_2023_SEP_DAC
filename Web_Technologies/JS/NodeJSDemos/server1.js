const http = require("http");
var server = http.createServer(function (req, resp) {
  console.log("received request " + req.url + " Method : " + req.method);
  resp.writeHeader(200, { "content-type": "text/html" });
  resp.write("<h1>Hello world!!!<h1>");
  resp.write("<h1>Welcome to nodeJS serverSide Progamming<h1>");
  resp.end("<h3>This is the end Event"); //unless end event occurs, nothing will get passed to the browser.
});
server.listen(9090, function () {
  console.log("server running at port 9090");
});
