package com.example.demo.controller;

import com.example.demo.dto.ArticleDto;
import com.example.demo.model.Article;
import com.example.demo.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/article") // base 경로 설정 => 하위에 설정될 get/postMapping 에 반영됨
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService; // 레포지토리 대신 서비스를 받아온다

    // 전체 게시글 목록 페이지
    @GetMapping( value = {"" , "/list"})
    public String getArticleList(Model model){
        List<ArticleDto> articles = articleService.findAll();
        model.addAttribute("articles", articles);
        return "article-list"; // .html 로 포워딩 (templates 경로)
    }

    // 게시글 상세보기 페이지
    @GetMapping("/content")
    public String getArticle(Model model, Long id){
        ArticleDto article = articleService.findById(id);
        model.addAttribute("article", article);
        return "article-content";
    }

    // 새 글 작성 페이지
    @GetMapping("/add")
    public String getAdd(Model model, Integer member_id){
        model.addAttribute("member_id", member_id);
        return "article-add";
    }
    
    // 새 글 등록
    @PostMapping("/add")
    public String postAdd(Integer member_id, String title, String description){
        articleService.addNewArticle(member_id, title, description);
        return "redirect:list"; // = "redirect:/article/list"
    }

    // 수정 원하는 게시글 조회
    @GetMapping("/edit")
    public String getEdit(Model model, Long id){
        ArticleDto dto = articleService.findById(id);
        model.addAttribute("dto", dto);
        return "article-edit";
    }

    // 게시글 변경사항 적용(수정 기능)
    @PostMapping("/update")
    public String postUpdate(ArticleDto dto){
        // 수정할 게시글의 id에 해당하는 dto 조회
        ArticleDto upDto = articleService.findById(dto.getId());
        upDto.setTitle(dto.getTitle());
        upDto.setDescription(dto.getDescription());
        upDto.setUpdated(dto.getUpdated());
        articleService.updateArticle(upDto);
        return "redirect:list";
    }

    // 게시글 삭제
    @GetMapping("/delete")
    public String getDelete(Long id){
        articleService.deleteArticle(id);
        return "redirect:list";
    }
}
