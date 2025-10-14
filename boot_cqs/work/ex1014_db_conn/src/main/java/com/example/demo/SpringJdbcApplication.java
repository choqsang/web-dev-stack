package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
// 제일 먼저 실행될 수 있도록 (Spring 애플리케이션 Run on Server시 web.xml에 세팅된대로 실행되듯)
// @Component의 자식으로 @Controller, @Repository, @Service가 존재한다
@RequiredArgsConstructor // 생성 단계에서 클래스 내 final로 정의된 생성자 자동 생성
@Slf4j // log 기능 사용 : 로그 출력
public class SpringJdbcApplication implements ApplicationRunner {

    private final MemberRepository memberRepository; // 위 클래스 생성 시점 (메모리 할당) , MemberRepository 생성

    @Override // ApplicationRunner 인터페이스가 가지고 있는 내용 오버라이드
    public void run(ApplicationArguments args) throws Exception {
        log.info("{}", "hello run");

        // Member.java에 @Builder를 걸어두면 아래와 같이 생성 가능 => create
        /* Member member = Member.builder().name("임꺽정")
                                        .email("hgd@a.com")
                                        .age(20)
                                        .build();

        memberRepository.save(member); // member에 담은 내용 생성
        member.setAge(60);
        memberRepository.save(member); // 윗 줄에서 age값 수정하여 생성
        */

        // 이름으로 조회 (MemberRepository에 미리 세팅해둔 메서드)
        List<Member> members = memberRepository.findByName("홍길동");
        if(members.isEmpty()){
            log.info("홍길동 이라는 이름의 회원은 존재하지 않습니다");
        } else {
            for(Member member : members ){
                log.info("조회된 회원 {}", member);
            }
        }

        // 이름에 a가 포함되어 있는 데이터 조회
        log.info("포함여부{}", memberRepository.findByNameContaining("a"));
        // 이름으로 삭제
        int res = memberRepository.deleteByName("홍길동");
    }
}
