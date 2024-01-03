const express = require("express");
const app = express();
const bodyParser = require("body-parser");
const routes = require("./routes/router");

//Add CORS
app.use((req,res,next) => {
  res.setHeader("Access-Control-Allow-Origin","*"); /* @dev First, read about security */
  res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
  res.setHeader("Access-Control-Max-Age", 2592000); // 30 days
  res.setHeader("Access-Control-Allow-Credentials", true);
  res.setHeader("Access-Control-Allow-Headers", "content-type");
  next();
});

app.use(bodyParser.json())
app.use(bodyParser.urlencoded({extended:false}))

app.use('/',routes);

app.listen(9090,()=>{
    console.log("Listening at port 9090")
})