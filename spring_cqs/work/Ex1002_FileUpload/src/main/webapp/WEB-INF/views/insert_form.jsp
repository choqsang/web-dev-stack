<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<script>
	function send(f){
		if( f.photo.value == "" ){
			alert("파일을 선택하세요")
		}
		f.action="upload.do";
		f.submit();
	}
	
</script>

</head>
<body>

	<form method="post" enctype="multipart/form-data">
		제목 : <input name="title"><br>
		<input type="file" name="photo"> 
		<input type="button" value="전송" onclick="send(this.form)"> 
	</form>

</body>
</html>