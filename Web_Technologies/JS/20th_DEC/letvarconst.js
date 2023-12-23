var x = 23;
var x = "XXXX"; //global or funtion scope
console.log(x);
let y = 34; //blocked scope
for (let j = 20; j < 30; j++) {
  y++;
}
//console.log(" let j after the loop:", j);//j isn't declare here as it's scope is limited to for loop only.
//if the for loop was for(var j =....) then it would be accessible outside the loop as well.
for (var k = 32; k < 54; k++) {
  y++;
}
console.log(" var k After the loop:", k);
var g = 32;
function f1() {
  let f = 534;
  if (g > 30) {
    var x = "aaa";
    let v = 320;
  }
  console.log("Using var ", g);
  console.log("using f", f);
}

console.log("Using var g", g);
console.log("using f", f);
f1();
//variable hoisting is possible in var
//hoisting is not possible in let
//hoisting  : raising. shifting something up.
// in this context,
//var p;<-- implicitly done i.e. declaration is hoisted.
console.log("variable without declaration", p); //undefined!!
var p = 23;
//same thing isn't applicable to 'let'
console.log("variable without declaration", p); //Uncaught ReferenceError!!
var p = 23; //in let hoisting isn't allowed, in var hoisting is allowed.

//other than let, var third way to declare a variable is const
const c = 34;
//c=54;//change in the value of constant is not allowed
function f2() {}
//ECMA5
const f3 = function () {
  //if const isn't written, it will be var by default, so the variable containing this function may later contain another function
};
//ECMA6
const f4 = () => {};
f4();

/*
let                             var                                  const

Redeclaration           Redeclaration is                        Redeclaration is
is not possible         possible                                not possible

variables are blocked    global or blocked scoped               constants are blocked scope
scoped

Hoisting not possible   hoisting possible                   hoisting not possible

let c;                  var v;                              const f=23;


*/
