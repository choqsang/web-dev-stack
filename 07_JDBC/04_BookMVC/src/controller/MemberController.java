package controller;

import java.sql.SQLException;

import dao.MemberDAO;
import vo.Member;

public class MemberController {
	
	private MemberDAO dao = MemberDAO.getInstance();

	// 4. 회원가입
	public String register(Member member) {
		try {
			dao.register(member);
			return member.getName() + "님이 회원가입하셨습니다!";
		} catch (Exception e) {
			return "중복된 회원 아이디가 있어 다른 아이디로 가입해주세요.";
		}
		// id가 primary-key라서 에러가 발생함! 활용하기
		
	}
	
	// 5. 로그인
	public Member login(String id, String pwd) {
		try {
			return dao.login(id, pwd);
		} catch (SQLException e) {
			return null;
		}
	}
	
	// 6. 회원탈퇴
	public void delete(String id) {
		
		// 회원 탈퇴 시 대여 중인 책을 모두 기록 삭제
		
		
	}
	
}
