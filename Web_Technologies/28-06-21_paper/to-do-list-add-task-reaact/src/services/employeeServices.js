import axios from "axios";
class EmployeeService {
  getEmployees() {
    return axios.get("http://localhost:8080/employees");
  }
  addEmployee(emp) {
    return axios.post(
      `http://localhost:8080/employees/employee/${emp.id}`,
      emp
    );
  }
  deleteEmployee(emp) {
    return axios.delete(`http://localhost:8080/employees/employee/${emp.id}`);
  }
  updateEmployee(emp) {
    return axios.put(`http://localhost:8080/employees/employee/${emp.id}`, emp);
  }
}

export default new EmployeeService();
