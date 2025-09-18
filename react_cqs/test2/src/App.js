import { useState } from "react";
import logo from "./logo.svg";
import TaskForm from "./components/TaskForm";
import TaskTable from "./components/TaskTable";

function App() {
  const [taskArr, setTask] = useState([]);
  const addTask = (task) => {
    if (task.name.trim() && task.date.trim()) {
      setTask([...taskArr, task]);
    }
  };
  // const delTask = (id) => {
  //   let newTask = taskArr.filter((t) => {
  //     return t.id != id;
  //   });
  //   setTask(newTask);
  // };
  const delTask = (index) => {
    let newTask = taskArr.filter((_, i) => i !== index);
    setTask(newTask);
  };

  return (
    <div className="App">
      <h1>할 일 목록</h1>
      <TaskForm addTask={addTask} />
      <hr />
      <TaskTable t={taskArr} delTask={delTask} />
    </div>
  );
}

export default App;
