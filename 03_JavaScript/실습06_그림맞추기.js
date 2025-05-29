// 칸마다 3가지 이미지가 랜덤으로 돌아가며, 클릭할 때마다 체크
// 3칸 모두 동일한 이미지일 경우 게임이 멈추며 종료 (하단 메시지 출력)
// 클릭 시도 횟수 반영, 리스타트 시 게임 재시작

const click = document.querySelector("#click"); // 클릭 이벤트 걸어야 하는 객체
const restart = document.querySelector("#restart");
const img = document.querySelectorAll("img");
// 클릭했을 때 바꿔야 하는 요소 - 각각 처리하기 위해 아래 3개로 나누어 지정하였음.
const spy1 = document.querySelector("#spy1");
const spy2 = document.querySelector("#spy2");
const spy3 = document.querySelector("#spy3");

// const count = document.querySelector("#clickcount");
const finish = document.querySelector("#finish");

// let i = 0;
// click.addEventListener("click", (e) => {
//   //   console.log(spys[i]);
//   const random1 = Math.floor(Math.random() * 3) + 1;
//   const random2 = Math.floor(Math.random() * 3) + 1;
//   const random3 = Math.floor(Math.random() * 3) + 1;
//   spy1.style.backgroundImage = `url("./assets/spy${random1}.jpg")`;
//   spy2.style.backgroundImage = `url("./assets/spy${random2}.jpg")`;
//   spy3.style.backgroundImage = `url("./assets/spy${random3}.jpg")`;

//  // 속성 추가 활용을 몰라서 CSS내 배경 삽입을 통한 코드 진행
//  // input 형식의 버튼 타입 추가가 아니더라도 disabled 기능은 수행된다.

//   if (click.value == `Click`) i = 0;
//   i += 1;
//   // count.textContent = `${i}`;
//   click.value = `Click ${i}`;

//   if (random1 == random2 && random2 == random3) {
//     // finish.textContent =
//     //   "축하합니다! 다시 시작하려면 재시작 버튼을 눌러주세요!";
//     finish.style.visibility = "visible";
//     const click = document.getElementById("click");
//     click.disabled = true;
//     // click.addEventListener("onclick", () => {
//     //   e.preventDefault;
//     // });
//   }
// });

// restart.addEventListener("click", (e) => {
//   // 리스타트를 눌렀을 때, 초기화면으로 돌아갈 수 있도록 기본값 세팅
//   // 텍스트는 visibility : hidden으로

//   click.disabled = false;
//   finish.style.visibility = "hidden";
//   click.value = `Click`;
// });

// 문제 풀이 : 코드 참고할 것.
// 클릭 이벤트 내 별도 핸들러 함수 지정하여 e 자리에 삽입;

const span = document.querySelector("span");
// html 버튼 태그 내 스판 값 삽입하여 카운트 요소 추가
let count = 0;
// 1부터 3까지의 랜덤값 지정 필요
const game = () => {
  const random = [
    Math.floor(Math.random() * 3) + 1,
    Math.floor(Math.random() * 3) + 1,
    Math.floor(Math.random() * 3) + 1,
  ];
  for (let i = 0; i < img.length; i++) {
    img[i].setAttribute("src", `./assets/spy${random[i]}.jpg`);
  }
  // 클릭할 때마다 카운트 증가
  span.innerHTML = ++count;
  // 이미지 3개 일치 시 버튼 disabled 처리(비활성화)
  if (random[0] == random[1] && random[1] == random[2]) {
    click.disabled = true;
    // p에 visibility: visible로 변경
    finish.style.visibility = "visible";
  }
};

const reset = () => {
  // 이미지는 처음 그대로 1,2,3 순으로 보이게 변환
  for (let i = 0; i < img.length; i++) {
    img[i].setAttribute("src", `./assets/spy${i + 1}.jpg`);
  }
  // count는 0으로 (span은 비우고)
  count = 0;
  span.innerHTML = "";
  // 버튼 disabled > 활성화
  click.disabled = false;
  // p에 visibility: hidden으로 변경
  finish.style.visibility = "hidden";
};

click.addEventListener("click", game);
restart.addEventListener("click", reset);
// restart.addEventListener("click", () => {location.reload();});

/* 위 리셋 이벤트와 유사한 개념으로
실제 페이지를 리셋하는 location.reload() 함수가 존재한다. (클릭 시 점멸)
react나 vue와 같은 프레임워크에서 작성된 코드는
one page 방식이라 별도 새로고침 없이 화면전환할 수 있으나,
location.reload() 방식은 새로고침과 동일하게 해당 리소스를 다시 불러오게 되어
데이터 손실 등의 불편함이 발생할 수 있다. (ex: 정부/공공기관 페이지) */
