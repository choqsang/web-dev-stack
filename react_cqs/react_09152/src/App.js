import { useState } from "react";
import logo from "./logo.svg";

function App() {
  //let mode = "WELCOME";
  let [mode, setMode] = useState("WELCOME");
  // useState("초기값") import 필수적 (=setter 기능)
  // 상태 값을 담을 변수 생성해야 한다 (setMode)
  let [id, setId] = useState(null);
  let [nextId, setNextId] = useState(4); // 기존 1~3까지 id 생성되어 있어 4번부터 시작
  let content = null;

  let [m_topics, setTopics] = useState([
    { id: 1, title: "HTML", body: "my html" },
    { id: 2, title: "CSS", body: "your css" },
    { id: 3, title: "JavaScript", body: "our js" },
  ]); // 기존 list를 useState로 변경

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
  } else if (mode === "CREATE") {
    content = (
      <Create
        onCreate={
          // props로 onCreate라는 함수 전송
          // 호출된 메서드에 포함된 title, body를 받기 위해 함수 작성
          (title, body) => {
            // title과 body를 받아서 m_topics에 전송
            let newTopic = { id: nextId, title: title, body: body };
            // m_topics 배열을 newTopics에 통째로 복사
            let newTopics = [...m_topics]; // 3개

            newTopics.push(newTopic);
            setTopics(newTopics); // 변경된 list값의 갱신을 위해 재지정

            setMode("READ");
            setId(nextId);
            setNextId(nextId + 1); // id가 1씩 증가한다
          }
        }
      ></Create>
    );
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
          // alert("id : " + id);
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

      <a
        href="/create"
        onClick={(event) => {
          event.preventDefault();
          setMode("CREATE");
        }}
      >
        Create
      </a>

      <input
        type="button"
        value="Delete"
        onClick={() => {
          let newTopics = [];

          for (let i = 0; i < m_topics.length; i++) {
            // title에 입력한 제목에 해당하는 값 삭제 :
            // m_topics에 지정되어 있는 id와
            // 내가 지우고자 하는 요소의 id가 다른 경우에만 newTopics에 담는다
            if (m_topics[i].id != id) {
              newTopics.push(m_topics[i]);
            }
          }
          setTopics(newTopics);
        }}
      />
    </div>
  );
}

function Create(props) {
  return (
    <article>
      <h2>Create!!</h2>

      <form
        onSubmit={(event) => {
          event.preventDefault();
          let title = event.target.title.value; // form 태그 안에 title 이름을 가진 요소의 입력값
          let body = event.target.body.value;
          props.onCreate(title, body); // props를 생성하면 component 상위에 data를 집어 넣는 시점으로 이동
        }}
      >
        <input type="text" name="title" placeholder="input title" />
        <br />
        <textarea name="body" placeholder="내용을 입력해주세요"></textarea>
        <br />
        <input type="submit" value="new Create" />
      </form>
    </article>
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
          {t.id} / {t.title} / {t.body}
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
