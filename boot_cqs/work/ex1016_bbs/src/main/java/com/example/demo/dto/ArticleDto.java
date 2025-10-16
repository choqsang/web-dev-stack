package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
@Builder
public class ArticleDto {

    private Long id;
    private String title;
    private String description;
    private Date created;
    private Date updated;
    private Integer member_id;
}
