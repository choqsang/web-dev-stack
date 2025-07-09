<%@page import="vo.Member"%>
<%@page import="java.util.ArrayList"%>
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
	<%-- 전체 회원 보기 : AllMemberServlet 
						views/allMember.jsp에 리스트 출력 --%>
						
	<h1>전체 회원 보기</h1>
	
	<table border="1">
	<tr>
		<th>인덱스</th>
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>비밀번호</th>
		<th>나이</th>
	</tr>
	<c:forEach items="${list}" var="member" varStatus="status">
	<tr>
		<%-- index : 0부터, count : 1부터 시작! --%>
		<td>${status.index}</td>
		<td>${status.count}</td>
		<td>${member.id}</td>
		<td>${member.name}</td>
		<td>${member.pwd}</td>
		<td>${member.age}</td>
	<tr>
	</c:forEach>  
	</table>
	<a href="/">메인 페이지로 이동</a>
	 					
</body>
</html>