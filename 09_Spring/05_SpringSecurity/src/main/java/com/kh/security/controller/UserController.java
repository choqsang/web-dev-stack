package com.kh.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
		return "/mypage/register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/mypage/login";
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
	public String delete(List<String> idList) {
		service.delete(idList);
		return "redirect:/";
	}
	
}
