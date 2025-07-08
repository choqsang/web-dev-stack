package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.MemberDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberDAO dao = new MemberDAO();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 1. (있으면) 폼 값 받아온다.
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
	
		boolean check = true;
		
		// 2. DAO 호출 - DB 접근 필요 시
		MemberDAO dao = new MemberDAO();
		try {
			dao.register(new Member(id, name, pwd, age));
		} catch (SQLException e) {
			check = false;
		}
		
		// 3. 바인딩 : 결과 페이지에 서버에서 받은 값 보내야 할 때
		 request.setAttribute("check", check);
		
		 PrintWriter out = response.getWriter();
		 
		if (check) {
			out.println("<h3>회원가입 성공!</h3>");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			out.println("<h3>해당 정보로는 신규가입이 불가합니다.</h3>");
			response.sendRedirect("index.jsp");
		}
		
		
	}

}
