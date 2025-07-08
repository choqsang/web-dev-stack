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
		// request.setAttribute("name", name);
		request.setAttribute("check", check);
		
		// 4. 내비게이션 : 결과 페이지 지정
		// 회원가입 성공할 때와 실패할 때 페이지 구분하는 것
		// result.jsp에서 조건을 걸 경우, 결과페이지는 하나로 다시 합치기(if문 옮기기)
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
		// 현재 : 조건 무관하게 성공 결과페이지로 이동하게끔 설정됨
		// check가 true인 경우는 회원가입 성공 페이지로 이동
		// false인 경우는 회원가입 실패 페이지로 이동 (fail.jsp)
//		if (check) {
//			// response.sendRedirect("result.jsp");
//			// 만약 결과 페이지로 서버에서 받은 값을 보여주려면 단순히 sendRedirect를 통해 jsp파일로 이동할 순 없다!
//			// -> RequestDispatcher forward 방식으로 보내야 함!
//			request.getRequestDispatcher("result.jsp").forward(request, response);
//		} else {
//			response.sendRedirect("fail.jsp");
//		}
		
		
	}

}
