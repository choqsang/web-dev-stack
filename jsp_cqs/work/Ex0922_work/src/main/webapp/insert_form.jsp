<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script>
			function send( f ) {
				
				let deptno = f.deptno.value;
				let dname = f.dname.value;
				let loc = f.loc.value;
				let patt = /^[0-9]*$/;
				
				if(!patt.test(deptno) || deptno == ''){
					alert('부서번호는 정수로 입력하세요');
					return;
				}
				
				if(dname == ''){
					alert('부서이름을 입력하시오');
					return;
				}
				
				if(loc == ''){
					alert('위치를 입력하시오');
					return;
				}
				
				f.action = 'insert_dept';
				f.submit();
				
			}
		</script>
	</head>
	
	<body>
		<form>
			<table border="1">
				<caption>부서 등록</caption>
				<tr>
					<td>부서번호</td>
					<td><input name="deptno" /></td>
				</tr>
				
				<tr>
					<td>부서이름</td>
					<td><input name="dname" /></td>
				</tr>
				
				<tr>
					<td>위치</td>
					<td><input name="loc" /></td>
				</tr>
			</table>
			<input type="button" value="등록"
				   onclick="send(this.form);" />
		</form>
	</body>
</html>