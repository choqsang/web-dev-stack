package com.example.demo.controller;

import com.example.demo.dao.ArticleDAO;
import com.example.demo.vo.ArticleVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    public final ArticleDAO articleDAO;

    @GetMapping(value={"/", "list"})
    public String getArticleList(Model model){
        List<ArticleVO> articles = articleDAO.selectAll();
        model.addAttribute("articles", articles);
        return "article-list";
    }

    @GetMapping("/content")
    public String viewArticle(Model model, Integer id){
        ArticleVO vo = articleDAO.selectOne(id);
        model.addAttribute("vo", vo);
        return "article-content";
    }

    @GetMapping("/add")
    public String newArticleForm(Model model, Integer member_id){
        model.addAttribute("member_id", member_id);
        return "article-add";
    }

    @PostMapping("/add")
    public String addArticle(ArticleVO vo){
//        ArticleVO newArt = new ArticleVO();
//        newArt.setTitle(vo.getTitle());
//        newArt.setDescription(vo.getDescription());
//        newArt.setMember_id(vo.getMember_id());
        articleDAO.addArticle(vo);
        return "redirect:list";
    }

    @GetMapping("/edit")
    public String updateForm(Model model, Integer id){
        ArticleVO vo = articleDAO.selectOne(id);
        model.addAttribute("vo", vo);
        return "article-edit";
    }

    @PostMapping("/edit")
    public String updateArticle(ArticleVO vo){
        articleDAO.updateArticle(vo);
        return "redirect:list";
    }

    @GetMapping("/delete")
    public String deleteArticle(Integer id){
        articleDAO.deleteArticle(id);
        return "redirect:list";
    }

}
