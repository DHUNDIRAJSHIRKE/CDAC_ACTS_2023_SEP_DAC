//promise is an object which has 2 functions as parameters
var createblogs = (newblog, f) => {
  return new Promise((resolve, reject) => {});
};
var createblogs = (newblog, f) => {
  setTimeout(() => {
    console.log("createblogs called");
    blogs.push(newblog);
    error = false;
    console.log(blogs);
    if (!error) {
      resolve();
    } else {
      reject();
    }
  }, 2000);
};

var promise5 = fetch("https://jsonplaceholder.typicode.com/posts")
  .then(
    (result) => {
      console.log(result);
      if (result.status === 200 && result.ok) {
        console.log("successful completion of AJAX request");
        return result.json();
      }
      throw "promise rejected via then function";
    },
    (err) => {
      console.log("eorror occured", err);
    }
  )
  .catch(() => {});

function displaytable(data) {
  str = "<table border='2'><tr><th>user ID</th><th>Id</th><th>Title</th></tr>";
  for (var ob of data) {
    str += `<tr><td>${ob.userId}</td><td>${ob.id}</td><td>${ob.title}</td><td>${ob.body}</td></tr>`;
  }
}
/*
promise5.then(data)=>{console.log(data);}).catch(err)=>{
  console
})
*/

//every async function returns promise object
async function greet() {
  //return value gets wrapped in a promise object because of async keyword.
  return "hello";
}
var getblogs = () => {
  setTimeout(() => {
    var str = "<ul>";
    for (var ob of blogs) {
      str += `<li>${ob.name}-------${ob.content}</li>`;
    }
    str += "</ul>";
    document.getElementById("myDiv").innerHTML = str;
  }, 1000);
};
