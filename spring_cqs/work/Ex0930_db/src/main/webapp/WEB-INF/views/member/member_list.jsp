<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="/member/resources/js/httpRequest.js"></script>
<script>
	function modify(idx){
		location.href="modify.do?idx=" + idx;
	}
	
	function del(idx){
		if(!confirm("정말 삭제하시겠습니까?")){
			return;
	//	} else {
	//		location.href="del.do?idx=" + idx;
	//	}
	}
		let url = "del.do";
		let param = "idx=" + idx;
		sendRequest(url, param, deleteFn, "post");
	}
	
	function deleteFn(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let data = xhr.responseText;
			if(data == "no"){
				alert("삭제 실패")
			} else {
				alert("삭제 성공")
				location.href="list.do";
			}
		}
	}
</script>

<style>
	.member-table tr td:nth-child(3) {
		max-width: 300px;
		overflow: hidden;
	}
</style>

</head>
<body>
	 
	<!-- <h1>${sessionScope.login_name}님, 안녕하세요!</h1> -->
	<h1>멤버 목록</h1>
	
	<table border="1" class="member-table">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>주소</th>
			<th>비고</th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.name}</td>
				<td>${list.id}</td>
				<td>${list.pwd}</td>
				<td>${list.email}</td>
				<td>${list.addr}</td>
				<td>
				<input type="button" value="수정" onClick="modify(${list.idx})">
				<input type="button" value="삭제" onClick="del(${list.idx})">
				</td>
			</tr>
		</c:forEach>	
			<tr>
				<td colspan="6">
					<input type="button" value="등록" onClick="location.href='regi_form.do'">
				</td>
			</tr>
	</table>
</body>
</html>