import React, { useState } from "react";

export default function ToDoList() {
  const [task, setTask] = useState([{ taskName: "", durations: "" }]);
  const add = () => {
    let tname = document.getElementById("task").value;
    let dur = document.getElementById("task").value;
    if (tname !== "") {
      setTask([...task, { taskName: tname, durations: dur }]);
    }
  };

  return (
    <div>
      ToDoList
      <form>
        Enter task:
        <input name="task" id="task" />
        Enter Duration:
        <input name="duration" id="dur" />
        <button name="add" id="add" type="button" onClick={add}>
          Add Task
        </button>
      </form>
      <div>
        <table>
          <thead>
            <td>task Name</td>
            <td>Duration</td>
          </thead>
          <tbody>
            {task.map((e) => (
              <tr key={e.taskName}>
                <td>{e.taskName}</td>
                <td>{e.durations}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
