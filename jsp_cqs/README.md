## 25-09-22 강의 메모

[JAVA] (spring X)
jsp 호환을 위해 java 11버전으로 재설치
환경변수 path에 아래 경로 추가

C:\Program Files\Java\scripts
폴더 생성 후 아래 세팅 값 메모장에 기입 후
배치파일 (java11.bat) 으로 저장
(같은 방식으로 java21.bat도 저장)

@echo off
set JAVA_HOME=C:\Program Files\Java\jdk-11
set Path=%JAVA_HOME%\bin;%Path%
echo Java 11 activated.

cmd에서 java11 / java21 이런 식으로 실행 가능

개인 jsp폴더 생성 후
util / work 하위 폴더 생성
util에 eclipse + apache-tomcat 다운로드 및 압축 해제

D:\jsp_cqs\util\apache-tomcat-9.0.105\conf 에서
server.xml 열기
오라클과 포트 중복되어
Connector port="8080" => "9090" 충돌 방지 변경

D:\jsp_cqs\util\apache-tomcat-9.0.105\webapps\examples\WEB-INF\lib 에서

taglibs-standard-impl-1.2.5.jar / taglibs-standard-spec-1.2.5.jar 복사하여
D:\jsp_cqs\util\apache-tomcat-9.0.105\lib 으로 붙여넣기
(JSTL 문법 사용을 위한 세팅)

이클립스 실행 후, 아래 경로로 워크스페이스 설정
D:\jsp_cqs\work

메뉴 - Window - Preferences - General - Workspace 체크
Web Browser에서 Chrome(external) 체크 후 Apply

Server - Runtime Env 에서 Apache Tomcat v9.0 선택
(제일 호환이 좋음)
설치 경로 browse에서 bin 폴더가 있는 D:\jsp_cqs\util\apache-tomcat-9.0.105 으로 설정 후 finish

Web - CSS Files, HTML Files, JSP Files - Encoding 에서 EUC-KR이 아니라 제일 위에 있는 ISO 10646/UTF-8로 변경
3개 모두 변경 후 Apply and Close

File > New > Dynamic Web Project
Ex0922_DB 프로젝트 생성

src > main > webapp > WEB-INF > lib 에
commons-collections-3.2.1.jar
commons-dbcp-1.2.2.jar
commons-pool-1.4.jar
ojdbc6.jar => 버전 맞지 않아 ojdbc11.jar로 변경
mybatis-3.1.1.jar
복사 붙여넣기

src > main > webapp > META-INF 에
context.xml (=JNDI) 복사 붙여넣기

<!-- JNDI( java naming directory interface )
: DB연결과 관련된 소스들을 미리 작성해 둔 설정파일 -->

실행 후 Source 눌러보면 내용 확인 가능
username과 password 맞춰놓기 /

maxActive 개념 알고 넘어가기 (=DBCP)

<!-- maxActive : 최대 연결 수
최대 접속자 수를 지정하여 대기시간을 효율적으로 사용할 수 있도록 하는 개념
( DBCP : database connection pool ) -->

(예시) 김밥 집에서 미리 20개를 포장해두는 것처럼, 한 번에 들어올 수 있는 최대 수량을 얼마나 잡아두는 지

** webapp 쪽은 frontend 내용 구성
** src/main/java 쪽은 backend 내용 구성

Ex0922_DB/src/main/java 경로에
① config.mybatis.mapper 패키지 생성 이후
sawon.xml 붙여넣기
② config.mybatis.set 패키지 생성 이후
sqlMapConfig.xml 붙여넣기

<mappers>
<mapper resource="config/mybatis/mapper/sawon.xml" /> : 참조 파일명 변동 시 꼭 같이 바꿔줄 것!
</mappers>

: 위 경로에서 mapper 설정 및 관리

<dataSource type="JNDI">
<property name="data_source" value="java:comp/env/jdbc/test2" />
</dataSource>

: value값에 JNDI에 설정한 식별자 name="jdbc/oracle_test"
경로로 변경 후 저장 ( test2 => oracle_test )

