package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vo.Member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.MemberDAO;

@WebServlet("/front")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * Controller에서 Servlet을 하나로 만들자! Front Controller Pattern
	 * 
	 * 소프트웨어 디자인 패턴 중 하나로 웹 애플리케이션 등에서 사용되는 패턴 중 하나
	 * 애플리케이션의 진입점을 중앙집중화하여 요청을 처리하고, 전체적인 흐름을 제어하는 역할
	 * 
	 * - DispatcherServlet은 자바 기반의 웹 애플리케이션에서 FrontControllerPattern을 구현하는 데 사용되는 핵심 컴포넌트
	 * - SpringFramework와 관련된 개념으로 많이 사용되는데 SpringMVC의 일부로 동작하며 
	 *	 웹 요청을 받아서 적절한 핸들러(컨트롤러)로 라우팅하고, 해당 컨트롤러의 실행 및 응답 생성 등을 관리
	 * */
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청이 어디에서 들어온 요청인 지 값을 하나 더 받음 - command
		String command = request.getParameter("command");
		String path = "/";
		
		try {
			if (command.equals("login")) {
				path = login(request, response);
			}
			else if(command.equals("register")) {
				path = register(request, response);
			}
			 else if(command.equals("logout")) {
				path = logout(request, response);
			 }
			else if(command.equals("allMember")) {
				path = allMember(request, response);
			}
			else if(command.equals("search")) {
				path = search(request, response);
			}
			request.getRequestDispatcher(path).forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected String login(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberDAO dao = new MemberDAO();
		Member member = dao.login(id, pwd);

		HttpSession session = request.getSession();
		session.setAttribute("member", member);

		return "index.jsp";
	}
	
	protected String register(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
	
		boolean check = true;
		MemberDAO dao = new MemberDAO();
		
		try {
			dao.register(new Member(id, name, pwd, age));
		} catch (SQLException e) {
			check = false;
		}
		 request.setAttribute("check", check);
		 
		 return "index.jsp";
	}
	
	protected String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		
		if(member!=null) {
			session.invalidate();
		}
		return "/";
	}
	
	protected String allMember(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
			MemberDAO dao = new MemberDAO();
			List<Member> list = dao.showAll();
			
			request.setAttribute("list", list);
			
			return "/views/allMember.jsp";
	}
	
	protected String search(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String id = request.getParameter("id");

				MemberDAO dao = new MemberDAO();
				Member member = dao.showSearch(id);
				List<Member> list = dao.showAll();
				
				request.setAttribute("list", list);
				request.setAttribute("member", member);
				
				return "/views/result.jsp";
	}
	
	
	
	
}	