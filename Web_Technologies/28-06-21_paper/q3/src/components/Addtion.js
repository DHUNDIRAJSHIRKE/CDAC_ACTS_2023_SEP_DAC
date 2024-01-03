import React from "react";

export default function Addtion() {
  const add = () => {
    let num1 = document.getElementById("num1").value;
    let num2 = document.getElementById("num2").value;
    if (isNaN(parseInt(num1)) || isNaN(parseInt(num2))) {
      alert("Enter Numbers only!!");
    } else {
      var sum = parseInt(num1) + parseInt(num2);
      var str = "The sum of the above numbers is : " + sum;
      document.getElementById("result").innerHTML = str;
    }
  };
  return (
    <div>
      Addtion
      <form>
        num1:
        <input type="number" name="num1" id="num1" />
        num2:
        <input type="number" name="num2" id="num2" />
        <button type="button" onClick={add}>
          Add
        </button>
      </form>
      <div id="result"></div>
    </div>
  );
}
