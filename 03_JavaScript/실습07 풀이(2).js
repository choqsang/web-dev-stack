const signup = document.querySelector("#signup");
// 동일 유사한 양식을 꾸러미 형태로 묶어 코드를 간소화
// 개별 변수의 값을 기입하여 배열을 생성한다. - for문 활용
const fields = [
  {
    id: "userId",
    exp: /^[a-zA-Z][a-zA-Z0-9]{3,11}$/,
    message: "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내",
  },
  {
    id: "password",
    exp: /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/,
    message: "영문자, 숫자, 특수문자 조합으로 8~15자 이내",
  },
  {
    id: "passwordCheck",
    message: "위 비밀번호와 동일하게",
  },
  {
    id: "userName",
    exp: /^[가-힣]{2,}$/,
    message: "한글 2자 이상",
  },
  {
    id: "userEmail",
    exp: /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/,
    message: "이메일 형식",
  },
  {
    id: "userNumber",
    exp: /^010-\d{4}-\d{4}$/,
    message: "전화번호 형식 (010-0000-0000)",
  },
];

const validCheck = () => {
  let check = true; // 모든 필드가 유효하다고 가정
  const passwordCheckSpan = document.querySelector("#passwordCheck+span");
  fields.forEach(({ id }) => {
    const input = document.querySelector(`#${id}`);
    if (input.value === "") {
      check = false;
    } else if (id !== "passwordCheck" && !fields.exp?.test(input.value)) {
      check = false;
    }
    // password : passwordCheck.value !== e.target.value
    if (id === "password" && passwordCheck.value !== input.value) {
      check = false;
    }
  });

  return check;
};

fields.forEach(({ id, exp, message }) => {
  const input = document.querySelector(`#${id}`);
  const span = document.querySelector(`#${id}+span`);
  const regExp = exp;
  const password = document.querySelector("#password");
  const passwordRegExp = fields[1].exp;
  input.addEventListener("input", (e) => {
    if (
      (id === "passwordCheck" &&
        passwordRegExp.test(password.value) &&
        password.value === e.target.value) ||
      (exp !== undefined && regExp?.test(e.target.value))
      // ? 기호를 사용할 경우, null이 아니면 조건이 돌아가게끔 한다.
      // 해당 내용에 대한 추가 탐색 필요
    ) {
      span.innerHTML = "OK!";
      span.style.color = "green";
    } else if (e.target.value === "") {
      span.innerHTML = message;
      span.style.color = "black";
    } else {
      span.innerHTML = message;
      span.style.color = "red";
    }

    // password
    const passwordCheck = document.querySelector("#passwordCheck");
    const passwordCheckSpan = document.querySelector("#passwordCheck+span");
    if (id === "password") {
      if (passwordCheck.value === e.target.value) {
        passwordCheckSpan.innerHTML = "OK";
        passwordCheckSpan.style.color = "green";
      } else {
        passwordCheckSpan.innerHTML = "위 비밀번호와 동일하게";
        passwordCheckSpan.style.color = "red";
      }
    }
    // every : 배열 안에 특정 조건이 모두 만족할 경우 true
  });
});

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
  } else if (e.target.value === "") {
    passwordSpan.innerHTML = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
    passwordSpan.style.color = "black";
  } else {
    passwordSpan.innerHTML = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
    passwordSpan.style.color = "red";
  }

  if (passwordCheck.value === e.target.value) {
    passwordCheckSpan.innerHTML = "OK";
    passwordCheckSpan.style.color = "green";
  } else {
    passwordCheckSpan.innerHTML = "위 비밀번호와 동일하게";
    passwordCheckSpan.style.color = "red";
  }
  signup.disabled = !validCheck();
});

const cancel = document.querySelector("#cancel");
cancel.addEventListener("click", () => {
  fields.forEach(({ id, message }) => {
    const span = document.querySelector(`#${id}+span`);
    span.innerHTML = message;
    span.style.color = "black";
  });
});
