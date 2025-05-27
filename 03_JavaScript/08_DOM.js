// *태그로 가져오기 : 같은 태그로 여러 개일 수 있으므로 배열로 반환
function btn1() {
  console.log(document.body);
  const h1 = document.getElementsByTagName("h1");
  console.log(h1);
  // 해당하는 html파일의 경로와 내용 확인 가능.
  const divs = document.getElementsByTagName("div");
  // 모든 div 태그들 가져오기
  // html내 편집이 어렵기 때문에 js파일로 불러와서 작업
  // .getElementsBy...(태그,아이디 등)
  console.log(divs);
  console.log(divs[0]); // 첫번째 div 소환
}
// *id로 가져오기 : 고유한 id로 하나의 태그 선택
function btn2() {
  const testId = document.getElementById("testId");
  // 함수명을 보면 유일하게 Element가 단수이다. (나머지는 Elements)
  console.log(testId);
  const testId2 = document.getElementById("testId2");
  console.log(testId2);
}
// *class로 가져오기 : 같은 클래스명이 여러 개일 수 있으므로 배열로 반환
function btn3() {
  const div = document.getElementsByClassName("testClass");
  console.log(div); // 클래스도 기본값이 배열
  console.log(div[1]); // 두번째 div
}
// *name으로 가져오기 : 같은 name 속성이 여러 개일 수 있으므로 배열로 반환
function btn4() {
  const div = document.getElementsByName("testName");
  console.log(div); // Nodelist:배열
}
// CSS 선택자 문법 사용 가능
function btn5() {
  // 한 개만 가지고 오고 싶다면 querySelector
  const div = document.querySelector("#testId");
  console.log(div);
  // 여러 개를 가지고 오고 싶다면 querySelectorAll
  const divs = document.querySelectorAll("div");
  console.log(divs);
}
function btn6() {
  const divs = document.querySelectorAll(".testClass");
  divs[0].textContent = "<span>안녕하세요</span>"; // 태그를 문자로 출력
  divs[1].innerHTML = "<span>안녕하세요</span>"; // 태그를 HTML로 출력
  console.log(divs[1].textContent);
  console.log(divs[1].innerHTML);
}
function btn7() {
  const div = document.querySelector("#testId");
  // 속성 추가 & 수정 (setAtt)
  div.setAttribute("data-test", "테스트"); // (속성명, 속성값)
  // 속성 값 가져오기 (getAtt)
  console.log(div.getAttribute("data-test"));
  console.log(div.getAttribute("class"));
  // 속성 삭제 (removeAtt)
  div.removeAttribute("id");
}
function btn8() {
  const div = document.querySelector("#testId");
  // .style 입력 시 자동완성 주의! (ctrl+z)
  div.style.color = "orange";
  // = #testId {color: orange;}
  div.style.backgroundColor = "yellow";
  // 명령어가 불편해서 자주 이용하지 않음.
}
// classList 조작 : add, remove, contains, toggle
const div2 = document.querySelector("#testId2"); // 전역에서 선택
function btn9() {
  div2.classList.add("black"); // black 클래스 추가
}
function btn10() {
  div2.classList.remove("black"); // 클래스 내 black 삭제
} // 소개되는 기능들은 다크 모드 적용/해제 시 사용된다.

function btn11() {
  const has = div2.classList.contains("black"); // black 클래스가 있는 지 확인
  console.log("black 클래스 있는 지 : ", has); // true-false 답변
  // black 클래스가 있다면 제거, 없다면 추가
  if (has == true) btn10();
  // if조건문 괄호 안이 true일 경우이기 때문에,
  // true와 같다라는 조건은 명시하지 않아도 괜찮다. = if(has)
  else btn9();
}
function btn12() {
  div2.classList.toggle("black");
  // 클래스 포함 여부에 따라 추가/삭제 반복
}
function btn13() {
  const div = document.querySelector("#testId3");
  const p = document.createElement("p"); // <p> 태그 생성
  p.textContent = "텍스트 추가"; // p 태그 안에 텍스트 내용 추가
  div.appendChild(p); // div에 p 추가
}
function btn14() {
  const testId3 = document.querySelector("#testId3");
  const p = document.querySelector("#testId3 p");
  // testId3.removeChild(p); // 부모를 통해 삭제
  // console.log(p); // 문제가 확인되면 어느 곳이 문제인지 콘솔에서 확인
  if (p !== null) p.remove(); // 최신 브라우저 지원
  // if(p!==null) == if(p) : null이 아닌 경우는 p가 있는 경우
}
