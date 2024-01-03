class Employee {
  constructor() {
    this.emparray = [
      { id: "1", name: "Atharva", sal: "3000", dept: "2" },
      { id: "2", name: "Vishal", sal: "9000", dept: "3" },
      { id: "3", name: "Lakshya", sal: "5000", dept: "4" },
      { id: "4", name: "Mihir", sal: "7000", dept: "2" },
    ];
  }
  getAllEmployees() {
    return this.emparray;
  }
  getEmpByID(id) {
    for (let i = 0; i < this.emparray.length; i++) {
      if (this.emparray[i].id == id) {
        return this.emparray[i];
      }
    }
  }
  insertEmployee(emp) {
    this.emparray.push(emp);
  }
  deleteEmployee(id) {
    var ind = this.emparray.findIndex((e) => e.id === id);
    this.emparray.splice(ind, 1);
  }
  updateEmployee(emp) {
    let foundIndx = this.emparray.findIndex((e) => e.id === emp.id);
    this.emparray[foundIndx] = emp;
  }
}
module.exports = new Employee();
