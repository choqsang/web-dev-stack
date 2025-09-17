import React from "react";

// .jsx (JavaScript XML)는 JavaScript를 html구조와 동일하게 작성하게끔 만든 환경
// 리액트(React)에서 컴포넌트의 UI를 정의할 때 주로 사용됩니다.

// function Movie() {} 와 같은 구조가 아닌 변수 형태로도 존재할 수 있음
// 기존 사용한 map의 parameter 값을 받아옴
const Movie = ({ m, removeMovie }) => {
  return (
    <div className="movie">
      <div className="movie-title">
        {m.title}
        <span className="movie-year">({m.year})</span>
      </div>
      <div>
        <input
          type="button"
          value="삭제"
          onClick={() => {
            removeMovie(m.id);
          }}
        />
      </div>
    </div>
  );
};

export default Movie;
