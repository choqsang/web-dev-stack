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

npm install => 터미널에 해당 명령어 입력하여 재설치
npm start => 리액트 시작
