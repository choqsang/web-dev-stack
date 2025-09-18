import React, { useState } from "react";
import Movie from "../components/Movie";
import MovieForm from "../components/MovieForm"; // 컴포넌트 경로

const Movies = () => {
  const [movies, setMovies] = useState([]);
  // ([
  //   { title: "해리포터1", year: 2001 },
  //   { title: "쥬라기월드", year: 2025 },
  // ]);

  const removeMovie = (id) => {
    //alert(id);
    setMovies(
      movies.filter((m) => {
        return m.id != id;
      })
    );
  };

  const addMovie = (movie) => {
    //e.preventDefault();
    // alert(movie.title + "/" + movie.year);
    if (movie.title.trim() && movie.year.trim()) {
      setMovies([...movies, movie]);
    }
  };

  const renderMovies = movies.length
    ? movies.map((m) => (
        // map을 함수로 구현
        <Movie m={m} removeMovie={removeMovie} />
        // 별도 component로 분리하여 소환 (import 필수)
      ))
    : "등록된 영화가 없습니다";

  return (
    <div>
      <h1>Movie List</h1>
      <MovieForm addMovie={addMovie} />
      <hr />
      {renderMovies}
    </div>
  );
};

export default Movies;
