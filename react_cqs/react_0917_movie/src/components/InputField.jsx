import React from "react";

// 자주 쓰는 메서드와 클래스 활용하기 위해 컴포넌트 생성

const InputField = ({ value, placeholder, onChange, errorMessage }) => {
  return (
    <div>
      <input placeholder={placeholder} value={value} onChange={onChange} />
      <div style={{ color: "red" }}>{errorMessage}</div>
    </div>
  );
};

export default InputField;
