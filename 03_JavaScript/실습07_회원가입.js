const inputId = document.querySelector("#inputId");
const result1 = document.querySelector("#result1");
const inputPw = document.querySelector("#inputPw");
const result2 = document.querySelector("#result2");
const rewritePw = document.querySelector("#rewritePw");
const result3 = document.querySelector("#result3");
const inputName = document.querySelector("#inputName");
const result4 = document.querySelector("#result4");
const inputMail = document.querySelector("#inputMail");
const result5 = document.querySelector("#result5");
const inputTel = document.querySelector("#inputTel");
const result6 = document.querySelector("#result6");

let regExp1 = /^[a-zA-Z][a-zA-Z0-9]{3,11}$/;
let regExp2 =
  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;
let regExp4 = /^[가-힣]{2,}$/;
let regExp5 = /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/;
let regExp6 = /^010-\d{4}-\d{4}$/;

let check1 = false;
let check2 = false;
let check3 = false;
let check4 = false;
let check5 = false;
let check6 = false;

inputId.addEventListener("input", (e1) => {
  //   let regExp1 = /^[a-zA-Z][a-zA-Z0-9]{3,11}$/;
  if (regExp1.test(e1.target.value)) {
    // console.log("ok");
    result1.innerHTML = "OK!";
    result1.style.fontWeight = "normal";
    result1.style.color = "green";
    check1 = true;
  } else {
    // console.log("no");
    result1.innerHTML = "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내";
    result1.style.fontWeight = "bold";
    result1.style.color = "red";
    check1 = false;
  }

  if (check1 && check2 && check3 && check4 && check5 && check6) {
    register.disabled = false;
    register.style.background = "darkcyan";
  } else {
    register.disabled = true;
    register.style.background = "lightgrey";
  }
});

inputPw.addEventListener("input", (e2) => {
  //   let regExp2 =
  //     /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;
  if (regExp2.test(e2.target.value)) {
    result2.innerHTML = "OK!";
    result2.style.color = "green";
    result2.style.fontWeight = "normal";
    check2 = true;
  } else {
    result2.innerHTML = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
    result2.style.fontWeight = "bold";
    result2.style.color = "red";
    check2 = false;
  }
  if (check1 && check2 && check3 && check4 && check5 && check6) {
    register.disabled = false;
    register.style.background = "darkcyan";
  } else {
    register.disabled = true;
    register.style.background = "lightgrey";
  }
});

rewritePw.addEventListener("input", (e3) => {
  // 위와 동일한 값을 나타내도록 세팅
  if (e3.target.value !== "" && e3.target.value == inputPw.value) {
    result3.innerHTML = "OK!";
    result3.style.fontWeight = "normal";
    result3.style.color = "green";
    check3 = true;
  } else {
    result3.innerHTML = "위 비밀번호와 동일하게";
    result3.style.fontWeight = "bold";
    result3.style.color = "red";
    check3 = false;
  }
  if (check1 && check2 && check3 && check4 && check5 && check6) {
    register.disabled = false;
    register.style.background = "darkcyan";
  } else {
    register.disabled = true;
    register.style.background = "lightgrey";
  }
});

inputName.addEventListener("input", (e4) => {
  //   let regExp4 = /^[가-힣]{2,}$/;
  if (regExp4.test(e4.target.value)) {
    result4.innerHTML = "OK!";
    result4.style.fontWeight = "normal";
    result4.style.color = "green";
    check4 = true;
  } else {
    result4.innerHTML = "한글 2자 이상";
    result4.style.fontWeight = "bold";
    result4.style.color = "red";
    check4 = false;
  }
  if (check1 && check2 && check3 && check4 && check5 && check6) {
    register.disabled = false;
    register.style.background = "darkcyan";
  } else {
    register.disabled = true;
    register.style.background = "lightgrey";
  }
});

inputMail.addEventListener("input", (e5) => {
  //   let regExp5 = /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/;
  if (regExp5.test(e5.target.value)) {
    result5.innerHTML = "OK!";
    result5.style.fontWeight = "normal";
    result5.style.color = "green";
    check5 = true;
  } else {
    result5.innerHTML = "이메일 형식";
    result5.style.fontWeight = "bold";
    result5.style.color = "red";
    check5 = false;
  }
  if (check1 && check2 && check3 && check4 && check5 && check6) {
    register.disabled = false;
    register.style.background = "darkcyan";
  } else {
    register.disabled = true;
    register.style.background = "lightgrey";
  }
});

inputTel.addEventListener("input", (e6) => {
  //   let regExp6 = /^010-\d{4}-\d{4}$/;
  if (regExp6.test(e6.target.value)) {
    result6.innerHTML = "OK!";
    result6.style.fontWeight = "normal";
    result6.style.color = "green";
    check6 = true;
  } else {
    result6.innerHTML = "전화번호 형식";
    result6.style.fontWeight = "bold";
    result6.style.color = "red";
    check6 = false;
  }
  if (check1 && check2 && check3 && check4 && check5 && check6) {
    register.disabled = false;
    register.style.background = "darkcyan";
  } else {
    register.disabled = true;
    register.style.background = "lightgrey";
  }
});

// const c1 = result1.style.color;
// const c2 = result2.style.color;
// const c3 = result3.style.color;
// const c4 = result4.style.color;
// const c5 = result5.style.color;
// const c6 = result6.style.color;

// if (
//   c1 == "green" &&
//   c2 == "green" &&
//   c3 == "green" &&
//   c4 == "green" &&
//   c5 == "green" &&
//   c6 == "green"
// ) {
//   register.disabled = false;
//   register.style.background = "darkcyan";
// } else if (
//   c1 == "red" ||
//   c2 == "red" ||
//   c3 == "red" ||
//   c4 == "red" ||
//   c5 == "red" ||
//   c6 == "red"
// ) {
//   register.disabled = true;
//   register.style.background = "lightgrey";
// }

register.addEventListener("click", () => {
  register.onclick = alert("정상 처리되었습니다.");
});

cancel.addEventListener("click", (e) => {
  location.reload();
});
