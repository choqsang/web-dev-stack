<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--

jsp 파일 내 경로 이동(주소 입력) 시,
기본적으로 webapp 폴더 기준으로 시작되기 때문에
"/폴더명" 으로 지정해두면 절대적인 위치값을 지정할 수 있고,
"폴더명"으로만 경로를 설정하면 현재 jsp파일이 위치한 폴더로부터 "폴더명"에 대한 추가적인 탐색이 이루어진다.

ex) views 폴더에 위치한 index.jsp에서
"/views/login.jsp"
=> http://localhost:8080/views/login.jsp
"views/login.jsp"
=> http://localhost:8080/views/views/login.jsp

--%>

	<h1>회원 관리</h1>
	<% Member member = (Member) session.getAttribute("member");
	if(member==null) { %>
	<ul>
		<%-- 로그인 되어 있지 않은 경우 --%>
		<li><a href ="/views/register.jsp">회원가입</a></li>
		
		<li><a href ="/views/login.jsp">로그인</a></li>
	</ul>
	   
	<% } else {%>
	<ul>
		<%-- 로그인 된 경우 --%>
		<h3><%=member.getId() %>님 안녕하세요!</h3>
		
		<li><a href="/views/search.jsp">회원검색</a></li>
	
		<li><a href="/allMember">전체 회원 보기</a></li>
						
		<li><a href="/logout">로그아웃</a></li>
	</ul>
	<% } %>
</body>
</html>