<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<style>
body {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

</style>

<script>
	function send(f) {
		if(f.name.value.trim() == "" || f.content.value.trim() == "" || f.pwd.value.trim() == ""){
			alert("모든 항목을 입력해주세요")
			return;
		} else {
			f.action="visit_modify.do";
			f.method="post";
			f.submit();
			}
		}
</script>

</head>
<body>
	<h1>방명록 수정</h1>
	
	<form>
	<input type="hidden" name="idx" value="${vo.idx}"/>
	<table border="1">
			<tr>
			<th>작성자명</th>
			<td><input name="name" value="${vo.name}" placeholder="이름을 입력하세요"> (${vo.idx})</td>
			</tr>
			
			<tr>
			<th>내용</th>
			<td><textarea name="content" style="width: 400px; height: 300px;">${vo.content}</textarea>
			</tr>
			
			<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pwd" value="${vo.pwd}" placeholder="비밀번호를 입력하세요"></td>
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