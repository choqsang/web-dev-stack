const userId = document.querySelector("#userId");
const password = document.querySelector("#password");
const passwordCheck = document.querySelector("#passwordCheck");
const username = document.querySelector("#username");
const email = document.querySelector("#email");
const phone = document.querySelector("#phone");
const status1 = document.querySelector("#status1");
const status2 = document.querySelector("#status2");
const status3 = document.querySelector("#status3");
const status4 = document.querySelector("#status4");
const status5 = document.querySelector("#status5");
const status6 = document.querySelector("#status6");

let regExp1 = /^[a-zA-Z][a-zA-Z0-9]{3,11}$/;
let regExp2 =
  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;
let regExp4 = /^[가-힣]{2,}$/;
let regExp5 = /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/;
let regExp6 = /^010-\d{4}-\d{4}$/;

userId.addEventListener("input",(e)=>{
    let status = status1;
    let regExp = regExp1;
    const result = regExp.test(e.target.value);
    // console.log(regExp.test(e.target.value))
    if (result) {
        status.innerHTML = "일치합니다.";
        status.style.color = "yellowgreen";
    } else if (e.target.value === "") {
        status.innerHTML = "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내";
        status.style.color = "black";
    }
    else {
        status.innerHTML = "다시 입력해주세요.";
        status.style.color = "red";
    }
});

let checkPwd1 = function(e) {
    let b = false;
    let status = status2;
    let regExp = regExp2;
    const result = regExp.test(password.value);
    if (result) {
        status.innerHTML = "일치합니다.";
        status.style.color = "yellowgreen";
        b = true;
    } else if (password.value === "") {
        status.innerHTML = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
        status.style.color = "black";
    }
    else {
        status.innerHTML = "다시 입력해주세요.";
        status.style.color = "red";
    }

    return b;
};

password.addEventListener("input", (e)=>{
    let b1 = checkPwd1();
    checkPwd2(b1);
});
    
let checkPwd2 = function(b1) {
    let status = status3;
    if (b1 && passwordCheck.value === password.value) {
        status.innerHTML = "일치합니다.";
        status.style.color = "yellowgreen";
    } else if (b1 && passwordCheck.value === "") {
        status.innerHTML = "위 비밀번호와 동일하게";
        status.style.color = "black";
    }
    else {
        status.innerHTML = "다시 입력해주세요.";
        status.style.color = "red";
    }
};

passwordCheck.addEventListener("input", (e)=>{
    let b1 = checkPwd1();
    checkPwd2(b1);
});

username.addEventListener("input",(e)=>{
    let status = status4;
    let regExp = regExp4;
    const result = regExp.test(e.target.value);
    // console.log(regExp.test(e.target.value))
    if (result) {
        status.innerHTML = "일치합니다.";
        status.style.color = "yellowgreen";
    } else if (e.target.value === "") {
        status.innerHTML = "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내";
        status.style.color = "black";
    }
    else {
        status.innerHTML = "다시 입력해주세요.";
        status.style.color = "red";
    }
});

email.addEventListener("input",(e)=>{
    let status = status5;
    let regExp = regExp5;
    const result = regExp.test(e.target.value);
    // console.log(regExp.test(e.target.value))
    if (result) {
        status.innerHTML = "일치합니다.";
        status.style.color = "yellowgreen";
    } else if (e.target.value === "") {
        status.innerHTML = "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내";
        status.style.color = "black";
    }
    else {
        status.innerHTML = "다시 입력해주세요.";
        status.style.color = "red";
    }
});

phone.addEventListener("input",(e)=>{
    let status = status6;
    let regExp = regExp6;
    const result = regExp.test(e.target.value);
    // console.log(regExp.test(e.target.value))
    if (result) {
        status.innerHTML = "일치합니다.";
        status.style.color = "yellowgreen";
    } else if (e.target.value === "") {
        status.innerHTML = "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내";
        status.style.color = "black";
    }
    else {
        status.innerHTML = "다시 입력해주세요.";
        status.style.color = "red";
    }
});