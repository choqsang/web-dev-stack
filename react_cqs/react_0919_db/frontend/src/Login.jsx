import React, { useState } from "react";
import { Link } from "react-router-dom";
import LoginValidation from "./LoginValidation";
import axios from "axios";

function Login() {
  const [values, setValues] = useState({ email: "", password: "" });
  const [errors, setErrors] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    setErrors(LoginValidation(values));
    // setErrors(<LoginValidation values={values} />);
    axios.post("http://localhost:3000/login", values).then((res) => {
      // 위 경로를 통해 비동기 통신으로 res값을 받아옴 (성공/실패)
      if (res.data == "Success") {
        window.location.href = "/main_content";
      } else {
        alert("아이디나 비밀번호가 일치하지 않습니다");
      }
    });
  };

  const handleInput = (e) => {
    // console.log(e.target.name);
    // console.log(e.target.value);
    setValues({ ...values, [e.target.name]: [e.target.value] });
  };

  return (
    <div className="d-flex justify-content-center align-items-center bg-primary vh-100">
      <div className="bg-white p-3 rounded w-25">
        <form action="" onSubmit={handleSubmit}>
          {/* 리액트에서 form 태그에 있는 액션은 별로 중요치 않음 */}
          <div className="mb-3">
            <label>Email</label>
            <input
              placeholder="enter email"
              onChange={handleInput}
              name="email"
            />
          </div>

          <div className="mb-3">
            <label>Password</label>
            <input
              type="password"
              placeholder="enter password"
              onChange={handleInput}
              name="password"
            />
          </div>

          <button type="submit" className="btn btn-success">
            로그인
          </button>

          <p>계정이 없으신가요??</p>
          <Link to="/signup" className="btn btn-default border">
            회원 가입
          </Link>
        </form>
      </div>
    </div>
  );
}

export default Login;
