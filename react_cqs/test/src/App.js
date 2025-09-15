import { useState } from "react";
import logo from "./logo.svg";

function App() {
  let [option, setOption] = useState();
  let menu = [
    { id: 1, title: "메뉴", content: "내용 없음" },
    { id: 2, title: "짜장", content: "짜장을 선택함" },
    { id: 3, title: "짬뽕", content: "짬뽕을 선택함" },
  ];

  let content = "내용 없음";
  if (option === "1") {
    content = "내용 없음";
  } else if (option === "2") {
    content = "짜장을 선택함";
  } else if (option === "3") {
    content = "짬뽕을 선택함";
  }

  let title = null;
  let body = null;

  return (
    <div className="App">
      <Header></Header>
      <Menu
        menus={menu}
        onChangeMode={(e) => {
          console.log(e);
          setOption(e);
        }}
      ></Menu>
      <Article content={menu.content}></Article>
    </div>
  );

  function Header() {
    return (
      <header>
        <h1>메뉴 선택</h1>
      </header>
    );
  }

  function Menu(props) {
    let optionSelect = (e) => {
      console.log(e.target.value);
      props.onChangeMode(e.target.value);
    };

    return (
      <select onChange={optionSelect}>
        {props.menus.map((item) => (
          <option value={item.id}>{item.title}</option>
        ))}
      </select>
    );
  }

  function Article(props) {
    return <p>{props.content}</p>;
  }
}
export default App;
