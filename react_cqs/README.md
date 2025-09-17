## 리액트 수업 1일차 : 2025/09/15/Mon

- Stack / heap
  new arr => int age, Str tele (이전 주소)
  new arr => int age, Str tele (새로운 주소)

- java -> 가비지 컬렉터 (garbage collector)
  : 새롭게 주소가 생성될 때, heap에 남아있는 메모리 (더 이상 사용하지 않는) 를 자동으로 삭제해 줌
  : 명시적 객체 생성
  => react에서도 동일한 기능을 제공한다!

- parameter로 함수를 받을 수 있는 특징 (때문에 배우기 어려운 부분 존재)
  : set (int n) {} => int 자리에 method가 들어갈 수 있음

- 기존 방식(java 등)의 경우 실행 시 로드된 만큼 보여지지만,
  리액트의 경우 백지 상태에서 시작하여 100% 다운로드가 되어야지만 로드됨
  혹시라도 전부 받아오지 못 할 경우 아예 아무것도 나오지 않음 (최초 로딩 시간이 조금 있는 편)
  새로고침을 하더라도 리소스 유지가 되어 별도 메모리 소모가 없음

- 리액트 작업 경로(폴더 이름)는 무조건 "소문자"로 만들어야 한다 (대문자 인식 X)

1. https://nodejs.org/dist/v22.19.0/node-v22.19.0-x64.msi 에서 노드js 다운로드
2. cmd에서 node -v로 버전 체크 (node 실행 후 명령어 입력 가능)
3. VSC에서 New Terminal 열고, 'Powershell' 아닌 'Command Prompt'로 하단 윈도우 열기
4. 설치 경로 체크 후,
   npm install -g npm@10.5.2 --force
   npx create-react-app .
   명령어 입력하여 리액트 설치하기
5. 설치가 완료되었다면 (Happy hacking 문구) npm start를 입력한다
6. 새로운 브라우저가 (내부 서버) 열리는 것을 확인

## src/index.js (시작 페이지)

    root.render(
    <React.StrictMode>
      *<App /> --> App.js
      (상단 import App from "./App"; 해당 경로에 위치한 js 파일을 불러옴)
    </React.StrictMode>
    );

## App.js (Component)

- return (); 으로 감싼 영역 안에 페이지 내용 담김
  (반드시 1개의 태그 필요 - 없을 경우 에러)
- 부모 태그는 1개만 인정됨 (필수 : 2개는 만들 수 없음)
  (상단 import "./App.css"; 해당 경로에 위치한 css 파일을 불러옴)
- a태그 설정 시, 페이지가 없더라도 404 error가 나오지 않는다

* 페이지에 들어가는 태그들이 많을 경우, 관리의 어려움이 있을 수 있기 때문에
  리액트에서는 태그를 함수로 묶어 관리할 수 있다 (App.js 참고)
  function Header(props) {
  return ();
  }
  - <Header></Header> 태그를 통해 함수(Component)를 불러올 수 있고,
  - props라는 parameter값을 설정하여 특정값을 받아올 수도 있다
  - 별도 js 파일을 만들어 import 할 수도 있다
    (js파일 최하단에 export default 이름;
    을 통해 export 해야만 다른 js에서 import할 수 있다)

## 변수(var)와 구조

: 함수가 아닌 변수로 생성하여 가져오기도 한다

let a = 10; // a = 11; (값이 변경됨)
const b = 10; (상수 : final) // b = 11; (에러)
let list = [];

props (parameter) <= tag에서 명명한 값
ㄴ topics (list) , onChangeMode (function)
ㄴ topics.xx (topic = var)
: 변수를 받아 역으로 올라오는 구조를 익혀야 한다 (처음으로 rotation)

- for 반복문과 .push로 리스트에 값 추가
- 태그에 id 변수를 부여하고 클릭 시 target의 id를 받아올 수 있도록 세팅

## git 관리

node_modules 폴더가 용량이 크기 때문에,
파일을 주고 받을 경우 지우고 전달하면 된다.

