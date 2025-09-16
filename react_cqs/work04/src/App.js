import logo from "./logo.svg";
import { useState } from "react";

function App() {
  let [greet, setGreet] = useState("");
  let [feel, setFeel] = useState("");
  let [emotion, setEmotion] = useState("");

  function nameChange(e) {
    e.preventDefault();
    let name = e.target.myname.value;
    setGreet("안녕하세요 " + name + "님! 오늘의 기분은 어떠신가요?");
  }

  function moodChange(e) {
    const mood = e.target.value;
    setFeel(mood);
    // console.log(e.target.value);
    // console.log(feel);
    if (mood == "행복") {
      setEmotion("😊");
    } else if (mood == "슬픔") {
      setEmotion("😭");
    } else if (mood == "화남") {
      setEmotion("😡");
    }
  }

  return (
    <div className="App">
      {/* 이름을 입력하는 form */}
      <form onSubmit={nameChange}>
        <input
          type="text"
          name="myname"
          placeholder="이름을 입력하세요"
        ></input>
        <input type="submit" value="인사하기"></input>
      </form>
      <h3>{greet}</h3>
      <MyMood moodChange={moodChange} emotion={emotion}></MyMood>
    </div>
  );
}

function MyMood(props) {
  return (
    /* 기분을 선택하는 select 태그 */
    <div>
      <select onChange={props.moodChange}>
        <option value="">기분을 선택하세요</option>
        <option value="행복">행복</option>
        <option value="슬픔">슬픔</option>
        <option value="화남">화남</option>
      </select>
      <h3>{props.emotion}</h3>
    </div>
  );
}
export default App;
