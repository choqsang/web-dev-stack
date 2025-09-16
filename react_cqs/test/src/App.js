import { useState } from "react";
import logo from "./logo.svg";

function App() {
  let [selMenu, setSelMenu] = useState("");

  let menuChange = (event) => {
    if (event.target.value != "") {
      setSelMenu(event.target.value + "을 선택");
    } else {
      setSelMenu("메뉴를 선택하세요.");
    }
  };

  return (
    <div className="App">
      <h2>메뉴 선택</h2>
      <select onChange={menuChange}>
        <option value="">메뉴</option>
        <option value="짜장">짜장</option>
        <option value="짬뽕">짬뽕</option>
      </select>

      <p style={{ color: "blue" }}>{selMenu}</p>
    </div>
  );
}
export default App;