util 폴더 내 jdbc_templ.xml 옮겨 놓은 후, (강사님 예전 직장에서 쓰던 파일)
메뉴 - Window - Preferences - Java - Editor - Templates 에서
위 파일 import 하고 Apply and close (싱글톤 사용을 위한 세팅)

Ex0922_DB/src/main/java 경로에
service 패키지를 만들고 MyBatisConnector.java 클래스 생성
'\_single' 자동완성으로 싱글톤 생성

- Stack / heap 개념을 알아야 한다
  MyBatisConnector mbc = new MyBatisConnector();
  mbc.aaa();

new mbc를(메모리 할당) 하면 heap에 새로 만들어짐
new를 할 때마다 새로운 주소로 이동하면서 주인 없는 집들이 생긴다
메모리 낭비를 줄이고 하나를 잘 만들어서 이용하기 위해
싱글톤 패턴을 만든다

MyBatisConnector mbc = MyBatisConnector.getInstance();
인스턴스 호출 시

public static MyBatisConnector getInstance() {
//생성되지 않았으면 생성
if (single == null)
single = new MyBatisConnector();
//생성된 객체정보를 반환
return single;
}

Stack : mbc(single) => heap

- 주소가 있을 경우 new가 아닌 기존 정보를 반환하게끔 세팅
  (효율적인 메모리 관리) 자바를 기반으로 하는 곳에서 반드시 쓰임

public MyBatisConnector() { // 기본생성자 자동완성
// sqlMapConfig.xml 파일을 읽어온다
// Reader(*java import), Resource(*ibatis import) .getResourceAsReader(경로);

SqlSessionFactory(\*ibaits import) factory = null;

try {
Reader reader = Resources.getResourceAsReader("config/mybatis/set/sqlMapConfig.xml");
factory = new SqlSessionFactoryBuilder().build(reader);
reader.close();
} catch (IOException e) {
e.printStackTrace();
}}
public SqlSessionFactory getFactory() {
return factory;
}

[ORACLE]
-- 학생 정보관리 테이블
CREATE SEQUENCE seq_sungtb_no;
CREATE TABLE sungtb(
no number(3) primary key,
name varchar2(50),
kor number(3),
eng number(3),
mat number(3)
);
-- 샘플 데이터 추가
INSERT INTO sungtb VALUES (
seq_sungtb_no.nextVal,
'일길동',
77, 88, 99
);
COMMIT;

[TEST]

1. VO 생성 및 내용 추가
2. DAO 생성 및 내용 추가
3. mapper에 쿼리 작성
4. servlet 생성 및 내용 추가
5. 포워딩된 데이터를 jsp에서 가공

[JAVA]
① VO(value object) 객체를 만들어서 한 명의 정보를 온전히 출력하기 위한 정보를 묶어서 관리
Ex0922_DB/src/main/java 에 vo라는 패키지 생성 / 하위 항목으로 SjVO.java 클래스 생성
오라클 DB에 추가해놓은 테이블 컬럼대로 추가 + Getter/Setter 추가

