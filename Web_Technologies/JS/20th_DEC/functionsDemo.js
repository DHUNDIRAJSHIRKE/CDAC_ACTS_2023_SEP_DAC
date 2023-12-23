function f1() {
  //in every functions, there exists an array : arguments
  console.log("in function f1");
  console.log(arguments);
}
f1(); //valid
f1(10, 2, 13, 423, 5, 4); //valid
f1(1, 2, "d", "i"); //valid
function f2(x, y, arguments) {
  var s = x + y;
  for (var num in arguments) {
    s = s + num;
  }
  console.log("sum : ", s);
}
f2(2, 1, 4, 5, 3);

const f5 = (x, y, ...z) => {
  //   '...' is rest operator
  console.log("in f5");
  console.log(x, y, z);
};
f5(23, 34, 3, 42);

//closure functions
//if there i a function which has access to its parent function scope
//then it is called as closure functions

function combination(n, r) {
  //closure function. because it has access to it's parents scope.
  function factorial(n) {
    //this function can be only used inside combination function only
    var f = 1;
    for (var i = 1; i <= n; i++) {
      f = f * i;
    }
    return f;
  }

  //factorial of n
  //factorail of (n-r)
  return factorial(n) / factorial(n - r);
}

//self calling function
//can be called only once
(function () {
  console.log("in function f5");
  f5();
})();

(function (x, y) {
  console.log(" in f6 ", x, y);
})(12, 13);
