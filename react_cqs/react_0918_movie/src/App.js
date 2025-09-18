import "./index.css";
import Movie from "./components/Movie";
import { dummy } from "./movieDummy";

function App() {
  return (
    <div className="app-container">
      {/* <Movie dummy={dummy} /> */}
      {dummy.results.map((item) => {
        return (
          <Movie
            title={item.title}
            poster_path={item.poster_path}
            vote_average={item.vote_average}
          />
        );
      })}
    </div>
  );
}

export default App;
