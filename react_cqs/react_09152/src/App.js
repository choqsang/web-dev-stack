import { useState } from "react";
import logo from "./logo.svg";

function App() {
  //let mode = "WELCOME";
  let [mode, setMode] = useState("WELCOME");
  // useState("초기값") import 필수적 (=setter 기능)
  // 상태 값을 담을 변수 생성해야 한다 (setMode)
  let [id, setId] = useState(null);
  let content = null;

  let m_topics = [
    { id: 1, title: "HTML", body: "my html" },
    { id: 2, title: "CSS", body: "your css" },
    { id: 3, title: "JavaScript", body: "our js" },
  ];

  if (mode === "WELCOME") {
    content = <Article title="welcome mode state" body="STATE WEB"></Article>;
  } else if (mode === "READ") {
    let title = null;
    let body = null;

    for (let i = 0; i < m_topics.length; i++) {
      if (m_topics[i].id == id) {
        title = m_topics[i].title;
        body = m_topics[i].body;
      }
    }
    content = <Article title={title} body={body}></Article>;
  }

  return (
    <div className="App">
      <Header
        title="React!!!"
        onChangeMode={() => {
          // mode = "WELCOME";
          setMode("WELCOME");
        }}
      ></Header>
      <Nav
        topics={m_topics}
        onChangeMode={(id) => {
          alert("id : " + id);
          // mode = "READ";
          // 리액트에서는 해당 부분에 대한 적용이 새로고침 이후 표현되나,
          // 새로고침 시 변동된 모드가 다시 초기화되기 때문에 작동하지 않는 것처럼 보인다
          setMode("READ");
          setId(id);
          console.log(id);
        }}
      ></Nav>
      <Article title="Welcome" body="Hello react web"></Article>
      {content}
    </div>
  );
}

function Header(props) {
  return (
    <header>
      <h1>
        <a
          href="/"
          onClick={() => {
            alert(props.title);
          }}
        >
          {props.title}
        </a>
      </h1>
      <h1>
        <a
          href="/"
          onClick={(event) => {
            event.preventDefault();
            props.onChangeMode();
          }}
        >
          {props.title}
        </a>
      </h1>
    </header>
  );
}

function Nav(props) {
  let lis = [];
  for (let i = 0; i < props.topics.length; i++) {
    let t = props.topics[i];
    lis.push(
      <li>
        <a
          id={t.id}
          href={"/read/" + t.id}
          onClick={(e) => {
            e.preventDefault();
            //alert("id : " + t.id);
            //console.log(e.target);
            props.onChangeMode(e.target.id); // 문자열로 받아질 경우, Number()로 묶어야 한다
          }}
        >
          {t.title} / {t.body}
        </a>
      </li>
    );
  }
  return (
    <nav>
      <ul>{lis}</ul>
    </nav>
  );
}

function Article(props) {
  return (
    <article>
      <h2>{props.title}</h2>
      <p>{props.body}</p>
    </article>
  );
}

export default App;
