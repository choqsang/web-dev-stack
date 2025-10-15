package com.example.demo;

import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component // 어플리케이션에 세팅해두어야 하위 컴포넌트 실행 가능
@RequiredArgsConstructor
@Slf4j
public class JpaApplication implements ApplicationRunner {
    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Member member1 = Member.builder().name("홍길동")
                .email("hong@a.com").age(20).build();
        memberRepository.save(member1);

        var member2 = Member.builder().name("홍길순")
                .email("soon@a.com").age(22).build();
        memberRepository.save(member2);

        memberRepository.save(
                Member.builder().name("홍길길")
                .email("gil@a.com").age(24).build());
        // 위 어떤 방식으로도 다 가능

        var article1 = Article.builder()
                    .title("집에 가고싶다")
                    .description("야 너두? 야 나두")
                    .member(member1)
                    .build();
        articleRepository.save(article1);

        var article2 = Article.builder()
                .title("집에 가고싶다 real")
                .description("야 너두? 야 나두2222")
                .member(member1)
                .build();
        articleRepository.save(article2);

    }

}
