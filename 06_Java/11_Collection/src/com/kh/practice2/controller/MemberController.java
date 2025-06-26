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
		// 동일 이름 존재하면 가입 불가 처리
		// 입력받은 이름과 나이가 회원정보와 같은 경우 로그인 처리
		// 기존에 해당하는 이름이 없다면 가입 후 로그인 처리
		return false;
	}
	
	// 로그아웃
	public void logout() {
		
	}
	
	// 마이페이지 - 현재 로그인된 정보
	public Member getMember() {
		return null;
	}
	
	
}
