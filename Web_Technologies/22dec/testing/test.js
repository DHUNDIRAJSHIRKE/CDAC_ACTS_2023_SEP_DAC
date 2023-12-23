var st1 = "heelooo";
var st2 = "wooorls";
var st3 = "The quick brown fox jumps over the lazy dog";
var position = str3.match(/s.*?o/);
var res = st1.toUpperCase() + st2.toLowerCase();
// res = st1.toUpperCase();

// document.getElementById("Mydiv").innerHTML = st1;
function fun() {
  document.getElementById("Mydiv").innerHTML = res;
  document.getElementById("Mydiv").innerHTML = position;
}
