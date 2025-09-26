package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import vo.ProductVO;

@WebServlet("/list.do")
public class ProductListAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//list.do?category=value
		String category = request.getParameter("category");
		
		// list.do <-- null
		// list.do?category= < -- empty
		// null: 할당 자체가 안 됨, isEmpty: 할당 되어도 내용이 없음
		if(category == null || category.isEmpty()) {
			category = "com001";
		}
		
		// 카테고리별 목록 조회
		List<ProductVO> list = ProductDAO.getInstance().select(category);
		
		// 바인딩
		request.setAttribute("list", list);
		
		// 포워딩
		RequestDispatcher disp = request.getRequestDispatcher("product_list.jsp");
		disp.forward(request, response);
		
	}

}
