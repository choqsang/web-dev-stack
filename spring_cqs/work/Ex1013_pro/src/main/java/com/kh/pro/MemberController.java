package com.kh.pro;

import java.io.File;
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

import dao.MemberDAO;

//스프링의 컨트롤러는 jsp의 servlet과 같은 역할을 담당한다
@Controller
public class MemberController { 
	
	@Autowired
	HttpServletRequest request;	// 요청처리 객체
	@Autowired
	ServletContext app; // 프로젝트의 정보를 가지는 객체
	@Autowired
	SqlSession sqlSession; 	// SQL 세션
	@Autowired
	HttpSession httpSession; // HTTP 세션
	
	MemberDAO member_dao;
	
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
