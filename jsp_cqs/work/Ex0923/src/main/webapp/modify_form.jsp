<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script src="js/httpRequest.js" ></script>
		<script>
		// 아이디 중복여부 체크
		let b_idCheck = false;
		
			function modify(f){
				let name = f.name.value;
				let id = f.id.value;
				let pwd = f.pwd.value;
				let email = f.email.value;
				let addr = f.addr.value;
				
				if( name == '' ){
					alert('이름을 입력하지 않았습니다');
					return;
				}
				
				if( id == '' ){
					alert('아이디를 입력하지 않았습니다');
					return;
				}
				
				if( pwd == '' ){
					alert('비밀번호를 입력하지 않았습니다');
					return;
				}
				
				if( email == '' ){
					alert('이메일을 입력하지 않았습니다');
					return;
				}
				
				if( addr == '' ){
					alert('주소를 입력하지 않았습니다');
					return;
				}
				// 아이디 중복체크 여부 확인
				if(!b_idCheck){ // false일 때, (= 중복이거나 아직 체크하지 않았을 경우)
					alert("아이디 중복체크를 해주세요")
					return; // 다시 처음으로 되돌아간다
				}
				
				f.action = 'member_modify_fin';
				f.method = 'post';
				f.submit();
			}
			
			// 중복체크 버튼 클릭
			function check_id(){
				let id = document.getElementById("id").value.trim(); // id가 id에 해당하는 값을 찾아온다 (+ 공백제거)
				if( id == "" ){
					alert("아이디를 입력해주세요");
					return; // 비동기처리하지 않으면 계속 유효성 검사를 하게 된다 
				}
				
				let url = "check_id.do"; // 보낼 주소
				let param = "id=" + id; // 파라미터 이름 + 값
				sendRequest( url, param, resFn, "post" );
				// 콜백 메서드 (url, param을 보내어 특정 작업을 진행하였을 때 처리 결과를 담아올 함수), 전송 방식 (get이어도 눈에는 보이지 않음)
				
			}
			
			function resFn(){ // 콜백 메서드
				// alert("callback");
				// httpRequest에 포함된 변수 xhr을 이용
				
				// xhr.readyState
				// 0 : 초기화
				// 1~3 : 로딩중
				// 4 : 로드 완료
				
				// xhr.status
				// 200 : 이상 없음
				// 404, 500 : 페이지 에러, DB 오류 등 문제 상황 발생 시
				
				if(xhr.readyState == 4 && xhr.status == 200){
					// data = 서블릿에서 보내준 json 구조가 문자열 형태로 넘어온다
					// "[{result:yes, id:three}]"
					let data = xhr.responseText;
					let json = eval(data); // 실제 json 배열 구조로 변환
					
					if(json[0].result == "no"){
						alert(json[0].id + "는 이미 사용중입니다");
						return;
					} else {
						alert(json[0].id + "는 사용 가능합니다");
						b_idCheck = true;
					}
				} 
			}
			
			function che(){ // id 인풋값에 변동이 있을 경우 호출
				b_idCheck = false;
			}
		</script>
	</head>
	
	<body>
		회원 정보 수정
		<form>
			<input type="hidden" name="idx" value="${vo.idx}" />
			<table border="1">
				<tr>
					<td>이름</td>
					<td><input name="name" value="${vo.name}" placeholder="이름을 입력하세요" /></td>
				</tr>
				
				<tr>
					<td>아이디</td>
					<td><input id="id" name="id" value="${vo.id}" placeholder="아이디를 입력하세요" onInput="che()"/>
					<input type="button" value="중복체크" onClick="check_id()"></td>
				</tr>
				
				<tr>
					<td>비밀번호</td>
					<td><input type="password"  name="pwd" value="${vo.pwd}" placeholder="비밀번호를 입력하세요" /></td>
				</tr>
				
				<tr>
					<td>이메일</td>
					<td><input name="email" value="${vo.email}" placeholder="이메일을 입력하세요" /></td>
				</tr>
				
				<tr>
					<td>주소</td>
					<td><input name="addr" value="${vo.addr}" placeholder="주소를 입력하세요"  /></td>
				</tr>
				
				<tr>
					<td colspan="2">
						<input type="button" value="수정"
							   onclick="modify(this.form)" />
						<input type="button" value="뒤로"
							   onclick="history.back()" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>