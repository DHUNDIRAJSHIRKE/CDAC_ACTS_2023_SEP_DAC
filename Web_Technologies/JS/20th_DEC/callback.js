var blogs = [
  { name: "blog1", content: "blog1content" },
  { name: "blog2", content: "blog2content" },
  { name: "blog3", content: "blog3content" },
];
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

var createblogs = (newblog, f) => {
  setTimeout(() => {
    console.log("createblogs called");
    blogs.push(newblog);
    console.log(blogs);
    f();
  }, 2000);
};
console.log("befoer createblog");
createblogs({ name: "blog4", content: "blog4 content" }, getblogs);
getblogs();
console.log("after createblog");
