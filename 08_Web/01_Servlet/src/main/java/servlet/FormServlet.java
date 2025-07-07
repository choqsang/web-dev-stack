package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userId = request.getParameter("userId");
		System.out.println(userId);
		String userPwd = request.getParameter("userPwd");
		System.out.println(userPwd);
		String gender = request.getParameter("gender");
		System.out.println(gender);
//		String m = request.getParameter("menu");
//		System.out.println(m);
		String[] menu = request.getParameterValues("menu");
		System.out.println(menu);

		gender = gender.equals("M") ? "남자" : "여자";
		
		// 요청으로 받은 keyword값 그대로 브라우저상에 나타나도록! h2 태그 사용!
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>아이디 : " + userId + "</h2>");
		out.println("<h2>비밀번호 : " + userPwd + "</h2>");
		out.println("<h2>성별 : " + gender + "</h2>");
//		out.println("<h2>좋아하는 메뉴 : " + Arrays.toString(menu) + "</h2>");
		out.println("<h2>좋아하는 메뉴 : " + String.join(", ", menu) + "</h2>");
		out.println("<h3>좋아하는 메뉴</h3>");
		out.println("<ul>");
		if(menu!=null) {
			for(String m : menu) {
				out.println("<li>" + m + "</li>");
		}
			out.println("</ul>");	
		}
		out.println("</body></html>");
		out.close();
	}	

}
