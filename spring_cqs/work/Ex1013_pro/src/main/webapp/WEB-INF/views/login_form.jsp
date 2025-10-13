<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script>
			function send(f){
				f.action = "login.do?id=" + f.id.value + "&pwd=" + f.pwd.value;
				f.method = "post";
				f.submit();
			}
		</script>
	</head>
	<body>
		
		<form>
		<table border="1">
		<caption>로그인</caption>
			<tr>
				<th>아이디</th>
				<td><input name="id" placeholder="아이디를 입력하세요" /></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" placeholder="비밀번호를 입력하세요" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="로그인" onClick="send(this.form)"/>
				<input type="button" value="취소" onClick="history.back()"/>
				</td>
			</tr>
		</table>
		</form>
		
	</body>
</html>