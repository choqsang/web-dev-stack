package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SjDAO;

/**
 * Servlet implementation class SungDelAct
 */
@WebServlet("/sj_del.do")
public class SungDelAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// sj_del.do?no=5
		int no = Integer.parseInt(request.getParameter("no")); // DAO에게 보내야한다		
		SjDAO.getInstance().delete(no);
		response.sendRedirect("list.do");
	}

}
