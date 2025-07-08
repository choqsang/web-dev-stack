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
import java.util.List;

import dao.MemberDAO;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		boolean check = true;

			try {
				// DB 정보 필요 -> DAO
				MemberDAO dao = new MemberDAO();
				Member member = dao.showSearch(id);
				
				// 바인딩 -> 이 정보가 필요한 지
				request.setAttribute("member", member);
				
				// 네비게이션 -> search.jsp
				request.getRequestDispatcher("views/result.jsp").forward(request, response);
			} catch (SQLException e) {
				check = false;
			}
		
	}

}
