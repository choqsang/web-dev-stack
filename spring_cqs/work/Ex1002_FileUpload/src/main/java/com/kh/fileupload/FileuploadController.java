package com.kh.fileupload;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import vo.PhotoVO;

@Controller
public class FileuploadController {
	
	@Autowired
	ServletContext app;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	SqlSession sqlSession;
	
	@RequestMapping(value= {"/", "/insert_form.do"})
	public String insertForm() {
		return "insert_form";
	}
	
	@RequestMapping("/upload.do")
	public String upload(PhotoVO vo, Model model) {
		
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		vo.setFilename(filename);
		model.addAttribute("vo", vo);
		
		return "input_result";
	}
	
	
}
