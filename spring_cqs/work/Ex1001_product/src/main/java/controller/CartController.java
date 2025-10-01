package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.CartDAO;
import vo.CartVO;

@Controller
public class CartController {

	CartDAO cart_dao;
	
	public CartController(CartDAO cart_dao) {
		this.cart_dao = cart_dao;
	}
	
	
	/*
	 * @WebServlet("/cart_list.do") public class CartListAct extends HttpServlet {
	 * private static final long serialVersionUID = 1L;
	 * 
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // cart_list.do?m_idx=1 int
	 * m_idx = Integer.parseInt(request.getParameter("m_idx"));
	 * 
	 * List<CartVO> list = CartDAO.getInstance().select(m_idx); int total =
	 * CartDAO.getInstance().selectTotalAmount(m_idx);
	 * 
	 * // binding request.setAttribute("list", list); request.setAttribute("total",
	 * total);
	 * 
	 * // forwarding RequestDispatcher disp =
	 * request.getRequestDispatcher("cart_list.jsp"); disp.forward(request,
	 * response);
	 * 
	 * 
	 * }
	 * 
	 * @WebServlet("/cart_insert.do") public class CartInsAct extends HttpServlet {
	 * private static final long serialVersionUID = 1L;
	 * 
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // 상품번호 int idx =
	 * Integer.parseInt( request.getParameter("idx"));
	 * 
	 * // 회원번호 int m_idx = Integer.parseInt( request.getParameter("m_idx"));
	 * 
	 * // 중복상품인지 조회 CartVO vo = new CartVO(); vo.setIdx(idx); vo.setM_idx(m_idx);
	 * 
	 * CartVO res = CartDAO.getInstance().selectOne(vo);
	 * 
	 * String result = "no"; // 기본값은 불가하나 if(res == null) { // 조회되지 않을 경우 장바구니에 등록
	 * 가능 result = "yes"; // 상품을 장바구니에 등록 CartDAO.getInstance().insert(vo); }
	 * 
	 * String resStr = String.format("[{'result':'%s'}]", result);
	 * response.getWriter().println(resStr); }
	 */
		
	
}
