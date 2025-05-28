const body = document.querySelector("body");
const today = document.querySelector("#today");
const whattime = document.querySelector("#whattime");
const countdown = document.querySelector("#countdown");
const eng = document.querySelector("#eng");
const kor = document.querySelector("#kor");

// 화살표 함수 생성 - 최초 화면과 인터벌 상호작용 위해
const currentTime = () => {
  const weeks = ["일", "월", "화", "수", "목", "금", "토"];
  const nowday = new Date();
  //   console.log(nowday);
  //   console.log(nowday.getFullYear()); // 년도
  //   console.log(nowday.getMonth() + 1); // 월 (0: 1월, 1:2월 ~)
  //   console.log(nowday.getDate()); // 일
  //   console.log(weeks[nowday.getDay()]); // 요일 (0:일, 1:월 ~)
  //   console.log(nowday.getHours()); // 시
  //   console.log(nowday.getMinutes()); // 분
  //   console.log(nowday.getSeconds()); // 초

  const year = nowday.getFullYear();
  const month = Number(nowday.getMonth() + 1);
  const date = nowday.getDate();
  const day = weeks[nowday.getDay()];
  const hours = String(nowday.getHours()).padStart(2, "0");
  const minutes = String(nowday.getMinutes()).padStart(2, "0");
  const seconds = String(nowday.getSeconds()).padStart(2, "0");
  // 문자열.padStart 기능으로 최대 글자수와 빈 칸을 채우는 값 입력 가능.

  today.textContent = `${year}년 ${month}월 ${date}일 (${day})`;
  whattime.textContent = `${hours}:${minutes}:${seconds}`;
};

const count = () => {
  const dday = new Date("2026-01-01 00:00:00"); // 목표하는 날짜
  const now = new Date();
  const cs = Math.floor((dday - now) / 1000); // 초단위 = ms/1,000
  const cm = Math.floor(cs / 60); // 1m = 60s
  const ch = Math.floor(cm / 60); // 1h = 60m
  const cd = Math.floor(ch / 24); // 1d = 24h
  //   console.log(cd);
  //   console.log(ch % 24);
  //   console.log(cm % 60);
  //   console.log(cs % 60);

  countdown.textContent = `올해 남은 시간 ${cd}일 ${ch % 24}시간 ${cm % 60}분 ${
    cs % 60
  }초`;
};

// 특정 색상 로테이션 원할 경우, 개별 함수 생성
/* const randomBck = () => {
  const body = document.body;
  const backGround = [
    "#ED833A",
    "#EA839B",
    "#42B667",
    "#FFC228",
    "#005456",
    "#ACDED5",
  ];
  body.style.background =
    backGround[Math.floor(Math.random() * backGround.length)];
}; */

const randomBck = () => {
  const body = document.body;
  const r = Math.floor(Math.random() * 256); // 0<=random<256
  const g = Math.floor(Math.random() * 256);
  const b = Math.floor(Math.random() * 256);
  body.style.background = `rgba(${r}, ${g}, ${b}, 0.5)`;
};

import quotes from "./quotes.js";
// 위 명령어와 함께 파일명(확장자 .js 포함하여) 기재하면 불러올 수 있음.
// 소스 파일의 이름이 변경될 경우, 업데이트 여부 팝업창 확인할 수 있음.
// 기재되는 지점부터 읽어올 수 있기 때문에, 일반적으로는 최상단에 위치한다.

function randomQuote() {
  const randomq = quotes[Math.floor(Math.random() * quotes.length)];
  //   console.log(quotes[0].en);
  //   console.log(quotes[0].ko);
  //   console.log(randomq.ko);
  eng.textContent = randomq.en;
  kor.textContent = randomq.ko;
}

// setInterval : 일정 시간마다 동작 / 인터벌 설정
setInterval(() => {
  currentTime();
  count();
}, 1000); // 1000 : 1초

setInterval(() => {
  randomBck();
  randomQuote();
}, 3000);
