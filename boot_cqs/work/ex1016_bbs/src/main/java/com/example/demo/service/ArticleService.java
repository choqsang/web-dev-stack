package com.example.demo.service;

import com.example.demo.dto.ArticleDto;
import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    
    // Article(DB연동객체)에서 가져온 정보를 화면에 보여주기 위해 DTO타입으로 매핑하기 위한 메서드
    private ArticleDto mapToArticleDto(Article article){
        return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .description(article.getDescription())
                .created(article.getCreated())
                .updated(article.getUpdated())
                .member_id(article.getMember_id())
                .build();
    }

    // 게시글 전체 조회 (select * from article)
    public List<ArticleDto> findAll(){
        return articleRepository.findAll().stream().map(this::mapToArticleDto).toList();
    }

    // id로 게시글 조회 (select * from article where id = #{id})
    public ArticleDto findById(Long id){
        return articleRepository.findById(id).map(this::mapToArticleDto).orElseThrow();
    }

    // 새 글 등록
    public ArticleDto addNewArticle(Integer member_id, String title, String description){
        Article article = new Article();
        article.setMember_id(member_id);
        article.setTitle(title);
        article.setDescription(description);
        article.setCreated(article.getCreated());
        article.setUpdated(article.getUpdated());

        Article saveArticle = articleRepository.save(article);
        return mapToArticleDto(saveArticle);
    }

    // 게시글 수정
    public ArticleDto updateArticle(ArticleDto upDto){
        Article article = articleRepository.findById(upDto.getId()).orElseThrow();
        article.setTitle(upDto.getTitle());
        article.setDescription(upDto.getDescription());
        article.setUpdated(upDto.getUpdated());

        Article updateArticle = articleRepository.save(article);
        return mapToArticleDto(updateArticle);
    }

    public void deleteArticle(Long id){
        // Article article = articleRepository.findById(id).orElseThrow();
        // articleRepository.delete(article);
        articleRepository.deleteById(id);
    }
}
