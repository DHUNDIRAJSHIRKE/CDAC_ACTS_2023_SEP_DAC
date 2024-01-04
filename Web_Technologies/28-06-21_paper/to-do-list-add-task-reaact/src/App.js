import logo from "./logo.svg";
import "./App.css";
import EmpTable from "./pages/EmpTable";
import { Routes, Route } from "react-router-dom";
import ToDoList from "./ToDoList";

function App() {
  return (
    <div className="App">
      {/* <Routes>
        <Route path="/" element={<EmpTable></EmpTable>}></Route>
        <Route path="/todolist" element={<ToDoList></ToDoList>}></Route>
      </Routes> */}
      <ToDoList></ToDoList>
    </div>
  );
}

export default App;
