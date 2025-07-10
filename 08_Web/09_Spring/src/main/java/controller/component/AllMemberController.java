package controller.component;

import java.util.List;

import controller.Controller;
import controller.ModelAndView;
import dao.MemberDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

/*
 * 컴포넌트
 * - 인터페이스 기반으로 작성된 재사용성이 강한 자바 클래스
 * */

public class AllMemberController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDAO dao = new MemberDAO();
		List<Member> list = dao.showAll();
		
		request.setAttribute("list", list);
		
		return new ModelAndView("/views/allMember.jsp");
	}

}
