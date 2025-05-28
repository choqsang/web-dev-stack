// 칸마다 3가지 이미지가 랜덤으로 돌아가며, 클릭할 때마다 체크
// 3칸 모두 동일한 이미지일 경우 게임이 멈추며 종료 (하단 메시지 출력)
// 클릭 시도 횟수 반영, 리스타트 시 게임 재시작

const click = document.querySelector("#click");
const restart = document.querySelector("#restart");
const image = document.querySelector(".image");
const spys = document.querySelectorAll(".image img");
const count = document.querySelector("#clickcount");
const finish = document.querySelector("#finish");

const spy1 = document.querySelector("#spy1");
const spy2 = document.querySelector("#spy2");
const spy3 = document.querySelector("#spy3");
let i = 0;

click.addEventListener("click", (e) => {
  //   console.log(spys[i]);
  const random1 = Math.floor(Math.random() * 3) + 1;
  const random2 = Math.floor(Math.random() * 3) + 1;
  const random3 = Math.floor(Math.random() * 3) + 1;

  spy1.style.backgroundImage = `url("./assets/spy${random1}.jpg")`;
  spy2.style.backgroundImage = `url("./assets/spy${random2}.jpg")`;
  spy3.style.backgroundImage = `url("./assets/spy${random3}.jpg")`;

  i += 1;
  count.textContent = `${i}`;

  if (random1 == random2 && random2 == random3) {
    finish.textContent =
      "축하합니다! 다시 시작하려면 재시작 버튼을 눌러주세요!";
    click.addEventListener("onclick", () => {
      e.preventDefault;
    });

    // 이벤트 종료는 버튼 비활성화로 / disabled
  }
});

click.addEventListener("click", (e) => {
  // 리스타트를 눌렀을 때, 초기화면으로 돌아갈 수 있도록 기본값 세팅
  // 텍스트는 visibility : hidden으로
});
