package controller.component;

import java.sql.SQLException;

import controller.Controller;
import controller.ModelAndView;
import dao.MemberDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vo.Member;

/*
 * 컴포넌트
 * - 인터페이스 기반으로 작성된 재사용성이 강한 자바 클래스
 * */

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberDAO dao = new MemberDAO();
		Member member = dao.login(id, pwd);

		HttpSession session = request.getSession();
		session.setAttribute("member", member);

		return new ModelAndView("index.jsp", true); // (path, redirect여부)
	}

}
