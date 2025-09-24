<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script>
			function modify( f ) {
				
				let deptno = f.deptno.value;
				let dname = f.dname.value;
				let loc = f.loc.value;
				
				if(deptno == ''){
					alert('수정할 부서번호를 입력하시오');
					return;
				}
				
				if(dname == ''){
					alert('수정할 부서이름을 입력하시오');
					return;
				}
				
				if(loc == ''){
					alert('수정할 위치를 입력하시오');
					return;
				}
				
				f.action = 'update_dept_fin';
				f.submit();
				
			}
		</script>
	</head>
	
	<body>
		<form>
			<input type="hidden" name="ori_deptno" value="${vo.deptno}" />
			<table border="1">
				<caption>부서 정보 수정</caption>
				<tr>
					<th>부서번호</th>
					<td><input name="deptno" value="${vo.deptno}" /></td>
				</tr>
				
				<tr>
					<th>부서이름</th>
					<td><input name="dname" value="${vo.dname}" /></td>
				</tr>
				
				<tr>
					<th>위치</th>
					<td><input name="loc" value="${vo.loc}" /></td>
				</tr>
			</table>
			<input type="button" value="수정"
				   onclick="modify(this.form);" />
		</form>
	</body>
</html>