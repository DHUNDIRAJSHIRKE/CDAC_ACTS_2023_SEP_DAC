const mysql = require("mysql");
var mysqlconnection = mysql.createConnection({
  host: "127.0.0.1",
  user: "root",
  port: 3306,
  database: "test",
  /*multipleStatements:true*/
});
mysqlconnection.connect(() => {
  if (err) {
    console.log("Error occured: " + err);
  } else {
    console.log("Connection done!!");
  }
});
module.exports = mysqlconnection;
