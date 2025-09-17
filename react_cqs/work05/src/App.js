import { useState } from "react";
import logo from "./logo.svg";

function App() {
  let [user, setUser] = useState([]);
  let [name, setName] = useState("");
  let [age, setAge] = useState("");

  function addUser() {
    if (name.trim() && age.trim()) {
      setUser([...user, { name, age }]);
      setName("");
      setAge("");
      console.log(user);
    }
  }

  function delUser(index) {
    // filter는(내장 메서드) 배열을 순회하면서 조건에 맞는 요소만 골라서 새로운 배열을 만드는 함수
    // filter 함수는 최대 두 개의 인자를 가지는데,
    // 첫 번째 인자 res는 배열의 i번째 요소 (사용하지 않는다면 _로 지정)
    // 두 번째 인자 i는 배열의 인덱스값(을 자동 추적하여 순회한다)

    let newUser = user.filter((res, i) => i !== index); // result, index 요소
    setUser(newUser);
  }

  return (
    <div className="App">
      <h2>유저 리스트</h2>
      <input
        type="text"
        placeholder="이름을 입력하세요."
        value={name}
        onChange={(e) => {
          setName(e.target.value);
        }}
      />
      <br />
      <input
        type="text"
        placeholder="나이를 입력하세요."
        value={age}
        onChange={(e) => {
          setAge(e.target.value);
        }}
      />
      <input type="button" value="확인" onClick={addUser} />
      {/* <input type="button" value="삭제" onClick={delUser} /> */}
      <hr />
      <table border="1">
        <thead>
          <tr>
            <th>이름</th>
            <th>나이</th>
            <th>비고</th>
          </tr>
        </thead>
        <tbody>
          {user.map((u, index) => (
            <tr>
              <td>{u.name}</td>
              <td>{u.age}</td>
              <td>
                {/* <input
                  type="checkbox"
                  value={index}
                  onClick={(e) => {
                    console.log(e.target.value);
                  }}
                ></input> */}
                <input
                  type="button"
                  value="삭제"
                  onClick={delUser(index)}
                ></input>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;
