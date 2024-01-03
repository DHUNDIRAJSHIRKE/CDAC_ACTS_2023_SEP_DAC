class Employee {
  constructor() {
    this.emparray = [
      { id: 1, name: "Atharva", sal: "3000", dept: "2" },
      { id: 2, name: "Vishal", sal: "9000", dept: "3" },
      { id: 3, name: "Lakshya", sal: "5000", dept: "4" },
      { id: 4, name: "Mihir", sal: "7000", dept: "2" },
    ];
  }
  getAllEmployees() {
    return this.emparray;
  }
  getEmpByID(ID) {
    var id = Number.parseInt(ID);
    for (let i = 0; i < this.emparray.length; i++) {
      if (this.emparray[i].id == id) {
        return this.emparray[i];
      }
    }
  }
  insertEmployee(emp) {
    this.emparray.push(emp);
  }
  deleteEmployee(ind) {
    var id = this.emparray.findIndex((e) => parseInt(e.id) === parseInt(ind));
    this.emparray.splice(id, 1);
  }
  updateEmployee(emp) {
    let foundIndx = this.emparray.findIndex(
      (e) => parseInt(e.id) === parseInt(emp.id)
    );
    this.emparray.splice(foundIndx, 1, emp);
  }
}
module.exports = new Employee();
