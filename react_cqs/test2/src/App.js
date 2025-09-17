import { useState } from "react";
import logo from "./logo.svg";
import TaskForm from "./components/TaskForm";
import TaskTable from "./components/TaskTable";

function App() {
  const [tasks, setTask] = useState([]);
  const addTask = (task) => {
    if (task.name.trim() && task.date.trim()) {
      setTask([...tasks, task]);
    }
  };
  const delTask = (id) => {
    let newTask = tasks.filter((t) => {
      return t.id != id;
    });
    setTask(newTask);
  };

  return (
    <div className="App">
      <h1>할 일 목록</h1>
      <TaskForm addTask={addTask} />
      <hr />
      <TaskTable t={tasks} delTask={delTask} />
    </div>
  );
}

export default App;
