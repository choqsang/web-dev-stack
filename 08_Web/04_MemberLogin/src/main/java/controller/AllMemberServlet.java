package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.MemberDAO;

@WebServlet("/allMember")
public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

			try {
				// DB 정보 필요 -> DAO
				MemberDAO dao = new MemberDAO();
				ArrayList<Member> list = dao.showAll();
				
				// 바인딩 -> 이 정보가 필요한 지
				request.setAttribute("list", list);
				
				// 네비게이션 -> view.jsp
				request.getRequestDispatcher("views/allMember.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
