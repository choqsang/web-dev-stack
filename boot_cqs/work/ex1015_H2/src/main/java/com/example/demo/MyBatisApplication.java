package com.example.demo;

import com.example.demo.mapper.ArticleMapper;
import com.example.demo.mapper.MemberMapper;
import com.example.demo.model.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor // final(상수) 자동 생성자 생성하여 파라미터 받도록
@Slf4j // 로그 사용
public class MyBatisApplication implements ApplicationRunner {
    private final MemberMapper memberMapper;
    private final ArticleMapper articleMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int count = memberMapper.selectAllCount();
        log.info("member count:{}", count);

        Member member = memberMapper.selectByEmail("hong@a.com").orElseThrow();
        log.info("Member:{}", member);

    }
}
