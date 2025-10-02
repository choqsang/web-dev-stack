<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="/visit/resources/css/visit.css">
<script src="/visit/resources/js/httpRequest.js"></script>	
<script>
	/* 크롬 브라우저에서 f12 >> f1 >> Debugger의 Disable JavaScript 체크 시 스크립트 동작 불가 (도구 켜져 있는 상태에서만) */
	
	function del(f){
		let pwd = f.pwd.value;
		let c_pwd = f.c_pwd.value;
		
		if( pwd != c_pwd ){
			alert("패스워드 불일치");
			return;
		}

		if(!confirm("정말루?")){
			return;
		}
		
		let url = "visit_del.do";
		let param = "idx=" + f.idx.value;
		sendRequest( url, param, resultFn, "post");
	}
		
	function resultFn(){
		if( xhr.readyState == 4 && xhr.status == 200 ){
			let data = xhr.responseText;
			
			if(data == "no"){
				alert("삭제 실패");
				return;
			} else {
				alert("삭제 성공");
				location.href="list.do";
			}
		}
	}
		
	function mod(f){
		let pwd = f.pwd.value;
		let c_pwd = f.c_pwd.value;
		
		if( pwd != c_pwd ){
			alert("패스워드 불일치");
			return;
		}
		
		f.method= "post";
		f.action= "modify_form.do?idx=" + f.idx.value;
		f.submit();
	}
	
</script>
</head>

<body>
	
	<h1>::: 방명록 리스트 :::</h1>
		<div align="center">
		<input type="button" value="글쓰기" onClick="location.href='regi_form.do'">
		</div>
	<div id="main_box">
		<c:forEach var="vo" items="${list}">
		
			<div class="visit_box">
				<div class="type_content"><pre>${vo.content}</pre></div>
				<div class="type_name">작성자 : ${vo.name} (${vo.ip})</div>
				<div class="type_regdate">작성일자 : <fmt:formatDate value="${vo.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
				<div class="type_photo">제목 : ${vo.title}</div>
				<div>
					<img src="resources/upload/${vo.filename}" width="300px" onerror="this.style.display='none';"/>
				</div>
				<div>
					<form>
						<input type="hidden" name="idx" value="${vo.idx}">
						<input type="hidden" name="pwd" value="${vo.pwd}">
						비밀번호 : <input type="password" name="c_pwd">
						<input type="button" value="수정" onClick="mod(this.form)"/>
						<input type="button" value="삭제" onClick="del(this.form)"/>
					</form>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>
