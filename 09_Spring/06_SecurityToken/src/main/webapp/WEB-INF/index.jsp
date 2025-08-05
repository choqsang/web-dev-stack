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
<sec:authorize access="isAnonymous()"></sec:authorize>
<sec:authorize access="isAuthenticated()"></sec:authorize>
<sec:authorize access="hasRole('ADMIN')"></sec:authorize>
	
<div id="anonymous">
	<a href="/register">회원가입</a><br>
	<a href="/login">로그인</a><br>
</div>

<div id="authenticated">
	<a href="/logout" id="logout">로그아웃</a><br>
	<a href="/mypage" id="mypage">마이 페이지</a><br>
</div>

	<a href="/admin" id="admin">관리자 페이지</a>
	
	<script>
		const token = localStorage.getItem("token");
		if(token!==null){
			$('#authenticated').show();
			$('#anonymous').hide();
			$('#admin').hide();
			
			$.ajax({
				url: '/check',
				type: 'get',
				data: { token : token },
				success: function(data){
					if(data.role === 'ROLE_ADMIN'){
						$('#admin').show();
					}
				}
			})
		} else {
			$('#anonymous').show();
			$('#authenticated').hide();
			$('#admin').hide();
		}
		
			$('#logout').click((e)=>{
				e.preventDefault();
				localStorage.removeItem("token");
				location.href="/";
				//location.reload();
			})
			
			$('#mypage').click((e)=>{
				e.preventDefault();
				$.ajax({
					url: '/mypage',
					type: 'get',
					beforeSend: function(xhr){
						xhr.setRequestHeader('Authorization', 'Bearer ' + token);
					},
					success: function(data){
						$('body').html(data);
					}
				})
			})
			
			$('#admin').click((e)=>{
				e.preventDefault();
				$.ajax({
					url: '/admin',
					type: 'get',
					beforeSend: function(xhr){
						xhr.setRequestHeader('Authorization', 'Bearer ' + token);
					},
					success: function(data){
						$('body').html(data);
					}
				})
			})
		
			// SPA(Single Page Application) -> React, Vue (동일한 주소 안에서 페이지가 구성되어 있음) 
	</script>
	</body>
</html>

