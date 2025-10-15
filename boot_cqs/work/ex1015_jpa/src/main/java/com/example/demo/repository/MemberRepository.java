package com.example.demo.repository;

import com.example.demo.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // JpaRepository 상속받고 있을 경우, 굳이 설정할 필요는 없지만 명시적으로 기재하였음
public interface MemberRepository extends JpaRepository<Member, Long> {
    // findMember("홍길동")
    @Query("SELECT m FROM Member m WHERE m.name=:name") // :name = parameter로 넘어온 값
    // JPQL 쿼리 내에서 FROM 절 다음에 오는 이름은 데이터베이스 테이블 이름이 아니라
    // JPA 엔티티 이름이어야 하며, 이는 일반적으로 Java 클래스 이름과 동일하게 대문자로 시작
    List<Member> findMember(String name);
}
