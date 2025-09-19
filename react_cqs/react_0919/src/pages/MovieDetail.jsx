import React from "react";
import { useLocation, useParams } from "react-router-dom";

const IMG_BASE_URL = "https://image.tmdb.org/t/p/w1280/";

export default function MovieDetail() {
  // query가 아닌 path 타입으로 넘기는 방법
  const { title } = useParams();
  const { state } = useLocation();
  // Movie에서 클릭을 통해 navigate로 넘어오는 parameter값을 hook로 받음

  return (
    <div className="page-container">
      <img
        src={IMG_BASE_URL + state.poster_path}
        style={{ width: "300px", height: "450px" }}
      />
      <div>
        <h3>{title}</h3>
        <h4>{state.vote_average}</h4>
      </div>
    </div>
  );
}
