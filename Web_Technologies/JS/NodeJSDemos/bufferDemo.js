var buf = Buffer.alloc(80);
console.log(buf.toString());
for (var i = 0; i < 26; i++) {
  buf[i] = i + 65;
}
console.log(buf.toString("ascii"));
//to display 1st 5 characters, convert it into utf8 encoding
//writing encoding format is optional
console.log(buf.toString("utf8", 0, 5));
console.log(buf.toString("utf8", 5, 8));

var buf1 = Buffer("node");
console.log(buf1.toString());

var portion = buf.slice(6, 9);
console.log(portion.toString());
