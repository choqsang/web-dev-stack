import logo from "./logo.svg";
import "./App.css";
import Article from "./Article";

function App() {
  let topic = [
    // json 구조로 값을 설정
    // String 형식을 받는 것과는 차이가 있음
    { id: 1, title: "html", body: "my html" },
    { id: 2, title: "css", body: "my css" },
    { id: 3, title: "java script", body: "your js" },
  ];

  return (
    <div className="App">
      <Header
        title="React"
        onChangeMode={(id) => {
          alert("id:" + id);
        }}
      ></Header>

      {/*function () {
            alert("i am header!!");
      }*/}

      <Nav
        topics={topic}
        onChangeMode={(id) => {
          alert("id:" + id);
        }}
      ></Nav>
      <Article title="Welcome" body="hello, web"></Article>
      <Article title="I am title" body="i am body"></Article>
      <Child name="John"></Child>
    </div>
  );
}

function Header(props) {
  // Header라는 함수를 만들어 Component (아래 영역) 호출
  // 'props'라는 parameter값 지정 --> 위 title 속성 받아옴
  // props.title을 통해 담겨 있는 정보 불러오기

  return (
    // return 영역 내에 페이지 내용을 입력
    <header>
      <h1>
        <a
          href="/"
          onClick={function (event) {
            event.preventDefault();
            // (a태그의) 기본 클릭동작을 방지 / 무시하고 이벤트 발생
            props.onChangeMode();
            // 위에 설정한 함수를 불러와서 실행
          }}
        >
          {props.title}
        </a>
      </h1>
    </header>
  );
}

function Nav(props) {
  // <a href="/read/1">{props.topics[0].title}</a>
  let lis = [];
  for (let i = 0; i < props.topics.length; i++) {
    let t = props.topics[i];
    // lis.push( <li><a href={"/read/" + t.id}> {t.title} / {t.body}</a></li>);

    lis.push(
      <li>
        <a
          id={t.id}
          href={"/read/" + t.id}
          onClick={function (event) {
            event.preventDefault();
            props.onChangeMode(event.target.id);
            // 클릭 이벤트를 발생시킨 a태그의 id (= this.id)
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

function Child(props) {
  return <h2> Hello, {props.name} </h2>;
}

export default App;
