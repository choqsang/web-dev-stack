package com.kh.pro;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import dao.ProductDAO;
import vo.ProductVO;

//스프링의 컨트롤러는 jsp의 servlet과 같은 역할을 담당한다
@Controller
public class ProductController { 
	
	@Autowired
	HttpServletRequest request;	// 요청처리 객체
	@Autowired
	ServletContext app; // 프로젝트의 정보를 가지는 객체
	@Autowired
	SqlSession sqlSession; 	// SQL 세션
	@Autowired
	HttpSession httpSession; // HTTP 세션
	
	ProductDAO product_dao;
	public void setProduct_dao(ProductDAO product_dao) {
		this.product_dao = product_dao;
	}
	
	// 메인 화면 (리스트)
	@RequestMapping(value={"/", "/list.do"})
	public String list(Model model, String category) {
	
		// list.do <-- null
		// list.do?category= < -- empty
		// null: 할당 자체가 안 됨, isEmpty: 할당 되어도 내용이 없음
		if(category == null || category.isEmpty()) {
			category = "com001";
		}
		// 카테고리별 목록 조회
		List<ProductVO> list = product_dao.select(category);
		// 바인딩
		model.addAttribute("list", list);
		// 포워딩
		return "product/product_list";
	}
	
	// 등록 페이지로 이동
	@RequestMapping("/product_regi_form.do")
	public String regi_form() {
		return "product/product_regi_form";
	}
	
	// 새 글 등록
	@RequestMapping("/insert.do")
	public String insert(ProductVO vo) {
		
		// 저장위치 
		String web_path = "/resources/images/";
		String path = app.getRealPath(web_path);
		System.out.println("절대경로: " + path);
		
		// 업로드 된 파일정보 가져오기 (작은 이미지)
		MultipartFile photo1 = vo.getPhoto1();
		String filename1 = "no_file";
		
		if(!photo1.isEmpty()) {
			filename1 = photo1.getOriginalFilename();
			File saveFile = new File(path, filename1);
			
			if(!saveFile.exists()) {
				saveFile.mkdirs();
			} else {
				long time = System.currentTimeMillis();
				filename1 = String.format("%d_%s", time, filename1);
				saveFile = new File(path, filename1);
			}
			
			try {
				photo1.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 업로드 된 파일정보 가져오기 (큰 이미지)
		MultipartFile photo2 = vo.getPhoto2();
		String filename2 = "no_file";
		
		if(!photo2.isEmpty()) {
			filename2 = photo2.getOriginalFilename();
			File saveFile = new File(path, filename2);
			
			if(!saveFile.exists()) {
				saveFile.mkdirs();
			} else {
				long time = System.currentTimeMillis();
				filename2 = String.format("%d_%s", time, filename2);
				saveFile = new File(path, filename2);
			}
			
			try {
				photo2.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 사진 정보를 vo에 저장
		vo.setP_image_s(filename1);
		vo.setP_image_l(filename2);
		
		// 상품정보를 DB로 보내자
		product_dao.insert(vo);
		return "redirect:/list.do";
	}
	
	@RequestMapping("/view.do")
	public String view(Model model, int idx) {
		
		ProductVO vo = product_dao.selectOne(idx);
		// 바인딩
		model.addAttribute("vo", vo);
		// 포워딩
		return "product/product_detail";
	}

	@RequestMapping("/login_form.do")
	public String loginPage() {
		return "login_form";
	}
	
	@RequestMapping("/login.do")
	public String login() {
		
		return "redirect:/list.do";
	}
	
	@RequestMapping("/logout.do")
	public String logout() {
		httpSession.removeAttribute("user");
		return "redirect:/login_form.do";
	}
}
