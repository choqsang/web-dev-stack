package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.ProductDAO;
import vo.ProductVO;

@Controller
public class ProductController {

	ProductDAO product_dao;
	
	public ProductController(ProductDAO product_dao) {
		this.product_dao = product_dao;
	}
	
	@RequestMapping(value={"/", "/list.do"})
	public String list(Model model) {
		List<ProductVO> list = product_dao.selectList();
		model.addAttribute("list", list);
		return "product_list";
	}
	
	
	/*
	 * @WebServlet("/view.do") public class ProductDetailAct extends HttpServlet {
	 * private static final long serialVersionUID = 1L;
	 * 
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { int idx =
	 * Integer.parseInt(request.getParameter("idx"));
	 * 
	 * ProductVO vo = ProductDAO.getInstance().selectOne(idx);
	 * 
	 * // 바인딩 request.setAttribute("vo", vo);
	 * 
	 * // 포워딩 RequestDispatcher disp =
	 * request.getRequestDispatcher("product_detail.jsp"); disp.forward(request,
	 * response); }
	 * 
	 * }
	 * 
	 * @WebServlet("/insert.do") public class ProductInsAct extends HttpServlet {
	 * private static final long serialVersionUID = 1L;
	 * 
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * // 저장위치 String web_path = "/images/"; ServletContext app =
	 * request.getServletContext(); String path = app.getRealPath(web_path);
	 * System.out.println("절대경로: " + path);
	 * 
	 * // 최대 업로드 용량 int max_size = 1024 * 1024 * 100;
	 * 
	 * MultipartRequest mr = new MultipartRequest(request, path, max_size, "utf-8",
	 * new DefaultFileRenamePolicy());
	 * 
	 * // 업로드 된 파일 정보 얻어오기 String p_image_s = "no_file"; String p_image_l =
	 * "no_file";
	 * 
	 * File f = mr.getFile("p_image_s");
	 * 
	 * if(f != null) { p_image_s = f.getName(); // 업로드 된 파일의 실제 파일명 }
	 * 
	 * f = mr.getFile("p_image_l"); if(f != null) { p_image_l = f.getName(); }
	 * 
	 * // 파일 이외의 나머지 파라미터들 수신 String category = mr.getParameter("category"); String
	 * p_num = mr.getParameter("p_num"); String p_name = mr.getParameter("p_name");
	 * String p_company = mr.getParameter("p_company"); String p_content =
	 * mr.getParameter("p_content"); int p_price =
	 * Integer.parseInt(mr.getParameter("p_price")); int p_saleprice =
	 * Integer.parseInt(mr.getParameter("p_saleprice"));
	 * 
	 * ProductVO vo = new ProductVO(); vo.setCategory(category); vo.setP_num(p_num);
	 * vo.setP_name(p_name); vo.setP_company(p_company); vo.setP_price(p_price);
	 * vo.setP_saleprice(p_saleprice); vo.setP_content(p_content);
	 * vo.setP_image_s(p_image_s); vo.setP_image_l(p_image_l);
	 * 
	 * // 상품정보를 db로 보내자 ProductDAO.getInstance().insert(vo);
	 * 
	 * response.sendRedirect("list.do?category=" + category);
	 * 
	 * }
	 * 
	 * @WebServlet("/list.do") public class ProductListAct extends HttpServlet {
	 * private static final long serialVersionUID = 1L;
	 * 
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * //list.do?category=value String category = request.getParameter("category");
	 * 
	 * // list.do <-- null // list.do?category= < -- empty // null: 할당 자체가 안 됨,
	 * isEmpty: 할당 되어도 내용이 없음 if(category == null || category.isEmpty()) { category
	 * = "com001"; }
	 * 
	 * // 카테고리별 목록 조회 List<ProductVO> list =
	 * ProductDAO.getInstance().select(category);
	 * 
	 * // 바인딩 request.setAttribute("list", list);
	 * 
	 * // 포워딩 RequestDispatcher disp =
	 * request.getRequestDispatcher("product_list.jsp"); disp.forward(request,
	 * response);
	 * 
	 * }
	 * 
	 * @WebServlet("/product_update") public class ProductUpdAct extends HttpServlet
	 * { private static final long serialVersionUID = 1L;
	 * 
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * int idx = Integer.parseInt(request.getParameter("idx"));
	 * 
	 * 
	 * 
	 * }
	 */
	
	
	
	
}
