import Home from "./pages/Home";
import Movies from "./pages/Movies";
import User from "./pages/User";
import Users from "./pages/Users";

export default [
  // 경로 설정을 위한 별도 js파일 생성
  { path: "/", component: Home },
  { path: "/movies", component: Movies },
  { path: "/users", component: Users },
  { path: "/users/:id", component: User },
  // ?id(특정 parameter) 와 같은 개념
  // users 호출 시 id를 받게 된다면 user로 전송됨
];
