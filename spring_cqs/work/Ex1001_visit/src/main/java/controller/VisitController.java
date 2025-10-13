package controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import util.PwdBcrypt;
import dao.VisitDAO;
import vo.VisitVO;

@Controller
public class VisitController {
	
	// 굳이 파라미터로 설정하지 않더라도 자바에서 제공하는 객체의 경우 
	// AutoWired를 통해서 호출 가능 (servlet-context.xml에 추가 필요) 
	// 하기 3건 자주 이용됨	
	@Autowired
	HttpServletRequest request;
	// 요청처리 객체
	@Autowired
	ServletContext app;
	// 프로젝트의 정보를 가지는 객체
	@Autowired
	SqlSession sqlSession;
	// 세션
	
	VisitDAO visit_dao;
	
	public VisitController(VisitDAO visit_dao) {
		this.visit_dao = visit_dao;
	}
	
	@RequestMapping(value={"/", "/list.do"})
	public String list(Model model) {
		List<VisitVO> list = visit_dao.selectList();
		model.addAttribute("list", list);
		return "visit_list2";
	}
	
	@RequestMapping("/regi_form.do")
	public String regiForm() {
		return "regi_form2";
	}
	
	@RequestMapping("/visit_insert.do")
	public String addList(VisitVO vo, HttpServletRequest request) {
//		PwdBcrypt pbc = new PwdBcrypt();
//		String encodePwd = pbc.encodingPwd(vo.getPwd());
//		vo.setPwd(encodePwd);
		
		String webPath = "/resources/upload/";		// 상대경로
		String savePath = app.getRealPath(webPath); // 절대경로
		System.out.println("절대경로 : " + savePath);
		
		// 업로드된 파일의 정보
		MultipartFile photo = vo.getPhoto();
		String filename = "no_file";
		
		// 업로드를 위한 파일이 존재한다면 (= 값이 비어 있지 않다면)
		if( !photo.isEmpty() ) {
			// 업로드된 파일의 실제 파일명 담기
			filename = photo.getOriginalFilename();
			
			// 저장할 파일 경로
			File saveFile = new File(savePath, filename);
			if( !saveFile.exists()) { // 경로가 물리적으로 존재하는 지 여부
				saveFile.mkdirs(); // 없다면 폴더를 만든다 (make directories)
				// 폴더만 만들 경우에는 .mkdir 이지만
				// 위와 같은 경우 경로명 + 파일명 동시 진행이기에 s가 붙는다 
			} else {
				// 동일한 파일명이 존재한다면 현재 시간을 붙여서 중복을 방지한다
				long time = System.currentTimeMillis(); // 1ms 단위
				filename = String.format("%d_%s", time, filename); // 숫자_문자 형태
				saveFile = new File(savePath, filename);
			}
			
			try {
				photo.transferTo(saveFile);
				// Multipart resolver의 역할 => 실제 업로드된 파일을 물리적으로 생성함
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		vo.setFilename(filename);
		vo.setIp(request.getRemoteAddr());
		int res = visit_dao.register(vo);
		return "redirect:/list.do";
	}
	
	/*
	 * @RequestMapping("/visit_del.do") public String delList(int idx) { int res =
	 * visit_dao.del(idx); return "redirect:/list.do"; }
	 */
	
	@RequestMapping("/visit_del.do")
	@ResponseBody
	public String delList(int idx) {
		
		int res = visit_dao.del(idx);
		
		// 경로에 있는 파일 물리적인 삭제 필요
		VisitVO vo = visit_dao.modify(idx);
		
		String result = "no";
		if(res == 1) {
			result = "yes";
			
			if(!vo.getFilename().equals("no_file")) { // 이름이 등록된 파일이 있을 경우, 
				String webPath = "/resources/upload/";		// 상대경로
				String savePath = app.getRealPath(webPath); // 절대경로
				
				// resources/upload/aaa.png = 절대 경로에 있는 파일명 체크
				String filename = savePath + vo.getFilename();
				// 경로에 이름이 일치하는 파일이 있을 경우 삭제
				File file = new File(filename);
				if (file.exists()) {
					file.delete();
				}
			}
		}
		// callback
		return result;
	}
	
	@RequestMapping("/modify_form.do")
	public String modifyForm(Model model, int idx) {
		VisitVO vo = visit_dao.modify(idx);
		model.addAttribute("vo", vo);
		return "modify_form2";
	}
	
	/*@RequestMapping("/visit_modify.do")
	public String modifyFin(VisitVO vo) {
	//	PwdBcrypt pbc = new PwdBcrypt();
	//	String encodePwd = pbc.encodingPwd(vo.getPwd());
	//	vo.setPwd(encodePwd);
		int res = visit_dao.modifyFin(vo);
		return "redirect:/list.do";
	}*/
	
	@RequestMapping("/visit_modify.do")
	public String modifyFin(VisitVO vo) {
		
		String webPath = "/resources/upload/";		// 상대경로
		String savePath = app.getRealPath(webPath); // 절대경로
		System.out.println("절대경로 : " + savePath);
		
		// 1. 기존 게시물 정보 조회 (기존 파일명(old_filename)을 얻기 위함)
	    VisitVO oldVo = visit_dao.modify(vo.getIdx());
	    String old_filename = oldVo.getFilename(); // DB에 저장된 기존 파일명
	    
		// 업로드된 파일의 정보
		MultipartFile photo = vo.getPhoto();
		String new_filename = old_filename; // 기본적으로는 기존 파일명을 유지
		
		// 2. 새 파일이 업로드되었는지 확인 (새 파일로 변경하는 경우)
	    if( !photo.isEmpty() ) {
	    	// 3. 새 파일명을 처리하는 기존 로직
	    	new_filename = photo.getOriginalFilename();
	        File saveFile = new File(savePath, new_filename);
			
	     // 중복 파일명 처리 (기존 로직 그대로 유지)
	        if( saveFile.exists() ) { 
	            long time = System.currentTimeMillis(); 
	            new_filename = String.format("%d_%s", time, new_filename);
	            saveFile = new File(savePath, new_filename);
	        }
	        
	     // 4. 기존 파일 삭제 로직 추가 ---------------------------------
	        if (old_filename != null && !old_filename.equals("no_file")) {
	            File oldFile = new File(savePath, old_filename);
	            if (oldFile.exists()) {
	                if (oldFile.delete()) {
	                    System.out.println("기존 파일 삭제 성공: " + old_filename);
	                } else {
	                    System.out.println("기존 파일 삭제 실패: " + old_filename);
	                }
	            }
	        }
			
			try {
				photo.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		vo.setFilename(new_filename);
		
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		visit_dao.modifyFin(vo);
		return "redirect:/list.do";
	}
	
}
