import React, { useEffect, useState } from "react";
import employeeServices from "../services/employeeServices";

export default function EmpTable() {
  const [empArr, setEmpArr] = useState([]);
  useEffect(() => {
    employeeServices
      .getEmployees()
      .then((result) => {
        setEmpArr([...result.data]);
      })
      .catch((err) => console.log(err));
  }, []);
  return (
    <div>
      EmpTable
      <table className="table">
        <thead>
          <tr>
            <td>Emp ID </td>
            <td>Emp name</td>
            <td>Salary</td>
            <td>Department</td>
            <td>Action</td>
          </tr>
        </thead>
        <tbody>
          {empArr.map((e) => (
            <tr key={e.id}>
              <td>{e.id}</td>
              <td>{e.name}</td>
              <td>{e.sal}</td>
              <td>{e.dept}</td>
              <td>
                <button>Edit</button>
                <button>Delete</button>
                <button>View Details</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <button type="button" id="edit" name="edit">
        Edit
      </button>
    </div>
  );
}
