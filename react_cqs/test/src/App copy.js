import { useState } from "react";
import logo from "./logo.svg";

function App() {
  let [option, setOption] = useState(0);
  let menu = [
    { id: 0, title: "메뉴" },
    { id: 1, title: "짜장" },
    { id: 2, title: "짬뽕" },
  ];

  let content = null;
  if (option === 0) {
    content = "내용 없음";
  } else if (option !== 0) {
    content = "을 선택함";
  }

  return (
    <div className="App">
      <Header></Header>
      <Menu
        menus={menu}
        onChangeMode={(e) => {
          //console.log(e);
          setOption(e);
        }}
      ></Menu>
      <Article></Article>
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
      //console.log(e.target.value);
      props.onChangeMode(Number(e.target.value));
    };

    let list = [];
    for (let i = 0; i < props.menus.length; i++) {
      let m = props.menus[i];
      list.push(<option value={m.id}>{m.title}</option>);
    }
    return <select onChange={optionSelect}>{list}</select>;
  }

  function Article(props) {
    return <p>{content}</p>;
  }
}
export default App;
