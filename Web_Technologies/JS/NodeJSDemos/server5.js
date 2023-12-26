const http = require("http");
const fs = require("fs");
const url = require("url");
const m1 = require("./module1");
var server = http.createServer(function (req, resp) {
  //it will separate the url and data and generate a object and store in the
  //p={pathname:"/submit_data".query:{num1:23,num2:300}}
  //object generation will be done by the url.parse()
  var q = url.parse(req.url);
  console.log(q.pathname);
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
  } else if (req.url == "/form" && req.method == "GET") {
    //read data from file and display it in the browser
    resp.writeHeader(200, { "content-type": "text/html" });
    var rs = fs.createReadStream("./public/form1.html");
    rs.pipe(resp);
    //rs.on("error",function(){})
    //resp.write(public / hello.html);
  } else if (q.pathname == "/submit_data" && req.method == "GET") {
    //  /submit_data?num1=23&num2=300
    resp.write("you Entered num1 : " + q.query.num1 + "<br>");
    resp.write("you Entered num2 : " + q.query.num2 + "<br>");
    //resp.writeHeader(200, { "content-type": "text/html" });
    if (q.query.btn == "add") {
      resp.write("Your entered num1: " + q.query.num2 + "<br>");
      var ans = m1.addition(parseInt(q.query.num1), parseInt(q.query.num2));
      resp.end("Addition : " + ans);
    } else {
      resp.write("Your entered num1: " + q.query.num2 + "<br>");
      var ans = m1.addition(parseInt(q.query.num1), parseInt(q.query.num2));
      resp.end("Addition : " + ans);
    }
    //
    //resp.write("<h1>Contact us!!!</h1>");
  } else {
    resp.writeHeader(404, { "content-type": "text/html" });
    resp.write("<h1>Bad Request</h1>");
  }
});

server.listen(9090, function () {
  console.log("server started on port 9090");
});
