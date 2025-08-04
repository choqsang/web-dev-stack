<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
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

<!-- 접근 권한 별 페이지 설정 -->
<div id="anonymous" style="display: none;">
	<sec:authorize access="isAnonymous()">
	<a href="/register">회원가입</a><br>
	<a href="/login">로그인</a><br>
	</sec:authorize>
</div>
<div id="authenticated" style="display: none;">
	<sec:authorize access="isAuthenticated()">
	<a href="/logout">로그아웃</a><br>
	<a href="/mypage">마이 페이지</a>
	</sec:authorize>
</div>
<div>
	<sec:authorize access="hasRole('ADMIN')">
	<a href="/admin">관리자 페이지</a>
	</sec:authorize>
</div>
	
	<script>
		const token = localStorage.getItem("token");
		if(token!==null){
			$('#authenticated').show();
		} else {
			$('#anonymous').show();
		}
		
	</script>
	</body>
</html>

