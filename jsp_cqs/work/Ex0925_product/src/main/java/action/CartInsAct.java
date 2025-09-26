package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import vo.CartVO;

@WebServlet("/cart_insert.do")
public class CartInsAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상품번호
		int idx = Integer.parseInt( request.getParameter("idx"));
		
		// 회원번호
		int m_idx = Integer.parseInt( request.getParameter("m_idx"));
		
		// 중복상품인지 조회
		CartVO vo = new CartVO();
		vo.setIdx(idx);
		vo.setM_idx(m_idx);
		
		CartVO res = CartDAO.getInstance().selectOne(vo);
		
		String result = "no"; // 기본값은 불가하나
		if(res == null) { // 조회되지 않을 경우 장바구니에 등록 가능
			result = "yes";
			// 상품을 장바구니에 등록
			CartDAO.getInstance().insert(vo);
		}
		
		String resStr = String.format("[{'result':'%s'}]", result);
		response.getWriter().println(resStr);
	}

}
