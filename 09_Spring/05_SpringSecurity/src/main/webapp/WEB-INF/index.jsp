<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>index</title>

<style>
	body {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	color: navy;
	padding-top: 100px;
	}
	
	a {
	border: 1px solid black;
	color: white;
	background: grey;
	}
	
	h1{
	color: brown;
	}
	
	table{
	max-width: 600px;
	}
	
	table th{
	min-width: 3em;
	}
}
</style>
</head>

<body>
<h1>KH 정보교육원</h1>

	<sec:authorize access="isAnonymous()">
	<a href="/register">회원가입</a>
	<a href="/login">로그인</a>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
	<a href="/logout">로그아웃</a><br>
	<a href="/mypage">마이 페이지</a>
	</sec:authorize>
	
	<sec:authorize access="hasRole('ADMIN')">
	<a href="/admin">관리자 페이지</a>
	</sec:authorize>
	
	<!-- <form action="/select">
		<select name="select">
			<option value="all">이름 또는 아이디</option>		
			<option value="id">아이디</option>		
			<option value="name">이름</option>		
		</select>
		<input type="text" name="keyword" value="${param.keyword}">
		<input type="submit" value="검색">
	</form> -->
	
	<!-- 유저 전체 리스트 출력-->
	<h3>[회원목록]</h3>
	<form action="/delete" method="post">
		<table border="1">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>비밀번호</th>
			<th>권한</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${list}" var="user" varStatus="status">
		<tr>
			<td>${status.count}</td>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.pwd}</td>
			<td>${user.role}</td>
			<td><input type="checkbox" name="idList" value="${user.id}"></td>
		<tr>
		</c:forEach>  
		</table>
		<input type="submit" value="삭제">
	</form>
		
		<br><a href="/"><b>처음으로</b></a>
	</body>
</html>

