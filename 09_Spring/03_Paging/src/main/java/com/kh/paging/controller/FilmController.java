package com.kh.paging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.paging.model.dto.PagingDTO;
import com.kh.paging.model.vo.Film;
import com.kh.paging.service.FilmService;


@Controller
public class FilmController {

	@Autowired
	private FilmService service;
	
	// localhost:8080/list => GET
	@GetMapping("/list")
	public String showFilm(Model model, PagingDTO paging) {
		// Model은 스프링에서 제공하는 기능이며, 바인딩이 원활하지 않을 경우 어노테이션을 사용하기도 함
		// Session은 서버가 종료되기 전까지 서버에 저장되는 데이터이며,
		// Model은 호출이 들어오고 나갈 때까지 저장된다.
		List<Film> list = service.showFilm(paging);
		System.out.println(paging);
		// PagingDTO dto = new PagingDTO();
		model.addAttribute("list", list);
		model.addAttribute("paging", new PagingDTO(paging.getPage(), service.total()));
		return "list";
	}
	
}