ctrl + c => 종료
npm install => 터미널에 해당 명령어 입력하여 재설치
npm start => 리액트 시작

## 리액트 수업 2일차 : 2025/09/16/TUE

div "className" 호환성 때문에 쓰임

## useState() 함수 사용을 익숙하게!

import 필수!
[a,b] 리스트 형태로 묶어
b 상태를 변경 시 a값에 반영될 수 있도록

리액트 문법 : { A && ()} : A가 있어야 괄호 안의 동작 수행
(ex) selected에 값이 있을 때만 div를 생성

{selected && (

  <div>
  <h3>{selected.title}</h3>
  <p>{selected.description}</p>
  </div>
)}

<form onSubmit={}> // submit을 했을 때 발생 + 새로고침
<input type="text" name="title" placeholder="input title"></input>
</form> // name => submit 할 때 전달되는 속성의 이름

<!-- id 숫자로 받아올 때 String으로 받아오는 것 조심할 것
    Number()로 묶거나 '===' 값 비교 지양할 것! -->

<!-- 계산기 만들기 -->

<!-- moodChange 함수에서 feel 값이 한 번씩 밀리는 이유는 React의 비동기적 상태 업데이트 때문입니다.

문제의 원인 🔍
React의 useState 훅을 사용해 상태를 업데이트하는 함수(setFeel 등)는 비동기적으로 작동합니다. 즉, setFeel(e.target.value)를 호출하더라도, 해당 줄이 실행된 직후에 feel 변수가 즉시 변경되는 것이 아닙니다. React는 여러 상태 업데이트를 모아서 한 번에 처리해 성능을 최적화합니다.

따라서 moodChange 함수 내부에서는 다음과 같은 순서로 코드가 실행됩니다.

setFeel(e.target.value);

feel 상태를 업데이트하도록 요청합니다.

console.log(e.target.value);

현재 선택된 값 (행복, 슬픔 등)이 올바르게 출력됩니다.

console.log(feel);

setFeel 요청이 아직 반영되지 않았기 때문에, feel 변수에는 업데이트되기 이전의 값이 남아있습니다. 이 때문에 feel 값이 한 번씩 밀려서 출력됩니다.

if (feel == "행복") ...

이 조건문도 업데이트되기 전의 feel 값을 사용하므로, 실제 선택한 기분과 다른 이모티콘이 표시됩니다.

해결 방법 💡
이 문제를 해결하려면, setFeel 함수가 아닌 e.target.value (사용자가 선택한 현재 값)를 직접 사용해서 조건문을 처리해야 합니다.

아래는 수정된 moodChange 함수입니다.

JavaScript

function moodChange(e) {
  const selectedValue = e.target.value; // 현재 선택된 값을 변수에 저장
  setFeel(selectedValue); // 상태를 업데이트합니다.

  // 업데이트된 상태(selectedValue)를 사용하여 즉시 로직을 처리합니다.
  if (selectedValue === "행복") {
    setEmotion("😊");
  } else if (selectedValue === "슬픔") {
    setEmotion("😭");
  } else if (selectedValue === "화남") {
    setEmotion("😡");
  } else {
    setEmotion(""); // '기분을 선택하세요' 옵션을 위한 처리
  }
}
이제 selectedValue 변수가 setFeel 호출과 관계없이 즉시 현재 값을 가지므로, 올바른 이모티콘을 표시할 수 있습니다. 😃 -->

## 리액트 수업 3일차 : 2025/09/17/WED

function App() {
// useState 활용하여 배열을 추가하는 예제
let [fruit, setFruit] = useState([]); // 안에 대괄호를 넣으면 배열로 초기값 설정됨
let [inputVal, setInputVal] = useState("");

function addFruit() {
if (inputVal.trim()) {
setFruit([...fruit, inputVal]); // 기존 배열값을 복사 후 입력값을 추가함
// inputVal 자리에 여러 개의 데이터를 json 형태로 보낼 수 있음
// setFruit([...fruit, {name, age}]);
setInputVal("");
}
}

## Map의 활용

용례 :
{fruit.map((f) => (

<li>{f}</li>
))}
}

