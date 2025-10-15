package com.example.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="article") // 테이블 명 별도로 지정 가능, 없을 경우 클래스명 그대로 생성됨
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Article {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length =100) // 컬럼명과 크기(100byte) 설정
    private String title;

    @Column(name = "description", length = 4096)
    private String description;

    @ManyToOne // join 관계 = 다대일
    @JoinColumn(name="memberId")
    private Member member;

}
