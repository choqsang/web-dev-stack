package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data @Builder
@AllArgsConstructor @NoArgsConstructor
@Alias("avo") // 별칭 'avo'로 지정
public class ArticleVO {
    private Integer id;
    private String title;
    private String description;
    private Date created;
    private Date updated;
    private Integer member_id;
}
