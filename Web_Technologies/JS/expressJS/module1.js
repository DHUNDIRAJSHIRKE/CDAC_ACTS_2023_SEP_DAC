array = [
  { nm: "user1", passwd: "pass1" },
  { nm: "user2", passwd: "pass2" },
];
exports.validateuser = (uname, upass) => {
  var user = array.find((ob) => ob.nm === uname && ob.passwd === upass);
  if (user === undefined) {
    array.push({ nm: uname, passwd: upass });
    console.log(array);
  }
  return user === undefined ? null : user;
};

exports.addition = (x, y) => {
  var x = Number(x);
  var y = Number(y);
  return x + y;
};
exports.factorial = (n) => {
  var f = 1;
  for (var i = 1; i <= n; i++) {
    f = f * i;
  }
  return f;
};
