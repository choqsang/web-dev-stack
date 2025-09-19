const express = require("express");
const mysql = require("mysql2"); // npm i myslq2 이후 변경하였음
const cors = require("cors");

const app = express();
app.use(cors());
app.use(express.json());

// DB 연결 정보
const db = mysql.createConnection({
  host: "localhost", // 호스트명
  user: "root", // 유저명
  password: "qwer1234", // 비밀번호
  database: "signup", // 스키마 이름
});

// DB 접속 및 쿼리 요청
app.post("/signup", (req, res) => {
  // 요청 처리 객체(request)와 응답 처리 객체(response)를 사용
  const sql = "INSERT INTO login (`name`, `email`, `password`) VALUES (?)";
  // 변수 backtick으로 묶어서 받아야 한다 (템플릿 리터럴)
  const values = [req.body.name, req.body.email, req.body.password];
  // 리퀘스트 body에 저장된 데이터를 쿼리문에 담기 위한 세팅

  db.query(sql, [values], (err, data) => {
    // 수행하고자 하는 쿼리문과 값 입력
    if (err) {
      return res.json("Error"); // 문제 발생 시 에러 출력
    }
    return res.json(data); // 정상적으로 수행 시 data 값을 가지고 나옴
  });
});

// 로그인 요청
app.post("/login", (req, res) => {
  const sql = "SELECT * FROM login WHERE `email` =? and `password`=?";
  const values = [req.body.email, req.body.password];

  db.query(sql, values, (err, data) => {
    if (err) {
      return res.json("Error");
    }
    if (data.length > 0) {
      // data값이 있을 경우
      return res.json("Success");
    } else {
      return res.json("Fail");
    }
  });
});

app.listen(3000, () => {
  console.log("listening");
});
// app을 들고 3000번 포트로 이동
