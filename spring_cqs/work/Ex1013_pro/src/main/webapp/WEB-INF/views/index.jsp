<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<style>
			a:link{ text-decoration: none; }
			a:hover{ text-decoration: underline; color:red; }
		</style>
		
	</head>
	
	<body>
		<hr width="600" border="1" noshade color="navy" />
		
		<center>
			<font size="4" color="maroon">
				<b>KOREA SHOPPING CENTER</b><br/>
				<input type="button" value="로그인" onClick="location.href='login_form.do'">
				<input type="button" value="로그아웃" onClick="location.href='logout.do'">
			</font>
		</center>
		
		<hr width="600" border="1" noshade color="navy" />
		
		<center>
			<a href="list.do?category=com001">컴퓨터</a>
			<a href="list.do?category=ele002">생활가전</a>
			<a href="list.do?category=sp003">스포츠</a>
		</center>
		
		<hr width="600" border="1" noshade color="navy" />
	</body>
</html>