map에서 값을 들고 올때는,
변수 이름이 아니라 배열의 요소 이름을 가져와야 한다
fruitName (X)
f.name (O)

{user.map((u, index) => (

<tr>
<td>{u.name}</td>
<td>{u.age}</td>
<td>
<input
                  type="button"
                  value="삭제"
                  onClick={delUser(index)}
                ></input>
</td>

index 값을 별도로 가져올 수 있음
(status와 유사)

## filter 함수

function delUser(index) {

- filter는(내장 메서드) 배열을 순회하면서 조건에 맞는 요소만 골라서 새로운 배열을 만드는 함수

- 최대 두 개의 인자를 가지는데,

* 첫 번째 인자 res는 배열의 i번째 요소 : 사용하지 않는다면 언더바로 지정
* 두 번째 인자 i는 배열의 인덱스값(을 자동 추적하여 순회한다)

  let newUser = user.filter((res, i) => i !== index); // result, index 요소
  setUser(newUser);

}

const removeMovie = (id) => {
setMovies(
movies.filter((m) => {
return m.id != id;
}));};

// id를 받아와서 배열 중에 id와 다를 경우 filter 메서드를 통해 새롭게 배열 생성

## JSX란?

.jsx는 JSX(JavaScript XML) 문법으로 작성된 파일을 나타내는 파일 확장자입니다.

JSX는 자바스크립트의 확장 문법으로, HTML과 유사한 마크업을 자바스크립트 코드 내부에 작성할 수 있게 해줍니다. 리액트(React)에서 컴포넌트의 UI를 정의할 때 주로 사용됩니다.

HTML과 유사한 구조: <와 >로 둘러싸인 태그 형태를 사용합니다.

자바스크립트 표현식 포함 가능: 중괄호 {}를 사용하여 자바스크립트 변수나 표현식을 태그 내에 삽입할 수 있습니다.

컴파일 과정 필요: 브라우저는 JSX를 직접 해석하지 못하기 때문에, 바벨(Babel)과 같은 트랜스파일러를 통해 일반 자바스크립트 코드로 변환하는 과정이 필요합니다.

.jsx 파일은 보통 리액트 컴포넌트를 정의하는 데 사용되며, 파일 이름을 통해 해당 파일이 JSX 문법을 포함하고 있음을 개발자에게 알려주는 역할을 합니다. 최근에는 .js 확장자를 사용하면서도 JSX 문법을 사용하는 경우가 많아졌지만, .jsx는 여전히 JSX 전용 파일임을 명시적으로 나타내는 좋은 방법입니다.

/public/index.html
: 해당 페이지 내 부트스트랩 등 CSS 라이브러리 CDN 추가 가능함

npm install react-router-dom
: 명령어를 통해 설치

react-router-dom의 역할
웹사이트에서 '홈', '소개', '문의'와 같은 메뉴를 클릭했을 때 페이지가 전환되는 것을 보셨을 겁니다. 이처럼 싱글 페이지 애플리케이션(SPA)에서 페이지 이동 기능을 구현할 때 react-router-dom이 사용됩니다.

이 패키지를 설치하면 다음과 같은 기능들을 사용할 수 있습니다.

<BrowserRouter>: HTML5 History API를 사용하여 URL을 동적으로 관리합니다.

<Routes>: 여러 라우트(경로)를 감싸는 컨테이너 역할을 합니다.

<Route>: 특정 URL 경로와 연결될 컴포넌트를 정의합니다.

<Link>: 클릭하면 페이지를 다시 로드하지 않고 다른 경로로 이동시켜주는 링크를 만듭니다.

<Router> 안에 <Routes>로 감싼다.
<Routes> 안에 <Route>로 감싼다.

<Link> 안에 to="#" 로 이동할 수 있다.
  ( = a 태그 안에 href="#" 와 동일)
