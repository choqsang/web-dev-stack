import { BrowserRouter, Route, Router, Routes } from "react-router-dom";
import Home from "./pages/Home";
import Celebrity from "./pages/Celebrity";
import Movies from "./pages/Movies";
import TV from "./pages/TV";
import NotFound from "./pages/NotFound";
import Header from "./components/Header";

import "./index.css";
import MovieDetail from "./pages/MovieDetail";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/movie" element={<Movies />} />
          <Route path="/movie/:title" element={<MovieDetail />} />
          {/* title (parameter)을 받아서 새로운 컴포넌트로 전송 */}
          <Route path="/tv" element={<TV />} />
          <Route path="/person" element={<Celebrity />} />
          <Route path="/*" element={<NotFound />} />{" "}
          {/* 해당 경로는 지정되지 않은 나머지 경로일 경우에 대한 컴포넌트 설정 */}
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
