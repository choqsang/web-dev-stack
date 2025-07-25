package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.vo.Board;
import com.kh.upload.service.BoardService;

@Controller
public class BoardController {

    private final CustomErrorController customErrorController;

    BoardController(CustomErrorController customErrorController) {
        this.customErrorController = customErrorController;
    }

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	public String fileUpload(MultipartFile file) {
		//System.out.println("파일 이름 : " + file.getOriginalFilename());
		//System.out.println("파일 사이즈 : " + file.getSize());
		//System.out.println("파일 파라미터명 : " + file.getName());
		
		// 중복 방지를 위한 UUID 적용
		UUID uuid = UUID.randomUUID();
		// System.out.println(uuid.toString());
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
		System.out.println(file.getOriginalFilename());
		File copyFile = new File("\\\\192.168.0.35\\upload\\" + fileName);
		try {
			file.transferTo(copyFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/upload")
	public String upload(MultipartFile file) {
		String fileName = fileUpload(file);
		// http://localhost:8081/ + fileName <- url
		return "redirect:/";
	}
	
	// List<MultipartFile>
	@PostMapping("/multiUpload")
	public String multiUpload(List<MultipartFile> files) {
		
		for(MultipartFile file: files) {
			String fileName = fileUpload(file);
		}
		return "redirect:/";
	}
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public String selectAll(Model model) {
		List<Board> list = service.selectAll();
		model.addAttribute("list", list);
		return "list";
	}
	
	@PostMapping("/insert")
	public String insert(Board vo) {
		return "redirect:/";
	}
	
	@PostMapping("/write")
	public String write(BoardDTO dto) {
		String fileName = fileUpload(dto.getFile());
		MultipartFile file = dto.getFile();
		dto.setUrl(file.getOriginalFilename());
		service.write(dto);
		return "redirect:/list";
	}
	
	@PostMapping("/delete")
	public String delete(int no) {
		service.delete(no);
		return "redirect:/";
	}
	
	
	
}
