const fs = require("fs");
var fname = "test.txt";
fs.exists("test.txt", function (flag) {
  if (flag) {
    fs.stat(fname, function (err, status) {
      if (err) {
        console.log("Error occured ", err);
      } else {
        console.log("size", status.size); //r read, w write etc
        fs.open(fname, "r", function (err, fd) {
          //file descriptor is a pointer which points to the file
          if (err) {
            console.log(err);
          } else {
            var buff = Buffer.alloc(10);
            fs.read(fd, buff, 0, 10, null, function (err, bytesread, buffer) {
              //file descriptor,Buffer,starting position,no of characters,,callback function
              console.log(fs);
              console.log(
                "------------------------------------------------------------------------------------"
              );
              console.log(fd);
              if (err) {
                console.log(err);
              } else {
                console.log(buffer.toString());
              }
            });
          }
          fs.close(fd);
        });
      }
    });
  } else {
  }
});
