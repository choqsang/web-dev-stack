<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<c:choose>
	<c:when test="${empty member}">
	<ul>
		<li><a href ="/views/register.jsp">회원가입</a></li>
		<li><a href ="/views/login.jsp">로그인</a></li>
	</ul>
	</c:when>
	<c:otherwise>
	<ul>
		<li><a href="/views/search.jsp">회원검색</a></li>
		<li><a href="/allMember.do">전체 회원 보기</a></li>
		<li><a href="/logout.do">로그아웃</a></li>
		
		<%-- /url 페이지 경로 뒤에 오는 쿼리 문자열
		?key1=value1&key2=value2('&'로 여러 파라미터를 구분)에 익숙해질 것! --%>
	</ul>
	</c:otherwise>
	</c:choose>
</body>
</html>