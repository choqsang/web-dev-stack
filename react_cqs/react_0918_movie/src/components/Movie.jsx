import React from "react";

const IMG_BASE_URL = "https://image.tmdb.org/t/p/w1280/";

// const Movie = () => {} + export default Movie; 합쳐서 아래와 같이 씀
export default function Movie({ title, poster_path, vote_average }) {
  return (
    <div className="movie-container">
      <img src={IMG_BASE_URL + poster_path} width="300px" />

      <div className="movie-info">
        <h4>
          {title} ({vote_average})
        </h4>
      </div>
    </div>
  );
}
