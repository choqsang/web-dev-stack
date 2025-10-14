package com.example.demo;

import org.springframework.data.repository.CrudRepository; // jpa에서는 별도 쿼리문 입력 없이도 기본적인 CRUD 기능을 제공한다
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
    // CrudRepository : 따로 sql문을 작성하지 않고, 생성/조회/수정/삭제 기능을 제공하는 인터페이스

    /* CrudRepository가 제공하는 기본 crud 메서드
    1. save() : 생성 및 수정
    2. findById(), findAll() : 특정 혹은 전체 조회
    3. deleteById(), deleteAll() : 삭제
    4. count() : 전체 행 수 조회
    */
    List<Member> findByName( String name ); // findBy + 뒤의 값을 변경하여 응용 가능

    // Like + 조회 : Containing을 알아서 인식함
    List<Member> findByNameContaining( String name );

    // 이름으로 삭제
    int deleteByName( String name );
}
