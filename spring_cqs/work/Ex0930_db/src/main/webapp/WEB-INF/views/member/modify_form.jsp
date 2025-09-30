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
		f.action="modify_fin.do?idx=" + f.idx.value;
		f.method="post"
		f.submit();
	}
</script>

</head>
<body>
	<h1>정보 수정</h1>
	<form>
	<input type="hidden" name="idx" value=${vo.idx} />
	<table border="1">
	
			<tr>
			<th>이름</th>
			<td><input name="name" value=${vo.name}></td>
			</tr>
			
			<tr>
			<th>아이디</th>
			<td><input name="id" value=${vo.id}></td>
			</tr>
			
			<tr>
			<th>비밀번호</th>
			<td><input placeholder="변경 원하시는 비밀번호를 입력해주세요" name="pwd"></td>
			</tr>
			
			<tr>
			<th>이메일</th>
			<td><input name="email" value=${vo.email}></td>
			</tr>
			
			<tr>
			<th>주소</th>
			<td><input name="addr" value=${vo.addr}></td>
			</tr>
			
			<tr>
			<td colspan="2">
			<input type="button" value="수정" onClick="send(this.form)"/>
			<input type="button" value="취소" onClick="history.back()"/>
			</td>
			<tr>
	</table>
	</form>
	
</body>
</html>