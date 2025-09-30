package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDAO;
import util.PwdBcrypt;
import vo.MemberVO;

@Controller
public class LoginController {
	
	MemberDAO member_dao;
	// set 자동완성으로 setter 생성자
	public void setMember_dao(MemberDAO member_dao) {
		this.member_dao = member_dao;
	}

	// 첫 페이지로 지정하는 경우 (경로 없음 또는 login.do에서 실행 / 동일한 주소 매핑 불가)
	@RequestMapping(value={"/", "login.do"})
	public String loginForm() {
		return "login/login_form";
	}
	
	// check_login.do?id=a&pwd=11
	@RequestMapping("/check_login.do")
	@ResponseBody
	// 리턴된 데이터를 콜백으로 보낸다
	
	public String login(MemberVO vo, HttpSession session) {
		MemberVO baseVO = member_dao.selectIdCheck( vo.getId() );
		String result = "";
		
		// 로그인 시도 id가 없거나 잘못 입력된 경우
		if(baseVO == null) {
			result = "no_id";
			String resultStr = String.format("[{'res':'%s'}]", result);
			return resultStr;
		}
		// id가 있는 경우
		PwdBcrypt pbc = new PwdBcrypt();
		boolean isValid = pbc.validPwd(vo.getPwd(), baseVO.getPwd());
		
		if( !isValid ) { // 비밀번호가 잘못 되었을 경우
			result = "no_pwd";
			String resultStr = String.format("[{'res':'%s'}]", result);
			return resultStr;
		}
		// 로그인 성공 시 (모두 일치)
		result = "clear";
		String resultStr = String.format("[{'res':'%s'}]", result);
		session.setAttribute("login_name", vo.getName());
		return resultStr;		
	}
}
