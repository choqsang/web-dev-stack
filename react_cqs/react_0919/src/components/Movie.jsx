import React from "react";
import { useNavigate } from "react-router-dom";

const IMG_BASE_URL = "https://image.tmdb.org/t/p/w1280/";

export default function Movie(props) {
  const navigate = useNavigate();
  // page 전환을 위한 hook 설정

  const onClickMovieItem = () => {
    navigate(`/movie/${props.title}`, { state: props });
    // title 정보를 넘김(경로 설정)과 동시에, state 정보(props의 요소)를 함께 전달함
  };

  return (
    <div className="movie-container" onClick={onClickMovieItem}>
      <img src={IMG_BASE_URL + props.poster_path} />

      <div className="movie-info">
        <h4>{props.title}</h4>
        <span>{props.vote_average}</span>
      </div>
    </div>
  );
}
