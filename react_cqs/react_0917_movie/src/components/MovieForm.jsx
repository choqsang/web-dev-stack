import React, { useState } from "react";
import InputField from "./InputField";

const MovieForm = ({ addMovie }) => {
  const [movieTitle, setMovieTitle] = useState("");
  const [movieYear, setMovieYear] = useState("");
  const [titleError, setTitleError] = useState("");
  const [yearError, setYearError] = useState("");

  const validateForm = () => {
    let validated = true;
    // 공백 방지 필요
    if (!movieTitle && movieYear) {
      setTitleError("영화 제목을 입력해주세요");
      setYearError("");
      validated = false;
    }
    if (!movieYear && movieTitle) {
      setTitleError("");
      setYearError("개봉 연도를 입력해주세요");
      validated = false;
    }
    if (!movieYear && !movieTitle) {
      setTitleError("영화 제목을 입력해주세요");
      setYearError("개봉 연도를 입력해주세요");
      validated = false;
    }
    return validated;
  };

  const onSubmit = (e) => {
    e.preventDefault();

    if (validateForm()) {
      addMovie({ id: Date.now(), title: movieTitle, year: movieYear });
      setTitleError("");
      setYearError("");

      // 등록 실패 시 초기화 없도록 위치 이동
      // add와 무관하게 초기화 원할 경우, 괄호 바깥으로 빼내면 된다
      setMovieTitle("");
      setMovieYear("");
      alert("등록이 완료되었습니다.");
    }
    // Date.now() : 1ms 단위로 부여되기 때문에, 고유 식별값(중복 제거)을 얻기 위해 종종 쓰곤 한다
  };

  return (
    <form onSubmit={onSubmit}>
      <InputField
        value={movieTitle}
        placeholder={"영화 제목을 입력하세요."}
        onChange={(e) => {
          setMovieTitle(e.target.value);
        }}
        errorMessage={titleError}
      />
      <InputField
        value={movieYear}
        placeholder={"개봉 연도를 입력하세요."}
        onChange={(e) => {
          setMovieYear(e.target.value);
        }}
        errorMessage={yearError}
      />
      <input type="submit" value="영화 등록" />
    </form>
  );
};

export default MovieForm;

/* 
    export default function MovieForm(){ 리턴값 } 을 맨 위에 적기도 함
*/
