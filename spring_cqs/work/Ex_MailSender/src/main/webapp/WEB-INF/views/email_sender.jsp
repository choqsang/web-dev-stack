<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script src="/mail/resources/js/httpRequest.js"></script>
		<script>
			function mailCheck(f){
				let userEmail = f.userEmail.value;
				let url = "mailCheck.do";
				let param = "email=" + userEmail;
				sendRequest( url, param, resultMail, "post" );
			}
			
			let res; // 콜백으로 받는 데이터 활용을 위해 변수 생성
			function resultMail(){
				if(xhr.readyState == 4 && xhr.status == 200){
					let data = xhr.responseText;
					// alert(data); // 넘어오는 값 확인 (인증번호)
					alert("인증코드가 이메일로 전송되었습니다");
					
					let check_input = document.getElementById("check_input");
					check_input.disabled = false;
					
					res = data; // 인증번호를 res에 저장
				}
			}
			
			function change_input(){
				let check_input = document.getElementById("check_input");
				let mail_check_warn = document.getElementById("mail_check_warn");
				
				if( check_input.value == res ){
					mail_check_warn.innerHTML = "인증 성공";
					// location.href="main_content.do";
				} else {
					mail_check_warn.innerHTML = "인증번호 불일치";
				}
			}
		</script>
		<link rel="stylesheet" href="/mail/resources/css/email.css" />
<style>

* { margin: 0; padding: 0; box-sizing: border-box; } 

body {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background-color: azure; 
}

.auth_box {
    background-color: white;
    border-radius: 10px;
    padding: 30px;
    width: 50%; 
    text-align: center;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); 
}

.auth_box h3 {
    margin-bottom: 10px;
    color: cadetblue;
    font-size: 1.5rem;
}

input {
    width: 100%; 
    height: 30px; 
    margin: 5px 0;
    padding: 0 15px;
    border: 1px solid #aaa;
    border-radius: 5px;
    outline: none;
    font-size: 0.9rem;
}

#btn_send, #btn_check {
    color: white;
    font-weight: bold;
    cursor: pointer;
    background-color: cadetblue;
    border: none;
}

#btn_send:hover, #btn_check:hover {
    background-color: #5799a2;
}

.check_group {
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 90%;
    margin: 10px auto;
}

.check_group #check_input {
    width: 65%; 
    margin: 0;
}

.check_group #btn_check {
    width: 30%; 
    margin: 0;
}

#mail_check_warn {
    height: 15px;
    font-size: 14px;
    font-weight: bold;
    color: cadetblue; 
    margin-top: 5px;
    min-height: 20px;
}
</style>
	</head>
	
	<body>
		<div class="auth_box">
		<form>
			<h3>이메일 인증</h3>
			<input id="email_input" name="userEmail" placeholder="이메일 주소를 입력하세요" />
			<input id="btn_send" type="button" value="인증번호 발송" onclick="mailCheck(this.form)"/> <br>
			
			<div class="check_group">
				<input id="check_input" placeholder="인증번호 6자리 입력" maxlength="6" disabled="disabled"/>
				<input id="btn_check" type="button" value="인증번호 확인" onclick="change_input()" />
            </div>
			<div id="mail_check_warn"></div>
		</form>
		</div>
	
	</body>
</html>