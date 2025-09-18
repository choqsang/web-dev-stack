import React, { useState } from "react";

// Tailwind CSS를 사용하기 위한 CDN 스크립트
// 이 스크립트가 없으면 Tailwind 클래스들이 동작하지 않습니다.
// 단일 HTML 파일에서 React 컴포넌트를 렌더링할 때 필요합니다.
const tailwindScript = document.createElement("script");
tailwindScript.src = "https://cdn.tailwindcss.com";
document.head.appendChild(tailwindScript);

// Lucide React 아이콘 라이브러리 (선택 사항)
// 이 예제에서는 텍스트 이모지로 대체합니다.

const CELL_COUNT = 25; // 5x5 그리드

// 게임의 주요 컴포넌트입니다.
export default function MineSweeper() {
  // 게임 상태를 관리하는 state
  const [targetIndex, setTargetIndex] = useState(
    Math.floor(Math.random() * CELL_COUNT)
  );
  const [clickedCells, setClickedCells] = useState(
    Array(CELL_COUNT).fill(false)
  );
  const [message, setMessage] = useState("폭탄을 찾아보세요!");
  const [isGameOver, setIsGameOver] = useState(false);

  // 셀 클릭 핸들러
  const handleCellClick = (index) => {
    // 게임이 끝났거나 이미 클릭된 셀이면 아무것도 하지 않습니다.
    if (isGameOver || clickedCells[index]) {
      return;
    }

    // 클릭된 셀 상태를 업데이트합니다.
    const newClickedCells = [...clickedCells];
    newClickedCells[index] = true;
    setClickedCells(newClickedCells);

    // 타겟을 맞췄는지 확인합니다.
    if (index === targetIndex) {
      setMessage("폭탄을 찾았습니다! 😎");
      setIsGameOver(true);
    } else {
      setMessage("아쉽네요! 계속 찾아보세요.");
    }
  };

  // 게임 재시작 핸들러
  const handleRestart = () => {
    setTargetIndex(Math.floor(Math.random() * CELL_COUNT));
    setClickedCells(Array(CELL_COUNT).fill(false));
    setMessage("새로운 게임을 시작합니다.");
    setIsGameOver(false);
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100 p-4">
      <div className="bg-white p-6 rounded-xl shadow-lg text-center">
        <h1 className="text-3xl font-bold mb-4 text-gray-800">지뢰 찾기</h1>
        <p className="mb-4 text-xl font-semibold text-gray-600">{message}</p>
        <div className="grid grid-cols-5 gap-2">
          {Array.from({ length: CELL_COUNT }).map((_, index) => {
            const isClicked = clickedCells[index];
            const isTarget = index === targetIndex;

            // 조건에 따라 셀의 배경색과 내용물을 결정
            let cellContent = "❔";
            let cellBgColor = "bg-gray-200 hover:bg-gray-300";
            let cellTextColor = "text-gray-500";

            if (isClicked) {
              if (isTarget) {
                cellContent = "💣";
                cellBgColor = "bg-red-500";
                cellTextColor = "text-white";
              } else {
                cellContent = "O";
                cellBgColor = "bg-green-500";
                cellTextColor = "text-white";
              }
            }

            return (
              <div
                key={index}
                className={`w-14 h-14 sm:w-16 sm:h-16 md:w-20 md:h-20 flex items-center justify-center rounded-xl border-2 border-gray-300 cursor-pointer text-2xl font-bold transition-colors duration-300 ${cellBgColor} ${cellTextColor}`}
                onClick={() => handleCellClick(index)}
              >
                {cellContent}
              </div>
            );
          })}
        </div>
        <button
          onClick={handleRestart}
          className="mt-6 px-6 py-3 bg-blue-500 text-white rounded-xl shadow-md hover:bg-blue-600 transition-colors duration-300 transform hover:scale-105"
        >
          게임 재시작
        </button>
      </div>
    </div>
  );
}
