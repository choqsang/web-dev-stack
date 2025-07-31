<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>

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
	background: black;
	}
	
	h1{
	color: brown;
	}
}
</style>
</head>

<body>
	<h1>홈페이지</h1>
	<c:choose>
		<c:when test="${not empty user}">
		<h3>${user.name}님이 로그인 하셨습니다.</h3>
		
		<!-- 로그인 유저 정보 수정 -->
		<form action="/update" method="post">
			비밀번호 : <input type="password" name="pwd" value="${user.pwd}"><br>
			이름 : <input type="text" name="name" value="${user.name}"><br>
			나이 : <input type="text" name="role" value="${user.role}"><br>
			<input type="submit" value="회원정보 수정">
		</form>
		<a href="/logout"><b>로그아웃</b></a>
	</c:when>
	
	<c:otherwise> 	
	<a href="/register">회원가입</a><br>
	<a href="/login">로그인</a><br><br>
	</c:otherwise>
	</c:choose>
	
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

