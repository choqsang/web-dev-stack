// DOMContentLoaded 이벤트는 HTML 문서의 구조가 완전히 로드된 후 발생
// window(최상위개체).addEventListener("추가할 이벤트 이름", 함수(event)=>{}) :이벤트 핸들러

window.addEventListener("DOMContentLoaded", () => {
  const h1 = document.querySelector("h1");
  h1.style.color = "blue";

  // 클릭 이벤트
  const click = document.querySelector("#click");
  click.addEventListener("click", () => {
    // 클릭 이벤트가 일어나면 행하고자 하는 코드를 함수 내부에 작성
    alert("클릭 이벤트 발생");
    // click 색상을 변경
    click.style.background = "hotpink";
    click.style.color = "black";
  });

  const double = document.querySelector("#double");
  double.addEventListener("dblclick", () => {
    alert("더블 클릭 발생!");
  });

  const right = document.querySelector("#right");
  right.addEventListener("contextmenu", (event) => {
    // alert("우클릭 발생!");
    console.log(event);
    event.preventDefault(); // 우클릭 방지
  });

  const hover = document.querySelector("#hover"); // 마우스가 들어오고 나가는 2번 발생
  hover.addEventListener("mouseenter", () => {
    // console.log("mouseenter!");
    // 배경색상은 라이트블루, 텍스트는 Mouse Enter! 변경
    hover.style.background = "lightblue";
    hover.textContent = "Mouse Enter!";
  });
  hover.addEventListener("mouseleave", () => {
    // console.log("mouseleave!");
    // 배경색상은 네이비, 텍스트는 Mouse Leave! 변경
    hover.style.background = "navy";
    hover.textContent = "Mouse Leave!";
  });

  // 폼 이벤트
  // input 실시간 반영
  const input = document.querySelector("#input");
  const inputResult = document.querySelector("#inputResult");
  input.addEventListener("input", (e) => {
    // 입력과 동시에 실시간으로 피드백이 필요한 경우 (회원가입, 로그인 화면 등)
    // console.log(e.target.value);
    inputResult.textContent = e.target.value;
  });
  // select 선택값 출력
  const select = document.querySelector("#select");
  const selectResult = document.querySelector("#selectResult");
  select.addEventListener("change", (e) => {
    console.log(e.target.value);
    selectResult.textContent = e.target.value;
  });

  const form = document.querySelector("#form");
  const inputs = document.querySelector("#form input");
  form.addEventListener("submit", (e) => {
    // 값이 없는 경우만 전송 불가, 값이 있으면 전송!
    if (inputs.value === "") e.preventDefault();
  });

  // 키보드 이벤트 : keydown, keypress, keyup
  // 누르고 있는 동안(횟수증가), 누르고 나서 입력(텍스트 제외 출력X), 뗄 때 입력
  const keyboard = document.querySelector("#keyboard");
  const keyResult = document.querySelector("#keyResult");
  keyboard.addEventListener("keydown", (e) => {
    console.log(e.key); // 반응하는 키보드 자판 출력
    keyResult.textContent = e.key;
    if (e.key === "Enter") {
      alert("엔터!");
    }
  });

  // 박스 움직이기
  const move = document.querySelector(".moveBox");
  let x = 0,
    y = 0;
  document.addEventListener("keydown", (e) => {
    console.log(e.key);
    // 방향키 입력 값에 따라 지정된 개체의 위치값 변동 가능.
    // x, y 변수에 +=, -= 을 중첩
    if (e.key === "ArrowUp") {
      y -= 50;
    }
    if (e.key === "ArrowDown") {
      y += 50;
    }
    if (e.key === "ArrowLeft") {
      x -= 50;
    }
    if (e.key === "ArrowRight") {
      x += 50;
    }
    move.style.top = `${y}px`;
    move.style.left = `${x}px`;
  });

  // 스크롤 이벤트
  const wheel = document.querySelector("#wheel");
  const scroll = document.querySelector("#scroll");
  window.addEventListener("wheel", (e) => {
    // console.log(e.deltaY); // y축 이동값 표시

    // 휠을 올렸더니 마이너스,
    if (e.deltaY < 0) wheel.textContent = "휠 위로 스크롤 중!";
    // 휠을 내렸더니 플러스
    if (e.deltaY > 0) wheel.textContent = "휠 아래로 스크롤 중!";
  });
  window.addEventListener("scroll", () => {
    // 전체 높이
    console.log("scrollHeight", document.documentElement.scrollHeight);

    // 보여지는 화면의 높이 (console화면 등을 제외한 실제 화면단)
    console.log("innerHeight", window.innerHeight);

    // 페이지의 y축 높이 위치 표시
    console.log("scrollY", window.scrollY);

    // scrollHeight === innerHeight + scrollY
    // scrollHeight - innerHeight : 스크롤 총 내리는 높이
    const totalHeight =
      document.documentElement.scrollHeight - window.innerHeight;
    const percent = (window.scrollY / totalHeight) * 100;

    console.log(percent);
    scroll.style.width = `${percent}%`;
  });

  // *이벤트 위임
  // 이미지가 클릭될 때마다 해당 이미지 지우기
  // 1. 이미지마다 이벤트 걸기 위해 반복문 필요!
  const img = document.querySelectorAll(".container img");
  console.log(img);
  for (let i = 0; i < img.length; i++) {
    console.log(img[i]);
    img[i].addEventListener("click", (e) => {
      // img[i].style.display = "none";
      console.log(e.currentTarget);
      e.currentTarget.style.display = "none";
    });
  }

  // 2. 부모인 컨테이너에 이벤트 걸기
  const container = document.querySelector(".container");
  const removeHandler = (e) => {
    alert("!");
    console.log("target", e.target); // 내가 클릭한 이미지
    console.log("current", e.currentTarget); // 이벤트 걸린 본인
    // 컨테이너에게 이벤트가 걸려있기 때문에 1번과는 달리 전체가 선택됨.
    if (e.target !== e.currentTarget) {
      e.target.style.display = "none";
    }
  }; // 핸들러 함수만 별도로 빼서 작성하였음.
  container.addEventListener("click", removeHandler);
});
