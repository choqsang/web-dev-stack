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
	
	<form enctype="multipart/form-data">
	<input type="hidden" name="idx" value="${vo.idx}">
	<table border="1" align="center">
	<caption>수정 페이지</caption>
			<tr>
				<th>작성자</th>
				<td><input name="name" value="${vo.name}"></td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" value="${vo.pwd}"></td>
			</tr>
			
			<tr>
				<th colspan="2">내용</th>
			</tr>
			
			<tr>
				<td colspan="2">
				<textarea name="content" rows="5" cols="50" wrap="on" style="resize:none;">${vo.content}</textarea>
				</td>
			</tr>
			
			<tr>
				<th>파일명</th>
				<td>
					<input name="title" value="${vo.title}"><br>
					<input type="file" name="photo"><br>
					<img src="resources/upload/${vo.filename}" width="300px" 
					onerror="this.style.display='none';"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="수정" onClick="send(this.form)"/>
				<input type="button" value="목록으로" onClick="history.go(-1)"/>
				</td>
			<tr>
	</table>
	</form>
	
</body>
</html>