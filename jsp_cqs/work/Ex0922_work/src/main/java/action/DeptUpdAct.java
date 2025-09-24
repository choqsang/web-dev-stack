package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDAO;
import vo.DeptVO;

@WebServlet("/update_dept")
public class DeptUpdAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// update_dept?deptno=10
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
		DeptVO vo = DeptDAO.getInstance().updateDept(deptno);

		request.setAttribute("vo", vo);
		
		RequestDispatcher disp = request.getRequestDispatcher("update_form.jsp");
		disp.forward(request, response);
		
	}

}