public class SjVO {
private int no;
private String name;
private int kor, eng, mat;
// 실제 테이블에 있는 내용과 동일하게 생성해야 한다.
public int getNo() {
return no;
}
public void setNo(int no) {
this.no = no;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public int getKor() {
return kor;
}
public void setKor(int kor) {
this.kor = kor;
}
public int getEng() {
return eng;
}
public void setEng(int eng) {
this.eng = eng;
}
public int getMat() {
return mat;
}
public void setMat(int mat) {
this.mat = mat;
}}

② DAO (data access object) : 마이바티스 접근을 위한 클래스
Ex0922_DB/src/main/java 에 dao라는 패키지 생성
하위 항목으로 SjDAO.java 클래스 생성

- SqlSessionFactory import 및 single-ton 생성
- 기본 생성자 생성
- 목록 가져오기 (제너릭 타입은 무조건 vo로 import)

public class SjDAO {
SqlSessionFactory factory;
// single-ton pattern:
// 객체 1개만 생성해서 지속적으로 서비스하자
static SjDAO single = null;
public static SjDAO getInstance() {
//생성되지 않았으면 생성
if (single == null)
single = new SjDAO();
//생성된 객체정보를 반환
return single;
}
public SjDAO() {
factory = MyBatisConnector.getInstance().getFactory(); // 어떤 mapper를 사용하는 지
}
// 학생목록 가져오기
public List<SjVO> select(){
// mapper로 접근하기 위한 Sqlsession 객체 준비
SqlSession sqlSession = factory.openSession();
List<SjVO> list = sqlSession.selectList("s.sj_list"); // selectList, selectOne, delete 등 기본으로 제공되는 메서드
sqlSession.close(); // 조회가 끝나면 종료해주어야 한다 (사이클 완성 / 스프링 부트에서는 자동으로 처리)
return list; // DB에서 가져온 결과물 리턴
}
// 학생정보 등록
public int register(SjVO vo) {
SqlSession sqlSession = factory.openSession(true);
int res = sqlSession.insert("s.sj_insert", vo);
// mybatis에서는 (jpa외) 해당 형태로 정보를 보낸다 ("매퍼이름", "파라미터") : 파라미터는 1개만 보낼 수 있기 때문에 vo로 묶어서 보냄
sqlSession.commit();
sqlSession.close();
return res;
}
// 학생정보 삭제
public int delete(int no) {
SqlSession sqlSession = factory.openSession(true);
int res = sqlSession.delete("s.sj_del", no);
// 삭제를 위한 mapper 호출
sqlSession.close();
return res;
}}

③ "config/mybatis/mapper/su.xml" 이름 변경 후 내용 작성
<mapper namespace="s">

<!-- sqlSession.selectList("s.sj_list");으로 설정해두었기 때문에 namespace는 "s"로 세팅해야만 한다
	받아올 list의 id는 sj_list로 정할 것 -->
<select id="sj_list" resultType="vo.SjVO"> 
<!-- select를 제외한 update, insert, delete 등은 resultType이 int 고정이기 때문에 따로 기재 하지 않음 (성공 여부: 1, 0) -->
	SELECT * FROM sungtb
</select>
<insert id="sj_insert" parameterType="vo.SjVO">
	INSERT INTO sungtb VALUES( seq_sungtb_no.nextVal, #{name}, #{kor}, #{eng}, #{mat} )  
</insert>
<delete id="sj_del" parameterType="int">
	DELETE FROM sungtb WHERE no = #{no}
</delete>

④ Servlet생성 (아래에 기능별 페이지 추가 예정)
Ex0922_DB/src/main/java 에 action 패키지 생성 후 SungListAct.java 추가
Next > URL mappings에서 더블 클릭 /list.do로 수정
Next > Inherited abstract methods에서 service항목만 체크 후 finish
: 서블릿은 코드로 작성된 내용을 웹(html 구조로) 표현하는 기능을 담당

@WebServlet("/list.do")
public class SungListAct extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 학생목록 가져온다
List<SjVO> list = SjDAO.getInstance().select(); // 리스트에 가져온 정보가 담긴다
// addAttribute binding(요청처리 객체를 통해 정보를 저장) => forwarding(정보를 사용하기 위해 반환)
// list를 바인딩
request.setAttribute("list", list);
System.out.println("size : " + list.size());
// 포워딩
RequestDispatcher disp = request.getRequestDispatcher("sj_list.jsp");
disp.forward(request, response);
}}

- 실행할 때는 항상 해당 서블릿 페이지에서 Ctrl+F11을 통해 진입한다
- 경로에 없을 경우 404에러, 서버 연결이 제대로 되지 않을 경우 500에러 확인됨

⑤ Ex0922_DB/src/main/webapp 에

