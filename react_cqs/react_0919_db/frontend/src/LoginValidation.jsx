import react from "react";

export default function LoginValidation(props) {
  //   alert(props.email);

  if (props.email == "" && props.password == "" && props.name == "") {
    alert("회원 정보를 입력해주세요");
  } else if (props.name == "") {
    alert("이름을 입력하세요");
    return;
  } else if (props.email == "") {
    alert("이메일을 입력하세요");
    return;
  } else if (props.password == "") {
    alert("비밀번호를 입력하세요");
    return;
  }
}
