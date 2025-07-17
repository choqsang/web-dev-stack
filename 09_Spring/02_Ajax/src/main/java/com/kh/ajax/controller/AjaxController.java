package com.kh.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ajax.model.vo.Member;
import com.kh.ajax.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AjaxController {

    private final PageController pageController;
	
	@Autowired
	private MemberService service;

	private int count = 0;

    AjaxController(PageController pageController) {
        this.pageController = pageController;
    }
    
	@ResponseBody
	@GetMapping("/count")
	public int count() {
		++count;
		System.out.println(count + "번 ajax 요청!");
		return count;	
	}
	
	@ResponseBody
	@GetMapping("/encoding")
	public String encoding(String nickname) {
		 System.out.println(nickname);
		 return nickname;
	}
	
	@ResponseBody
	@PostMapping("/check")
	public boolean check(String id) {
		// Member 클래스로 받아 조건식으로 체크
		//Member member = service.idCheck(id);
		//if(member!=null) return true;
		//System.out.println(member);
		
		// Exist 쿼리문 이용 > Boolean 값으로 체크하는 방법
		return service.idBoolCheck(id);
	}
	
	@ResponseBody
	@PostMapping("/signup")
	public void signup(Member vo) {
		 System.out.println(vo.getId());
		 System.out.println(vo.getPwd());
	}
	
}
