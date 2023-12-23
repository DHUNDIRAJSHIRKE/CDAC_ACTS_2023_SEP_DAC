function Calculate() {
  var sum;
  var num1 = parseInt(document.getElementById("nm1").value);
  var num2 = parseInt(document.getElementById("nm2").value);
  // //   var rad = document.getElementsById("rd1").value;
  // var rad = document.getElementsByName("rd");
  // for (var i = 0; i < rad.length; i++) {
  //   console.log(rad[i]);
  //   //  if(rad[i] ==  )
  // }

  var rad = document.querySelector('input[name="rd"]:checked').value;
  switch (rad) {
    case "Add":
      sum = num1 + num2;
      break;
    case "Sub":
      sum = num1 - num2;
      break;
    case "Multi":
      sum = num1 * num2;
      break;
    case "Div":
      sum = num1 / num2;
      break;
  }

  document.getElementById("result").value = sum;
}
