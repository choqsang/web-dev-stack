<%@page import="com.kh.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 회원 검색</h2>
	<c:choose>
	<c:when test="${member.id eq param.id}">
	<ul>
		<li>아이디 : ${member.id}</li>	
		<li>이름 : ${member.name}</li>	
		<li>나이 : ${member.age}</li>	
		</ul>
		<a href="/">메인 페이지로 이동</a>
	</c:when>
	<c:otherwise> 										
		<!-- <h3>${id} 회원 검색에 실패했습니다!</h3>
		<a href="/">메인 페이지로 이동</a> -->
	</c:otherwise>
	</c:choose>
	
</body>
</html>