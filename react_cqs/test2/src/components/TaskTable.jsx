import React, { useState } from "react";

function TaskTable({ t, delTask }) {
  return (
    <table border="1">
      <thead>
        <tr>
          <th>할 일</th>
          <th>마감일</th>
          <th>작업</th>
        </tr>
      </thead>
      <tbody>
        {/* {t.map((t) => ( */}
        {t.map((t, index) => (
          <tr>
            <td>{t.name}</td>
            <td>{t.date}</td>
            <td>
              <input
                type="button"
                value="삭제"
                onClick={() => {
                  // delTask(t.id);
                  delTask(index);
                }}
              ></input>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default TaskTable;
