package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import vo.CartVO;

@WebServlet("/cart_list.do")
public class CartListAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// cart_list.do?m_idx=1
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		
		List<CartVO> list = CartDAO.getInstance().select(m_idx); 
		int total = CartDAO.getInstance().selectTotalAmount(m_idx);
		
		// binding
		request.setAttribute("list", list);
		request.setAttribute("total", total);
		
		// forwarding
		RequestDispatcher disp = request.getRequestDispatcher("cart_list.jsp");
		disp.forward(request, response);
		
		
	}

}
