<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<script>
	function send(f) {
		// 유효성 체크 생략
		// f.name.value == null
		f.action="member_insert.do";
		f.method="post";
		f.submit();
	}
</script>

</head>
<body>
	<h1>멤버 등록</h1>
	
	<form>
	<table border="1">
			<tr>
			<th>이름</th>
			<td><input name="name"></td>
			</tr>
			
			<tr>
			<th>아이디</th>
			<td><input name="id"></td>
			</tr>
			
			<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pwd"></td>
			</tr>
			
			<tr>
			<th>이메일</th>
			<td><input name="email"></td>
			</tr>
			
			<tr>
			<th>주소</th>
			<td><input name="addr"></td>
			</tr>
			
			<tr>
			<td colspan="2">
			<input type="button" value="등록" onClick="send(this.form)"/>
			<input type="button" value="취소" onClick="history.back()"/>
												<!-- history.go(-1) -->
			</td>
			<tr>
		
	</table>
	</form>
	
</body>
</html>