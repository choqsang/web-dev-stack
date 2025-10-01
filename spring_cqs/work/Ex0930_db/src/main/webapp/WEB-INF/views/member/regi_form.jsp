<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<script>

function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 검색 결과 항목을 클릭했을 때 실행할 코드
            
            // 우편번호와 기본 주소를 추출
            var fullAddr = ''; // 최종 주소 변수
            var extraAddr = ''; // 참고항목 변수

            // (1) 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 도로명 주소를 선택했을 경우
                fullAddr = data.roadAddress;
            } else { // 지번 주소를 선택했을 경우(J)
                fullAddr = data.jibunAddress;
            }

            // (2) 건물명이 있을 경우 참고항목에 추가한다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraAddr += data.bname;
            }
            // (3) 공동주택(아파트, 빌라 등)일 경우
            if(data.buildingName !== '' && data.apartment === 'Y'){
                extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // (4) 참고항목 문자열이 있는 경우 괄호로 묶어 최종 주소에 추가
            if(extraAddr !== ''){
                fullAddr += ' (' + extraAddr + ')';
            }

            // (5) 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode; // 5자리 새 우편번호
            document.getElementById('address').value = fullAddr;
        }
    }).open(); // 팝업 창 열기
}

	function send(f) {
		// 유효성 체크 생략
		// f.name.value == null
		f.action="member_insert.do";
		f.method="post";
		f.submit();
	}
</script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

</head>
<body>
	<h1>멤버 등록</h1>
	
	<form>
	<table border="1">
			<tr>
			<th>이름</th>
			<td><input name="name"></td>
			</tr>
			
			<tr>
			<th>아이디</th>
			<td><input name="id"></td>
			</tr>
			
			<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pwd"></td>
			</tr>
			
			<tr>
			<th>이메일</th>
			<td><input name="email"></td>
			</tr>
			
			<tr>
			<th>주소</th>
			<td>
				<input size="5" type="text" id="postcode" placeholder="우편번호">
				<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
				<input id="address" name="addr">
			</td>
			</tr>
			
			<tr>
			<td colspan="2">
			<input type="button" value="등록" onClick="send(this.form)"/>
			<input type="button" value="취소" onClick="history.back()"/>
												<!-- history.go(-1) -->
			</td>
			<tr>
		
	</table>
	</form>
	
</body>
</html>