const signup = document.querySelector("#signup");
let check1 = false; // userId
let check2 = false; // password
let check3 = false; // passwordCheck
let check4 = false; // userName
let check5 = false; // userEmail
let check6 = false; // userNumber

// 아래와 같은 방식으로 각 항목(6개)을 생성 가능하다.
// input tag 및 span tag 쿼리 불러오기 세팅
const userId = document.querySelector("#userId");
const userSpan = document.querySelector("#userId+span");
// 정규표현식 세팅
const userRegExp = /^[a-zA-Z][a-zA-Z0-9]{3,11}$/;
// 이벤트 세팅 (input-입력되는 값에 따라 달라진다.)
userId.addEventListener("input", (e) => {
  // 입력값이 정규표현식 true일 경우
  if (userRegExp.test(e.target.value)) {
    // 초록색 글씨로 ok라고 표시됨
    userSpan.innerHTML = "OK!";
    userSpan.style.color = "green";
    check1 = true;
    // 입력값이 없을 경우, 최초 양식으로 노출됨
  } else if (e.target.value === "") {
    userSpan.innerHTML = "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내";
    userSpan.style.color = "black";
    check1 = false;
    // 입력 값이 있으나, 정규표현식 false인 경우 붉은색으로 표시됨
  } else {
    userSpan.innerHTML = "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내";
    userSpan.style.color = "red";
    check1 = false;
  }
  //   if (check1 && check2 && check3 && check4 && check5 && check6) {
  //   signup.disabled = false; }
  //   아래도 같은 의미
  signup.disabled = !(check1 && check2 && check3 && check4 && check5 && check6);
});

// 3번째 항목인 비밀번호 체크에서는 기존 정규표현식과 무관하게
// 2항인 비밀번호 입력 항목에 맞춰서 조건을 수정해야한다.
const password = document.querySelector("#password");
const passwordSpan = document.querySelector("#password+span");
const passwordCheck = document.querySelector("#passwordCheck");
const passwordCheckSpan = document.querySelector("#passwordCheck+span");

const passwordRegExp =
  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;
password.addEventListener("input", (e) => {
  if (passwordRegExp.test(e.target.value)) {
    passwordSpan.innerHTML = "OK!";
    passwordSpan.style.color = "green";
    check2 = true;
  } else if (e.target.value === "") {
    passwordSpan.innerHTML = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
    passwordSpan.style.color = "black";
    check2 = false;
  } else {
    passwordSpan.innerHTML = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
    passwordSpan.style.color = "red";
    check2 = false;
  }
  // 2항과 3항은 서로 유기적으로 상호작용이 필요하기 때문에,
  // 각 항의 실시간 변동에 따른 서식을 개별적으로 추가할 필요가 있음.
  if (passwordRegExp.test(e.target.value) && passwordCheck.value !== "") {
    if (passwordCheck.value === e.target.value) {
      passwordCheckSpan.innerHTML = "OK!";
      passwordCheckSpan.style.color = "green";
      check3 = true;
    } else {
      passwordCheckSpan.innerHTML = "위 비밀번호와 동일하게";
      passwordCheckSpan.style.color = "red";
      check3 = false;
    }
  }
  signup.disabled = !(check1 && check2 && check3 && check4 && check5 && check6);
});

// 패스워드 항목에 대한 마스킹 처리와 해제 트리거
// html 인풋 항목 타입 password <-> text
// password.addEventListener("click", (e) => {
//   password.setAttribute("type", "text");
// });

passwordCheck.addEventListener("input", (e) => {
  if (
    passwordRegExp.test(password.value) &&
    password.value === e.target.value
  ) {
    passwordCheckSpan.innerHTML = "OK!";
    passwordCheckSpan.style.color = "green";
    check3 = true;
  } else if (e.target.value === "") {
    passwordCheckSpan.innerHTML = "위 비밀번호와 동일하게";
    passwordCheckSpan.style.color = "black";
    check3 = false;
  } else {
    passwordCheckSpan.innerHTML = "위 비밀번호와 동일하게";
    passwordCheckSpan.style.color = "red";
    check3 = false;
  }
  signup.disabled = !(check1 && check2 && check3 && check4 && check5 && check6);
});

const userName = document.querySelector("#userName");
const userNameSpan = document.querySelector("#userName+span");
const userNameRegExp = /^[가-힣]{2,}$/;
userName.addEventListener("input", (e) => {
  if (userNameRegExp.test(e.target.value)) {
    userNameSpan.innerHTML = "OK!";
    userNameSpan.style.color = "green";
    check4 = true;
  } else if (e.target.value === "") {
    userNameSpan.innerHTML = "한글 2자 이상";
    userNameSpan.style.color = "black";
    check4 = false;
  } else {
    userNameSpan.innerHTML = "한글 2자 이상";
    userNameSpan.style.color = "red";
    check4 = false;
  }
  signup.disabled = !(check1 && check2 && check3 && check4 && check5 && check6);
});

const userEmail = document.querySelector("#userEmail");
const userEmailSpan = document.querySelector("#userEmail+span");
const userEmailRegExp = /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/;
userEmail.addEventListener("input", (e) => {
  if (userEmailRegExp.test(e.target.value)) {
    userEmailSpan.innerHTML = "OK!";
    userEmailSpan.style.color = "green";
    check5 = true;
  } else if (e.target.value === "") {
    userEmailSpan.innerHTML = "이메일 형식";
    userEmailSpan.style.color = "black";
    check5 = false;
  } else {
    userEmailSpan.innerHTML = "이메일 형식";
    userEmailSpan.style.color = "red";
    check5 = false;
  }
  signup.disabled = !(check1 && check2 && check3 && check4 && check5 && check6);
});

const userNumber = document.querySelector("#userNumber");
const userNumberSpan = document.querySelector("#userNumber+span");
const userNumberRegExp = /^010-\d{4}-\d{4}$/;
userNumber.addEventListener("input", (e) => {
  if (userNumberRegExp.test(e.target.value)) {
    userNumberSpan.innerHTML = "OK!";
    userNumberSpan.style.color = "green";
    check6 = true;
  } else if (e.target.value === "") {
    userNumberSpan.innerHTML = "전화번호 형식 (010-0000-0000)";
    userNumberSpan.style.color = "black";
    check6 = false;
  } else {
    userNumberSpan.innerHTML = "전화번호 형식 (010-0000-0000)";
    userNumberSpan.style.color = "red";
    check6 = false;
  }
  signup.disabled = !(check1 && check2 && check3 && check4 && check5 && check6);
});

const cancel = document.querySelector("#cancel");
cancel.addEventListener("click", () => {
  userSpan.innerHTML = "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내";
  userSpan.style.color = "black";
  passwordSpan.innerHTML = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
  passwordSpan.style.color = "black";
  passwordCheckSpan.innerHTML = "위 비밀번호와 동일하게";
  passwordCheckSpan.style.color = "black";
  userNameSpan.innerHTML = "한글 2자 이상";
  userNameSpan.style.color = "black";
  userEmailSpan.innerHTML = "이메일 형식";
  userEmailSpan.style.color = "black";
  userNumberSpan.innerHTML = "전화번호 형식 (010-0000-0000)";
  userNumberSpan.style.color = "black";
});
