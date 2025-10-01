<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
<style>
body {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

h1{
	color: #4d73ff;
    text-shadow: 0px 2px #000;
}

table {
	width: 50%;
	margin-top: 20px;
	border: 2px solid #2b34ff;
	box-shadow: 3px 3px #555;
}
table td {
    display: flex;
    align-items: center; 
    height: 30px;
    vertical-align: middle;
    gap: 5px;
}
</style>

<script>
	
	let validPwd = false;
	function check(element, pwd){
		if(element.value === pwd){
			validPwd = true;
		} else {
			validPwd = false;
		}
	}

	function del(idx, pwd){
		if(validPwd){
			if(!confirm("삭제하시겠습니까?")){
				return;
			} else {
				alert("삭제 성공")
				location.href='/visit/visit_del.do?idx=' + idx;	
			}
		} else {
			alert("삭제하시려면 정확한 비밀번호를 입력해주세요");
		}
	}
		
	function mod(idx, pwd){
		if(validPwd){
			location.href='modify_form.do?idx=' + idx;
		} else {
			alert("수정하시려면 정확한 비밀번호를 입력해주세요");
		}
	}
	
</script>

</head>
<body>

<h1>::: 방명록 리스트 :::</h1>
<button onClick="location.href='regi_form.do'">글쓰기</button>

	<c:forEach var="list" items="${list}">
		<table>
			<tr>
			<td style="height: 150px; align-items: flex-start; background: #ffcec6;">${list.content}</td>
			<td bgcolor="#dafddd">작성자 : ${list.name} (${list.ip})</td>
			<td bgcolor="#ecdafd">작성일자 : <fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td>비밀번호 : 
			<input type="text" name="inputPwd_${list.idx}" onChange="check(this, '${list.pwd}')"/>
			<input type="button" value="수정" onClick="mod(${list.idx}, '${list.pwd}')"/>
			<input type="button" value="삭제" onClick="del(${list.idx}, '${list.pwd}')"/>
			</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>
