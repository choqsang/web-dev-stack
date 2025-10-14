package com.kh.mail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.MailSendService;

@Controller
public class EmailController {

	MailSendService mss;
	// setter 혹은 생성자
	public EmailController( MailSendService mss ) {
		this.mss = mss;
	}
	
	@RequestMapping(value={"/", "start.do"})
	public String start() {
		return "email_sender"; // 초기 페이지로 포워딩
	}
	
	@RequestMapping("/mailCheck.do")
	@ResponseBody // ajax로 받을 경우 어노테이션 필요
	public String mailCheck(String email) {
		String res = mss.joinEmail(email); // 메서드 실행 후 res에 담기는 값 확인
		return res;
	}
}
