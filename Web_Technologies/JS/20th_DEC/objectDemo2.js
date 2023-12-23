//constructor function
/*
var Person = function (id, name, mobile) {
  this.id = id;
  this.name = name;
  this.mobile = mobile;
};
*/
/*
var Employee = function (dept, desg) {
  this.dept = dept;
  this.desg = desg;
  //this.mobile = mobile;
};
*/
//var p1 = new Person(12, "XXX", 2222);
//var e1 = new Employee("HR", "mgr");
//e1.__proto__ = p1; //'__proto__' is a property // all properties of p1 will be available in e1
/*
for (var p in e1) {
  if (e1.hasOwnProperty(p)) {
    console.log("Own Property: " + p + " ====>" + e1[p]);
  } else {
    console.log("Parent Property: " + p + " ====>" + e1[p]);
  }
}
*/
class Person {
  constructor(id, name, mobile) {
    this.id = id;
    this.name = name;
    this.mobile = mobile;
  }
  display() {
    console.log(
      "Person [ ID: " +
        this.id +
        " Name : " +
        this.name +
        " Mobile: " +
        this.mobile
    );
  }
  /*
  display() {
    console.log(
      `Person [ ID: ${this.id} Name : ${this.name}  Mobile: ${this.mobile}`
    );
  }
  ` is called template operator

  */
}
class Employee extends Person {
  constructor(id, name, mobile, dept, desg) {
    super(id, name, mobile);
    this.desg = desg;
    this.dept = dept;
  }
  display() {
    super.display();
    console.log(`Department : ${this.dept} Designation : ${this.desg}`);
  }
}
p1 = new Person(12, "yyy", 23423);
p1.email = "yy@gmail.com";
e1 = new Employee(12, "XXXXXX", 22222, "HR", "Manager");
e1.display();
//properties can be added after creating object.
e1.sal = 3456;
//all Employee objects may not have same no of properties.
