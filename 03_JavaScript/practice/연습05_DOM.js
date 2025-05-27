// 1번 문제 : '안녕하세요'를 result1에 출력
const result1 = document.querySelector("#result1");
function printText() {
  result1.innerHTML = "안녕하세요.";
  //   p.textContent = id.appendChild(p);
}

// 2번 문제
const result2 = document.querySelector("#result2");
const customer = document.querySelector("#customer");
function printInputValue() {
  // input 값(customer)을 가지고 와서 result2에 출력
  // console.log(customer.value);
  result2.textContent = customer.value;
  // input 값을 비우고 싶으면
  customer.value = ""; // 버튼 다시 누르면 공란 노출
}

// 3번 문제
const divTest = document.querySelector(".div-test");
function changeColor() {
  // 선택한 divTest의 배경색을 변경
  divTest.style.background = "blue";
  // <태그>내 스타일 속성을 준 것과 동일
}

// 4번 문제
const text = document.querySelector("#text");
const result4 = document.querySelector("#result4");
function stringLength() {
  // 입력받은 text에서 글자의 글자 수 가지고 오기 + result4에 출력
  //   console.log(text.value);
  const tv = text.value;
  //   console.log(tv.split("").length);
  result4.textContent = tv.split("").length;
  // == text.value.length;
  text.value = "";
}

// 5번 문제
const la = document.querySelector("#la");
const result5 = document.querySelector("#result5");
const larr = la.textContent.split(",");
const ul = document.createElement("ul");

function stringSplit() {}
// "사과, 바나나, 오렌지, 포도" 문자 가지고 오기
// 가지고 온 문자열 분리하기 => 배열로 만들기
// 배열 값 하나씩 가지고 오기 => 반복문
// 반복문에서 태그를 만들어서 출력
//   console.log(la.textContent.split(","));

for (let i = 0; i < larr.length; i++) {
  // console.log(larr[i]);
  // li 태그 만들기
  const li = document.createElement("li");
  // li 태그에 값 넣기
  li.textContent = larr[i];
  // console.log(li);
  // ul 태그에 만들어놓은 li 태그들 추가하기
  //   ul.appendChild(li);
  //   ul.textContent = "<li>" + 1arr[i] + "</li>";
  //   ul. innerHTML += `<li>${1arr[i]}</li>`;
  // ul 태그 만들기

  // result에 ul 담기
  result5.appendChild(ul);
}

// 6번 문제
// 피자 치킨 떡볶이 <= 배열로 만들기
const preview = document.querySelector("#preview");
const remove = document.querySelector("#remove");
const add = document.querySelector("#add");

// console.log(preview.textContent.split(" "));
const preArr = preview.textContent.split(" ");

function arrayTest() {
  // 1. 일단 반복문
  for (let i = 0; i < preArr.length; i++) {
    // 이미 가지고 있는 값에서 내가 삭제할 값이 일치하면 배열에서 제거
    // console.log(preArr[i] === "피자");
    if (preArr[i] === remove.value) {
    } // 2. 배열에서 제거 : splice(index,1);
    const delIdx = preArr.indexOf(remove.value); // 삭제할 인덱스
    //   console.log(delIdx);
    if (delIdx !== -1) preArr.splice(delIdx, 1);

    // ++ 삭제(2)
    // console.log(preArr.includes(remove.value));
    // if (preArr.includes(remove.value)) preArr.splice(delIdx, 1);

    // 추가 => 배열에 해당 값 추가 push!
    preArr.push(add.value);

    // 배열 => 문자열로 바꾸기
    // console.log(preArr.join(" "));
    preview.textContent = preArr.join(" ");
  }
}
//   preview.textContent = preview + add.value;
//   const p1 = document.createElement("p");
//   const p2 = document.createElement("p");
//   p1.textContent = add.value;
//   p2.textContent = remove.value;
//   preview.appendChild(p1);
//   preview.removeChild(p1);
//   console.log(preview.textContent);

// 7번 문제 : prompt로 이름, 나이, 주소 순으로 입력받아서 출력 (총 3명)
const names = document.querySelectorAll(".name");
const ages = document.querySelectorAll(".age");
const addrs = document.querySelectorAll(".addr");
function addStudent() {
  //   let arr = ["", 0, ""];
  for (let i = 0; i < 3; i++) {
    // names[i].textContent = "이름" + i;
    const name = prompt(i + 1 + "번째 학생의 이름을 입력해주세요.");
    const age = prompt(i + 1 + "번째 학생의 나이를 입력해주세요.");
    const addr = prompt(i + 1 + "번째 학생의 주소를 입력해주세요.");

    names[i].textContent = name;
    ages[i].textContent = age;
    addrs[i].textContent = addr;
  }
}

// 8번
const list = document.querySelector("#list");

function addItem() {
  // 1. li태그를 만들어서 추가하는 방식
  const li = document.createElement("li");
  li.textContent = "test1";
  list.appendChild(li);

  // 2. innerHTML로 문자 추가하는 방식
  list.innerHTML += "<li>test2</li>";
}

function removeItem() {
  // 1. 부모에서 제거
  //   console.log(list.childNodes);
  list.removeChild(list.childNodes[0]); // childNodes[index]: 삭제 원하는 순번 기입

  // 2. 본인이 제거
  const li = document.querySelector("#list li");
  // qS all로 안하는 이유: 맨 처음 1개만 선택하기 위해
  li.remove();
}

// 9번
const result9 = document.querySelector("#result9");
function toggleClass() {
  result9.classList.toggle("active");
}

// 10번
const item = document.querySelector("#item");
const price = document.querySelector("#price");
const cart = document.querySelector("#cart");
const total = document.querySelector("#total span");
let sum = 0;
function addToCart() {
  cart.innerHTML += `<li>${item.value} - ${price.value}</li>`;

  console.log(isNaN(Number(price.value))); // NaN
  if (!isNaN(Number(price.value))) sum += Number(price.value);
  // 가격이 나오지 않는 부분에 대한 체크와 제한 두기
  total.innerHTML = sum;
  console.log(sum);

  item.value = "";
  price.value = "";
}
