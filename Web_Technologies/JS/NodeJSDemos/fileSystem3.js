const fs = require("fs");
fs.exists("test.txt",function(flag){
    if(flag){
        //to check the status of the file
        fs.stat("test.txt",function(err,status){
            if(err){
                console.log("error occured "+err);
            }else{
                console.log(status);
                console.log("is file? ",status.isFile());
                console.log("is Directory? ",status.isDirectory());
                console.log("size: ",status.size);
            }
        })
    }
})
