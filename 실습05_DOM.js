// const now = new Date();
// console.log("현재 : ", now); // date : 현재 시각 표시
// console.log(
//   `${now.getFullYear()}년 ${now.getMonth() + 1}월 ${now.getDate()}일`
// ); // month만 '0'부터 시작해서 하나씩 밀리기 때문에 +1을 추가해준다.
// const date = new Date(2025, 12 - 1, 16, 17, 50, 0); // 월(month)이 하나 늘어나서 불편하니 쓰지 말고,
// console.log("특정날짜 : ", date);

// // setInterval : 일정 시간마다 동작

let sec = 0;
setInterval(() => {
  timer.textContent = Date().split(" ")[4];
}, 1000);

const now = new Date();

// date.innerHTML = Date().split(" ")[]
// 변수.innerHTML = Date().split(" ")[]

console.log(Date());
console.log(Date().split(" ")[0]); // 요일
console.log(Date().split(" ")[1]); // 월
console.log(Date().split(" ")[2]); // 날짜
console.log(Date().split(" ")[3]); // 연도
console.log(Date().split(" ")[4]); // 시:분:초
console.log(Date().split(" ")[5]); // 시간대

// console.log(
//   `${now.getFullYear()}년 ${now.getMonth() + 1}월 ${now.getDate()}일` +
//     `  ${now.getDay()}` );

const date = document.querySelector("#date");
date.textContent =
  `${now.getFullYear()}년 ${now.getMonth() + 1}월 ${now.getDate()}일` +
  // const timer = document.querySelector("#timer");
  // timer.textContent = `${now.getHours()} : ${
  //   now.getMinutes() + 1
  // } : ${now.getSeconds()}`;

  console.log(Number());
const date2 = new Date(2025, 12, 31, 23, 59, 59, 0);
