// 코드 중복 : 함수로 기능으로
const show = (info) => {
  document.body.innerHTML = `
  <h1>${info}님 환영합니다!</h1>
  <button type="button" id="logout">로그아웃</button>
  `;
  const logout = document.querySelector("#logout");
  logout.addEventListener("click", () => {
    localStorage.removeItem("name");
    location.reload();
  });
};

const h1 = document.querySelector("h1");
const form = document.querySelector("#form");
const username = document.querySelector("#username");
const password = document.querySelector("#password");
const login = document.querySelector("#login");

const info = localStorage.getItem("name");
if (info) {
  show(info);
}
login.addEventListener("click", () => {
  // 아이디 입력하고 비밀번호 입력받은 값들 로그인 처리
  // 로그인 성공 > 이름값을 저장하여 표시될 수 있도록
  if (username.value === "" && password.value === "") {
    alert("이름과 비밀번호를 입력해주세요!");
    return;
  }
  localStorage.setItem("name", username.value);
  // ___님 환영합니다! + 로그아웃 버튼
  // 이름값이 스토리지에 남아있을 경우, 계속 로그인 상태로 표시됨.
  show(username.value);
});
