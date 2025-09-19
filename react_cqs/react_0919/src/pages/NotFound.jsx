import React from "react";
import { Link } from "react-router-dom";
export default function NotFound() {
  return (
    <div className="page-container">
      <div>해당 페이지를 찾지 못했습니다</div>
      <div>주소가 잘못 되었거나 더 이상 제공되지 않는 페이지입니다</div>
      <div>
        <Link to="/">메인 페이지로 이동</Link>
      </div>
    </div>
  );
}
