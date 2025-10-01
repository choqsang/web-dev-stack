<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
		
		<style>
			a:link{ text-decoration: none; }
			a:hover{ text-decoration: underline; color:red; }
		</style>
		
		<script>
		function send(category){
			const f = document.querySelector('form');
			f.action="list.do?category=" + category;
			f.method="get";
			f.submit();
		}
		</script>
	</head>
	
	<body>
		<hr width="600" border="1" noshade color="navy" />
		
		<div>
			<font size="4" color="maroon">
				<b>KOREA SHOPPING CENTER</b>
			</font>
		</div>
		
		<hr width="600" border="1" noshade color="navy" />
		<!-- <form>
		<div onClick="send(this.form)">
			<span onClick="location.href='/list.do?category=com001'">컴퓨터</span>
			<span onClick="location.href='/list.do?category=ele002'">생활가전</span>
			<span onClick="location.href='/list.do?category=sp003'">스포츠</span>
		</div>
		</form> -->
			<a onClick="send('com001')">컴퓨터</a>
			<a onClick="send('ele002')">생활가전</a>
			<a onClick="send('sp003')">스포츠</a>
		<hr width="600" border="1" noshade color="navy" />
	</body>
</html>