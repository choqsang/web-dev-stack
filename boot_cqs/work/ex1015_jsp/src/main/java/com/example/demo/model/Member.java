package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Member {

    // 기본 자료형 대신에 래퍼 클래스(Wrapper Class)로 받음
    private Long id;
    private String name;
    private String email;
    private Integer age;

}
