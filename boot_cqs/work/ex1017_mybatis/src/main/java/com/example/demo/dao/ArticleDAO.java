package com.example.demo.dao;

import com.example.demo.vo.ArticleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleDAO {

    List<ArticleVO> selectAll();
    ArticleVO selectOne(Integer id);
    void addArticle(ArticleVO vo);
    void updateArticle(ArticleVO vo);
    void deleteArticle(Integer id);
}
