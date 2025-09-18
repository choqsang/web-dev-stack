import "./index.css"; // 동일 주소 (같은 폴더) 안에 있을 경우 ./ 로 표시
import Navbar from "./components/Navbar";

import { BrowserRouter as Router, Route, Routes, Link } from "react-router-dom";
// import Users from "./pages/Users";
// import Home from "./pages/Home";
// import Movies from "./pages/Movies";
import routes from "./routes";

function App() {
  return (
    <Router>
      <div className="App">
        <Navbar />
        {/* <Routes>
          <Route path="/movies" element={<Movies />}></Route>
          <Route path="/users" element={<Users />}></Route>
          <Route path="/" element={<Home />}></Route>
        </Routes> */}
        <div>
          {routes.map((r) => {
            return (
              <Routes>
                <Route path={r.path} element={<r.component />}></Route>
              </Routes>
            );
          })}
        </div>
      </div>
    </Router>
  );
}

export default App;
