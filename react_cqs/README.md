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

## 리액트 수업 4일차 : 2025/09/18/THU

npm i axios
: 엑시오스 설치 (install = i 로 축약 가능)

### 엑시오스의 역할

Axios는 브라우저와 Node.js 환경에서 모두 사용 가능한 강력한 HTTP 클라이언트 라이브러리입니다. 웹 애플리케이션이나 서버가 외부 API와 통신할 때 데이터를 주고받기 위한 비동기 요청을 손쉽게 처리하는 역할을 합니다.

API 요청: GET, POST, PUT, DELETE 등 다양한 HTTP 요청 메서드를 사용하여 서버에 데이터를 요청하거나 보냅니다.

비동기 통신: Promise 기반으로 작동하여 비동기 요청을 간결하게 처리할 수 있습니다. async/await 문법과 함께 사용하면 코드를 더 읽기 쉽게 만들 수 있습니다.

데이터 변환: 서버에서 받은 JSON 데이터를 자동으로 JavaScript 객체로 변환해 주거나, 요청을 보낼 때 JavaScript 객체를 JSON 형식으로 변환해 주는 등 데이터 형식을 편리하게 다룹니다.

오류 처리: 네트워크 오류나 서버 응답 오류가 발생했을 때 이를 체계적으로 처리할 수 있는 기능을 제공합니다.

요청/응답 인터셉터: 모든 요청이나 응답이 보내지거나 도착하기 전에 공통적인 작업을 수행할 수 있도록 해줍니다. 예를 들어, 모든 요청 헤더에 인증 토큰을 자동으로 추가하거나, 오류 로그를 기록하는 등의 작업을 할 수 있습니다.

요약하자면, axios는 복잡한 HTTP 통신을 단순화하여 개발자가 API와의 상호작용을 효율적으로 구현할 수 있게 돕는 유용한 도구입니다.

<Route path="/users" element={<Users />}></Route>
페이지 구성 후 element에 붙이는 방식으로 불러옴 (import 필수)

import React, { useState, useEffect } from "react";
import axios from "axios";
(dependency 추가)

### useEffect() - axios 활용

.get
("https://jsonplaceholder.typicode.com/users");

- 비동기 구조를 axios를 통해 가져와 현재 페이지에 갱신
- json 형태 정보가 response에 data로 담겨 있음
- data를 변수에 담아 페이지에 출력 가능

.then((response) => {
setUsers(response.data); // users 배열에 동기화
setLoading(false); // 로드 종료 시 false로 spinner 비활성화
});

컴포넌트가 렌더링될 때마다 특정 작업을 수행하도록 설정합니다. 사이드 이펙트(side effect), 즉 데이터 가져오기(fetching), 구독(subscription) 설정, DOM 직접 조작 등의 작업을 처리할 때 사용합니다.

두 번째 인자인 의존성 배열(dependency array)을 통해 실행 시점을 제어할 수 있습니다.

[] (빈 배열): 컴포넌트가 마운트될 때(처음 렌더링될 때) 한 번만 실행.

[변수명] (배열 안에 변수): 배열 안의 변수 값이 변경될 때마다 실행.

의존성 배열이 없는 경우: 렌더링될 때마다 매번 실행.

### useParams()

: 특정 파라미터값을 받기 위한 hook

const { id } = useParams();
.get("https://jsonplaceholder.typicode.com/users/" + id)
와 같은 형태로 파라미터를 함께 보낸다

## 리액트 수업 5일차 : 2025/09/19/FRI

https://www.bootstrapcdn.com/

// import가 필요한 Hook

### useParams

: URL의 경로에 포함된 값을 가져옴

useParams는 URL의 **경로 매개변수(Path Parameters)**를 객체 형태로 추출합니다. 경로 매개변수는 URL 경로에 동적으로 변하는 값을 포함할 때 사용됩니다.
const { title } = useParams();는 URL 경로에 :title이라는 매개변수가 있을 때 해당 값을 가져오는 코드

### useLocation

: URL에 노출되지 않는 추가 데이터(state)를 가져옴

