package com.example.demo.mapper;

import com.example.demo.model.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {

    // mapper 연결 없이 다이렉트로 쿼리문 작성
    @Select("select * from article")
    List<Article> selectAll(); // 해당 메서드 실행 시 위에 설정해둔 쿼리문 실행

}
