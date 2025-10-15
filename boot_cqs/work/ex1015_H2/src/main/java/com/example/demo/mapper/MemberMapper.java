package com.example.demo.mapper;

import com.example.demo.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    List<Member> selectAll();
    int selectAllCount();

    // 이메일로 검색한 결과가 한 건도 없다면 Optional.empty()를 반환
    // 결과 없음을 가정하여 List 대신 옵셔널 활용
    Optional<Member> selectByEmail(String email);
}
