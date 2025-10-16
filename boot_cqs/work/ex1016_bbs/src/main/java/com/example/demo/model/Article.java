package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity @Builder
@Data @AllArgsConstructor @NoArgsConstructor
@EntityListeners(AuditingEntityListener.class) // 엔티티의 상태 변화를 감지하고 특정 작업을 수행하도록 하는 데 사용
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @CreatedDate // 생성 시점 감지
    private Date created;
    @LastModifiedDate // 최종수정 시점 감지
    private Date updated;
    private Integer member_id;
}
