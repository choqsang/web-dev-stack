package com.kh.ajax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ajax.mapper.MemberMapper;
import com.kh.ajax.model.vo.Member;

@Service
public class MemberService implements MemberMapper{
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public Member idCheck(String id) {
		return mapper.idCheck(id);
	}

	@Override
	public boolean idBoolCheck(String id) {
		return mapper.idBoolCheck(id);
	}

	@Override
	public Member signup(String id, String pwd) {
		return null;
	}
}
