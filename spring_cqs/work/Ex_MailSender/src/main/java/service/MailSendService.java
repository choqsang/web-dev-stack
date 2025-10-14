package service;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailSendService {
	
	private JavaMailSender javaMailSender;
	private int authNumber = 0; // 인증번호(난수) 세팅을 위한 변수 설정
	
	// 기본 생성자
	public MailSendService(JavaMailSender javaMailSender) { // 반드시 파라미터로 메일센더를 받아와야 함
		this.javaMailSender = javaMailSender; // 메모리 할당
	}
	
	// 랜덤으로 인증번호 생성
	public void makeRandomNumber() {
		Random rnd = new Random();
		// 난수 범위 : 111111 ~ 999999
		// 공식 : (큰 수 - 작은 수 + 1) + 작은 수;
		int checkNum = rnd.nextInt( 999999 - 111111 + 1 ) + 111111;
		System.out.println("인증번호 : " + checkNum);
		
		authNumber = checkNum;
	}
	
	// 이메일을 전달할 양식
	public String joinEmail(String email) { // 파라미터로 보내고 싶은 메일 주소 입력받음
		
		makeRandomNumber();
		String setFrom = "chks1@naver.com"; // 발신자 주소
		String toMail = email; // 수신자의 이메일 주소
		String title = "회원 가입 인증 이메일 입니다"; // 이메일 제목 설정
		
		String content = "인증번호는 <b>" + authNumber + "</b>입니다"; // 인증번호 전송 내용 (b태그 활용하여 강조)
		
		try {
			MimeMessage mail = javaMailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
			
			mailHelper.setFrom(setFrom);
			mailHelper.setTo(toMail);
			mailHelper.setSubject(title);
			mailHelper.setText(content, true); // 내용에 태그가 포함될 경우, 인식되게끔 동작하려면 true가 포함되어야 한다
			
			javaMailSender.send(mail);
			
		} catch (Exception e) {
			
		}
		
		return String.valueOf(authNumber); // "" + authNumber; 보다는 값을 문자열 형태로 변환하여 리턴
	}
}
