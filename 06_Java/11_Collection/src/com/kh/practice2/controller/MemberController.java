package com.kh.practice2.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.practice2.model.Member;

public class MemberController {
	
	// 전체 회원 목록
	private List<Member> members = new ArrayList<>();
	
	// 현재 로그인된 회원 (여러 명인 경우가 힘들면 이걸로)
	private Member member = null;
	
	// 회원가입 및 로그인 처리
	public boolean registerAndLogin(String name, int age) {
		// 회원가입 -> 회원 목록에 추가
		// members.add(new Member(name, age));
		for(Member member : members) {
			// 입력받은 이름과 나이가 회원정보와 같은 경우 로그인 처리
			if(member.getName().equals(name) && member.getAge() == age) {
				this.member = member;
				return true;
			}
			// 동일 이름 존재하면 가입 불가 처리			
			if(member.getName().equals(name)) {
				return false; // 가입 불가
			}
		}
		// 기존에 해당하는 이름이 없다면 가입 후 로그인 처리
		Member m = new Member();
		m.setName(name);
		m.setAge(age);
		members.add(m);
		this.member = m;
		return true;
		
		// 로그인 처리 (회원가입과 로그인 변수 분리)
		// member = new Member();
		// member.setName(name);
		// member.setAge(age);
		// return true; // 회원가입, 로그인 가능
	}
	
	// 대여 후 멤버 정보 새로 저장
	public void setMember(Member member) {
//		for(Member m : members) {
		for(int i =0; i<members.size(); i++) {
			Member m = members.get(i);
			if(m.getName().equals(member.getName())) {
				members.set(i, member);
			}
		}
	}
	
	// 로그아웃
	public void logout() {
		member = null;
	}
	
	// 마이페이지 - 현재 로그인된 정보
	public Member getMember() {
		return member;
	}
	
	
}
