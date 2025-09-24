<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- core라이브러리 추가 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script>
		
		</script>
	</head>
	
	<body>
		<table border="1">
			<caption>부서목록</caption>
			<tr>
				<th>부서번호</th>
				<th>부서이름</th>
				<th>위치</th>
				<th colspan="2">비고</th>
			</tr>
			<c:forEach var="vo" items="${list}">
				<tr>
					<td>${ vo.deptno }</td>
					<td>${ vo.dname }</td>
					<td>${ vo.loc }</td>
					<td><input type="button" value="수정"
			   				   onclick="location.href ='update_dept?deptno=${vo.deptno}'" /></td>
					<td><input type="button" value="삭제"
							   onclick="location.href = 'delete_dept?no=${vo.deptno}'" /></td>
				</tr>
			</c:forEach>
		</table>
		
		<input type="button" value="부서등록"
			   onclick="location.href='insert_form.jsp'" />
	</body>
</html>