- sj_list.jsp (포워딩할 페이지) 생성하고 아래와 같이 페이지 구성

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!-- core 라이브러리 추가 -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<caption>학생 목록</caption>
		<tr>
		<th>번호</th>
		<th>이름</th>
		<th>국어</th>	
		<th>영어</th>
		<th>수학</th>
		<th>비고</th>
		</tr>
	<c:forEach var="vo" items="${list}"> <!-- 바인딩된 list를 EL표기법으로 불러온다 -->
		<tr>
		<td>${vo.no}</td>
		<td>${vo.name}</td>
		<td>${vo.kor}</td>
		<td>${vo.eng}</td>
		<td>${vo.mat}</td>
		<td><input type="button" value="삭제" onclick="location.href='sj_del.do?no=${vo.no}'"></td>
		</tr>
	</c:forEach>
		<tr>
		<td colspan="6">
		<input type="button" value="등록" onclick="location.href='insert_form.jsp'">
		</td>
		</tr>
	</table>
</body>
</html>

Ex0922_DB/src/main/webapp 에

- insert_form.jsp 생성 (값을 입력받기 위한 페이지)
  <script>
  function send(f){ // f = this.form을 받아온다
  	// 유효성 체크
  	let name = f.name.value;
  	if(name == ''){
  	alert("이름을 입력하세요");
  	return;
  	}
  	f.action = "sj_register.do";
  	f.submit();
  	}
  </script>
  </head>
  <body>
  <form>
  <table border="1">
  	<tr>
  	<th>이름</th>	
  	<td><input name="name"></td>	
  	</tr>
  	<tr>
  	<th>국어</th>	
  	<td><input name="kor"></td>	
  	</tr>
  	<tr>
  	<th>영어</th>	
  	<td><input name="eng"></td>	
  	</tr>
  	<tr>
  	<th>수학</th>	
  	<td><input name="mat"></td>	
  	</tr>
  	<tr>
  	<td colspan="2">
  	<input type="button" value="확인" onclick="send(this.form);"> <!-- this = button이 받고 있는 form -->
  	<!-- type에 submit을 두면 유효성 체크가 불가하기에 button으로 받아 함수 호출 안에서 진행 -->
  	<!-- 버튼을 눌렀을 때, 속성에 입력한 파라미터가 반영되어 특정한 서블릿 url에 반영되는 지 확인 
  	http://localhost:9090/Ex0922_DB/sj_register.do?name=홍길순&kor=90&eng=80&mat=75 -->
  	</td>
  	</tr>
  	</table>
  	</form>
  </body>
  </html>

- 리스트 추가 (점수 등록) 위한 페이지
  /Ex0922_DB/src/main/java/action 패키지 내에
  SungRegiAct.java (서블릿 생성명은 별로 중요치 않으나 url 매핑 주소는 꼭 세팅한대로 ( /sj_register.do ) 해야 한다)

@WebServlet("/sj_register.do")
public class SungRegiAct extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String name = request.getParameter("name"); // "name"으로 넘어온 parameter 값을 name에 부여한다
// request.getParameter로 받는 값은 무조건 String 타입으로 넘어오게 된다 -> int 타입으로 변경 필요
int kor = Integer.parseInt(request.getParameter("kor"));
int eng = Integer.parseInt(request.getParameter("eng"));
int mat = Integer.parseInt(request.getParameter("mat"));

    SjVO vo = new SjVO();
    vo.setName(name);
    vo.setKor(kor);
    vo.setEng(eng);
    vo.setMat(mat);

    SjDAO.getInstance().register(vo); // DAO에서 받아 mapper를 통해 insert 쿼리 수행
    	// return "redirect:list.do" -> insert 이후 전체 리스트 갱신 (스프링 기준)
    response.sendRedirect("list.do"); // 전체 목록을 매핑 요청하여 다시 한번 목록을 불러옴 (jsp 기준)
    }}

- 리스트 삭제를 위한 페이지
  /Ex0922_DB/src/main/java/action 패키지 내에
  SungDelAct.java 서블릿 생성 + 경로 ( /sj_del.do )

@WebServlet("/sj_del.do")
public class SungDelAct extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// sj_del.do?no=5
int no = Integer.parseInt(request.getParameter("no")); // DAO에게 보내야한다
SjDAO.getInstance().delete(no);
response.sendRedirect("list.do");
}}

### 이건 2번째 레슨

File > New > Dynamic Web Project
Ex0922_work 새로운 프로젝트 생성하여 기존 구성요소 복사해오기
