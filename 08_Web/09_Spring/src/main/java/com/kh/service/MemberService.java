package com.kh.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.dao.MemberDAO;
import com.kh.vo.Member;

// controller <= 응답만 받음
// service - 비즈니스 로직 수행
// dao <= myBatis로 대체

@Service
public class MemberService {

	@Autowired
	private MemberDAO dao;
	
	public void register(Member member) throws SQLException {
		dao.register(member);
	}

	public Member login(Member member) throws SQLException {
		return dao.login(member.getId(), member.getPwd());
	}
	
	public Member search(String id) throws SQLException {
		return dao.search(id);
	}
	
	public List<Member> showAll() throws SQLException {
		return dao.showAll();
	}
}
