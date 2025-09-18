import React, { useState } from "react";

const TaskForm = ({ addTask }) => {
  const [taskName, setTaskName] = useState("");
  const [dueDate, setDueDate] = useState("");

  const onSubmit = (e) => {
    e.preventDefault();
    // addTask({ id: Date.now(), name: taskName, date: dueDate });
    addTask({ name: taskName, date: dueDate });
    // alert("name : " + taskName + "\ndate : " + dueDate);
    setTaskName("");
    setDueDate("");
  };

  return (
    <form onSubmit={onSubmit}>
      <input
        type="text"
        value={taskName}
        placeholder="할 일을 입력하세요"
        onChange={(e) => {
          setTaskName(e.target.value);
        }}
      />
      <br />
      <input
        type="date"
        value={dueDate}
        placeholder="마감일 (예: 2025-09-20)"
        onChange={(e) => {
          setDueDate(e.target.value);
        }}
      />
      <button type="submit">추가</button>
    </form>
  );
};

export default TaskForm;
