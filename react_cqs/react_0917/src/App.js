import logo from "./logo.svg";
import { useState } from "react";

function App() {
  // useState 활용하여 배열을 추가하는 예제
  let [fruit, setFruit] = useState([]); // 안에 대괄호를 넣으면 배열로 초기값 설정됨
  let [inputVal, setInputVal] = useState("");

  function addFruit() {
    // if(inputVal.trim().length > 0) 라고 명시하지 않아도 아래와 같이 값이 있다고 인식
    if (inputVal.trim()) {
      setFruit([...fruit, inputVal]); // 기존 배열값을 복사 후 입력값을 추가함
      // inputVal 자리에 여러 개의 데이터를 json 형태로 보낼 수 있음
      // setFruit([...fruit, {name, age}]);
      setInputVal("");
    }
  }

  return (
    <div className="App">
      <input
        type="text"
        value={inputVal}
        onChange={(e) => {
          setInputVal(e.target.value);
        }}
        placeholder="좋아하는 과일은?"
      />

      <input type="button" value="확인" onClick={addFruit} />
      {/* java에서 사용하는 Map과는 다름 
          forEach와 같은 역할로 볼 수 있음 */}
      <ul>
        {fruit.map((f) => (
          <li>{f}</li>
          // map에서 값을 들고 올때는, 변수 이름이 아니라 배열의 요소 이름을 가져와야 한다
          // fruitName (X) f.name (O)
        ))}
      </ul>
    </div>
  );
}

export default App;
