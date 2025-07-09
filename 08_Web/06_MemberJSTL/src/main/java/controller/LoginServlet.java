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
import java.util.ArrayList;

import dao.MemberDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	boolean check = true;
	Member member = new Member();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDAO dao = new MemberDAO();
		
		try {
			Member member = dao.login(id, pwd);
			//if(member.getId().equals(id) && member.getPwd().equals(pwd)){		
			// request.getRequestDispatcher("/index.jsp").forward(request, response);
	
			// Session - 바인딩
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			
			response.sendRedirect("/");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