useLocation은 현재 URL에 대한 위치(Location) 객체를 반환합니다. 이 객체는 URL에 대한 다양한 정보를 포함하며, 특히 **상태(State)**를 전달할 때 유용합니다.
const { state } = useLocation();는 페이지 이동 시 state 객체에 담아 보낸 데이터를 받아오는 코드

### useNavigate

<Link> 컴포넌트처럼 클릭 이벤트가 아닌, 특정 로직이나 조건에 따라 프로그래밍 방식으로 페이지를 이동시킬 때 주로 사용됩니다.

조건에 따라 동적으로 페이지 이동을 제어해야 할 때 매우 유용합니다. 예를 들어, 사용자가 폼을 제출하고 유효성 검사를 통과했을 때만 다음 페이지로 이동시키고 싶다면 useNavigate를 사용해야 합니다.

// 이전 페이지로 돌아가기 (브라우저의 '뒤로가기'와 동일)
navigate(-1);
// 다음 페이지로 이동
navigate(1);

`/product/123` 경로로 이동하면서 `{ item: 'apple' }` 상태를 전달
navigate('/product/123', { state: { item: 'apple' } });

### Backend와 Frontend 그리고 서버 분리

: 작업하는 폴더 별로 각각의 모듈 설치

- 백엔드에 설치
  npm init -y
  npm i mysql express cors nodemon
  npm i mysql2 (추가)

- 프론트엔드에 설치
  npx create-react-app .
  서버를 실행할 때는 프론트엔드에서!
  npm i react-router-dom (혹은 최상위 공통 경로에 설치)
  npm i axios

### XAMPP Control Panel

https://www.apachefriends.org/download.html
PHP 8.2.12 Download (64 bit) : 149Mb
설치 후, Apache > Admin > 'phpmyadmin'
==> 실행 오류로 MySQL로 진행하였음

- backend 폴더에 server.js 파일 생성 이후 하단 내용 기입

const express = require("express");
const mysql = require("mysql2"); // 2로 변경
const cors = require("cors");

const app = express();
app.use(cors());
app.use(express.json());

// DB 연결 정보
const db = mysql.createConnection({
host: "localhost", // 호스트명
user: "root", // 유저명
password: "qwer1234", // 비밀번호
database: "signup", // 스키마 이름
});

app.listen(3000, () => {
console.log("listening");
});

- package.json 에서
  "scripts": {
  "test": "echo \"Error: no test specified\" && exit 1",
  "start": "node server.js"
  }
  => "start" 스크립트 추가

- setting 끝나면 terminal에서 경로 cd backend 지정
- npm start 시 위에 설정한 "listening"이 콘솔에 출력되면 세팅 완료

### DB 연동 오류 해결

"mysql" ==> "mysql2"

mysql 라이브러리가 제대로 작동하지 않았던 것은
대부분 root 계정의 인증 방식이 caching_sha2_password로 설정되어 있었기 때문입니다. (구 버전은 mysql_native_password 방식만 지원)

mysql2는 이 인증 방식을 기본적으로 인식하고 처리하므로 별도의 설정 없이 바로 연결에 성공하게 된 것입니다.

따라서 최신 버전의 MySQL을 사용한다면, mysql보다 mysql2를 사용하는 것이 훨씬 안정적이고 편리합니다.

### DB 접속 및 쿼리 요청

: 회원 가입 처리 예시

app.post("/signup", (req, res) => {
// 요청 처리 객체(request)와 응답 처리 객체(response)를 사용

const sql = "INSERT INTO login (`name`, `email`, `password`) VALUES (?)";
// 변수 backtick으로 묶어서 받아야 한다 (템플릿 리터럴)

const values = [req.body.name, req.body.email, req.body.password];
// 리퀘스트 body에 저장된 데이터를 쿼리문에 담기 위한 세팅

db.query(sql, values, (err, data) => {
// 수행하고자 하는 쿼리문과 값 입력
if (err) {
return res.json("Error"); // 문제 발생 시 에러 출력
}
return res.json(data); // 정상적으로 수행 시 data 값을 가지고 나옴
});
});
