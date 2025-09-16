import { useState } from "react";
import logo from "./logo.svg";

function App() {
  let [selColor, setSelColor] = useState("black");
  let [mfont, setFont] = useState("");

  let changeColor = (e) => {
    //console.log(e.target.value);
    setSelColor(e.target.value);
    if (e.target.value == "") {
      setSelColor("black");
      setFont("transparent");
    } else if (e.target.value == "yellow") {
      setFont("black");
    } else {
      setFont("white");
    }
  };

  return (
    <div className="App">
      <span>색상 선택</span>
      <select onChange={changeColor}>
        <option value="">:: 색상선택 ::</option>
        <option value="red">빨강</option>
        <option value="blue">파랑</option>
        <option value="green">초록</option>
        <option value="yellow">노랑</option>
      </select>
      <Box back={selColor} font={mfont}></Box>
    </div>
  );
}

function Box(props) {
  return (
    <div
      className="colorBox"
      style={{
        width: 200,
        height: 200,
        backgroundColor: props.back,
        marginTop: "20px",
        textAlign: "center",
        alignContent: "center",
        color: props.font,
      }}
    >
      {props.back}
    </div>
  );
}

export default App;
