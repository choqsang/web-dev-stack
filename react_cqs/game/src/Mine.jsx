import React, { useState } from "react";
import App from "./App";

// 25개 칸 + 5개 타겟 생성
const boardSize = 25;
const targetCount = 5;

// 랜덤으로 타겟 위치를 선택하는 함수
const generateRandomTargets = () => {
  const targets = new Set();
  while (targets.size < targetCount) {
    targets.add(Math.floor(Math.random() * boardSize));
  }
  return Array.from(targets);
};

export default function MineSweeper() {
  const [targetPositions] = useState(generateRandomTargets());
  const [clickedCells, setClickedCells] = useState([]);

  const handleCellClick = (index) => {
    // Check if the cell has already been clicked
    if (clickedCells.includes(index)) {
      return; // If it's already clicked, do nothing
    }

    // Add the clicked cell to the state
    setClickedCells([...clickedCells, index]);

    // Check if the clicked cell is a target
    if (targetPositions.includes(index)) {
      alert("타겟을 찾았습니다!");
    }
  };

  return (
    <div>
      <div className="scoreboard">
        <h1>찾기</h1>
      </div>
      <div
        className="board"
        style={{
          display: "grid",
          gridTemplateColumns: "repeat(5, 0fr)",
          gap: "1px",
        }}
      >
        {/* 25개의 칸을 렌더링 */}
        {Array.from({ length: boardSize }).map((_, index) => (
          <App
            key={index}
            index={index}
            onClick={() => handleCellClick(index)}
            isClicked={clickedCells.includes(index)}
            isTarget={targetPositions.includes(index)}
          />
        ))}
      </div>
    </div>
  );
}
