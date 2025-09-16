import { useState } from "react";
import logo from "./logo.svg";
//import "./App.css";

function App() {
  let [count, setCount] = useState(0);
  let [number, setNumber] = useState("");
  let [check, setCheck] = useState(0);

  function down() {
    setCount(count - 1);
  }
  function reset() {
    setCount(0);
  }
  function up() {
    setCount(count + 1);
  }
  function double() {
    setCount(count * 2);
  }
  function changeNum(e) {
    setCount(Number(e.target.value));
  }
  function input(e) {
    setNumber(number + e.target.value);
  }

  return (
    // 온클릭 이벤트에 위에 만든 함수를 호출해도 상관 없음
    <div className="App">
      <input type="button" value="1" onClick={input} />
      <input type="button" value="2" onClick={input} />
      <input type="button" value="3" onClick={input} />
      <br />
      <input type="button" value="4" onClick={input} />
      <input type="button" value="5" onClick={input} />
      <input type="button" value="6" onClick={input} />
      <br />
      <input type="button" value="7" onClick={input} />
      <input type="button" value="8" onClick={input} />
      <input type="button" value="9" onClick={input} />
      <br />

      <button>*</button>
      <button>0</button>
      <button>#</button>
      <br />
      <br />

      <button
        onClick={() => {
          setNumber("");
        }}
      >
        reset
      </button>

      <button
        onClick={() => {
          setCount(count - number);
        }}
      >
        -
      </button>
      <button
        onClick={() => {
          setCount(count + Number(number));
        }}
      >
        +
      </button>
      <button
        onClick={() => {
          setCount(count * 2);
        }}
      >
        x
      </button>
      <button
        onClick={() => {
          setCount(count * 2);
        }}
      >
        ÷
      </button>
      <br />
      <button
        onClick={() => {
          if (count == 0) {
            setCheck(0);
          } else if (count % 2 == 0) {
            setCheck("짝수");
          } else {
            setCheck("홀수");
          }
        }}
      >
        짝수/홀수 확인
      </button>
      <br />
      <input
        type="text"
        value={number}
        onChange={(e) => {
          console.log(e.target.value);
          if (e.target.value != "") {
            setNumber(e.target.value);
          } else {
            setNumber(1);
          }
        }}
      />
      <p>계산기 : {count}</p>
      <p>현재 결과는 {check}입니다.</p>
    </div>
  );
}

export default App;
