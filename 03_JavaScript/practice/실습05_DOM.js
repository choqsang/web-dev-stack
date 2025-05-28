const date = document.querySelector("#date");
const timer = document.querySelector("#timer");
const left = document.querySelector("#left");
const main = document.querySelector("main");

const randomColor1 = Math.floor(Math.random() * 255);
const randomColor2 = Math.floor(Math.random() * 255);
const randomColor3 = Math.floor(Math.random() * 255);

// console.log(randomColor1);
// console.log(randomColor2);
// console.log(randomColor3);

// setInterval : 일정 시간마다 동작
let sec = 0;
setInterval(() => {
  timer.textContent = Date().split(" ")[4];
}, 1000);

// setInterval(() => {main.background = rgb()}, 2000);

const now = new Date();
main.style.background = `rgb(${randomColor1}, ${randomColor2}, ${randomColor3})`;

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

date.textContent = `${now.getFullYear()}년 ${
  now.getMonth() + 1
}월 ${now.getDate()}일`;
// const timer = document.querySelector("#timer");
// timer.textContent = `${now.getHours()} : ${
//   now.getMinutes() + 1
// } : ${now.getSeconds()}`;
