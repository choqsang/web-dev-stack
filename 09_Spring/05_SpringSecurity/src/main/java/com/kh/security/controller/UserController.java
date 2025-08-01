package com.kh.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.security.model.vo.User;
import com.kh.security.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("list", service.selectAll());
		return "index";
	}
	
	@GetMapping("/register")
	public String register() {
		return "/register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	@GetMapping("/mypage")
	public String mypage() {
		return "/mypage";
	}
	
	@GetMapping("/admin")
	public String admin() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		System.out.println(user);
		return "/admin";
	}
	
	@PostMapping("/login")
	public String login(String id, HttpServletRequest request) {
		User user = service.login(id);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("/register")
	public String register(User vo) {
		service.register(vo);
		return "redirect:/";
	}
	
	@PostMapping("/update")
	public String update(User vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		vo.setId(user.getId());
		service.update(vo);
		return "redirect:/";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam(name="idList", required=false) List<String> idList) {
		System.out.println(idList);
		if(idList!=null) service.delete(idList);
		return "redirect:/";
	}
	
}
