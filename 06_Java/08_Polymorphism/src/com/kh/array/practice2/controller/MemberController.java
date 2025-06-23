package com.kh.array.practice2.controller;

import com.kh.array.practice2.model.Member;

public class MemberController {

	// 공간만 만들거나
	public Member[] members = new Member[3];
	
	// 객체부터 생성할거냐
	// Member[] members = {new Member(), new Member(), new Member()};
	
	// 멤버 수
//	public int countMember() {
//		return members.length;
//	}
	
	// 아이디 체크 -> 배열을 전부 확인하고 아이디가 있는 지 없는 지 여부
	public void idCheck() {
		for(Member member : members) {
			System.out.println(member!=null && member.getId()!=null);
			
		}
	}
}


