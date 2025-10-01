package util;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PwdBcrypt {
	
	// 암호화
	public String encodingPwd( String pwd ) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPwd = encoder.encode(pwd); // pwd: 암호화 전 비밀번호, encodedPwd: 암호화된 비밀번호
		
		// 암호화된 비밀번호를 반환한다
		return encodedPwd;
	}
	
	// 복호화(= 비밀번호 체크)
	public boolean validPwd( String inputPw, String oriPw ) {
		// inputPw: 입력받은 비밀번호, oriPw: 암호화된 비밀번호
		
		boolean isValid = false;
		// checkpw() 앞: 입력값, 뒤: 암호화된 값 => 순서대로 넣어 비교하여 참-거짓 출력
		isValid = BCrypt.checkpw(inputPw, oriPw); 
		
		return isValid;
	}
	
}
