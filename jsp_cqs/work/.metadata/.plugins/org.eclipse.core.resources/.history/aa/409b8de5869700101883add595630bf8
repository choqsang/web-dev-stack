<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function send(f){ // f = this.form을 받아온다
			// 유효성 체크
			let name = f.name.value;
			if(name == ''){
				alert("이름을 입력하세요");
				return;
			}
			f.action = "sj_register.do";
			f.submit();
		}
	</script>
</head>
<body>
	<form>
		<table border="1">
			<tr>
				<th>이름</th>	
				<td><input name="name"></td>	
			</tr>
			<tr>
				<th>국어</th>	
				<td><input name="kor"></td>	
			</tr>
			<tr>
				<th>영어</th>	
				<td><input name="eng"></td>	
			</tr>
			<tr>
				<th>수학</th>	
				<td><input name="mat"></td>	
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="확인" onclick="send(this.form);"> <!-- this = button이 받고 있는 form -->
					<!-- type에 submit을 두면 유효성 체크가 불가하기에 button으로 받아 함수 호출 안에서 진행 -->
					<!-- 버튼을 눌렀을 때, 속성에 입력한 파라미터가 반영되어 특정한 서블릿 url에 반영되는 지 확인 
						http://localhost:9090/Ex0922_DB/sj_register.do?name=홍길순&kor=90&eng=80&mat=75
					-->
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>