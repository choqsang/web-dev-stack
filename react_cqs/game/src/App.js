import React from "react";

export default function App({ index, onClick, isClicked, isTarget }) {
  // 간단한 스타일링을 위해 인라인 스타일 적용
  const cellStyle = {
    width: "50px",
    height: "50px",
    border: "1px solid black",
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
    cursor: "pointer",
  };

  let content = isClicked ? "" : "❔";
  if (isTarget && isClicked) {
    content = "🎉";
  }

  return (
    <div style={cellStyle} onClick={onClick}>
      {/* 칸의 번호를 표시 / {index + 1} */}
      {content}
    </div>
  );
}
