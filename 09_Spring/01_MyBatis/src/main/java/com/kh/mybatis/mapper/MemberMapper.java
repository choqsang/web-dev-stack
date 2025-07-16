package com.kh.mybatis.mapper;
// Mapper는 기존 DAO의 역할을 수행한다.
// member.xml 파일과 1:1 대응하게끔 설정한다.
// application.properties에 경로 등 설정 세팅은 이 곳에서!

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;

@Mapper
public interface MemberMapper {
	void register(Member vo);
	Member login(Member vo);
	List<Member> allMember();
	List<Member> search(SearchDTO dto);
	void update(Member vo);
	void delete(String id);
	void selectDelete(List<String> idList);
}

