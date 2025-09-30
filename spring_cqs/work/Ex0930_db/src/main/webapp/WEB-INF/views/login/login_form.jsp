<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<script src="/member/resources/js/httpRequest.js" ></script>
<!-- 경로에 package 이름을 적어서 접근 가능 -->

<script>
	function send(f){
		// alert(f.id.value + "/" + f.pwd.value);
		let url = "check_login.do";
		let param = "id=" + f.id.value + "&pwd=" + encodeURIComponent( f.pwd.value );
		sendRequest( url, param, resultFn, "post" );
		
	}
	
	// 콜백 메서드
	function resultFn(){
		if(xhr.readyState == 4 && xhr.status == 200 ){
			// [{'res':'no_id'}]
			let data = xhr.responseText;
			let json = eval(data);
			
			if(json[0].res == 'no_id'){ // id 불일치
				alert("존재하지 않는 아이디입니다")
			} else if(json[0].res == 'no_pwd') { // pwd 불일치
				alert("비밀번호가 일치하지 않습니다")
			} else if(json[0].res == 'clear') { // 모두 일치
				location.href="list.do";
			}
		}
	}
</script>

</head>
<body>
	
	<form>
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input name="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="button" value="로그인" onClick="send(this.form)" />
				</td>
			</tr>
			
		</table>
	</form>
	
</body>
</html>