package com.kh.practice2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.kh.practice2.model.Book;
import com.kh.practice2.model.Member;

public class BookController {
	
	// (선택사항) 책 제목 기준으로 현재 대여 인원 수 파악
	private Map<String, Integer> bookCount = new HashMap<>();
//	MemberController mc = new MemberController();
	
	// 책 대여 - String에서 상위개념 Object로 변경하였음.
	public Object rentBook(Book book, Member member) {
//		member.getBooklist().add(book);
		// 내 책 리스트
		ArrayList<Book> list = member.getBooklist();
		
		// -> 1. 한 사람 당 대여할 수 있는 책은 총 3권
		if(list.size()>2) {
			return "더 이상 대여할 수 없습니다.";
		}
		// -> 2. 해당 사람이 대여한 책(book)은 대여 불가능
		// 기존 list에 해당 책이 있는 경우 대여 못하게 return
		
		if(list.contains(book)) {
			return "이미 대여한 책입니다.";
		}
		// -> 3. 나이 제한에 걸리는 책들 대여 불가능 (쿠폰 X)
		if(member.getCoupon() == 0 && member.getAge() < book.getAccessAge()) {
			return "나이 제한으로 대여 불가능합니다.";
		}
		
		// -> 5. 각 책들마다 가능한 대여가 3명까지만 가능, 이후론 불가 (회원 다수일 때)
		if(book.getCount()>2) {
			return "해당 도서는 더 이상 대여하실 수 없습니다.";
		}
		// Book 객체에 count 추가한 방법
		book.setCount(book.getCount()+1);
		
		// --------------- 대여 가능! --------------------
		
		// 책에 쿠폰이 있는 경우(T/F) -> 내 쿠폰 +1
		if(book.isCoupon()) { // boolean값은 getter가 isXX으로 나온다.
			// 내 쿠폰 수정 : 기존 내 쿠폰 갯수 +1
			member.setCoupon(member.getCoupon()+1);
		}
		// -> 4. 쿠폰이 있는 경우 나이 제한 걸려도 대여 가능
		if(member.getAge() < book.getAccessAge()) {
			// 쿠폰을 사용! 멤버가 가지고 있는 쿠폰에서 -1
			member.setCoupon(member.getCoupon()-1);
		}
				
		list.add(book);
		member.setBooklist(list);
		return member;
//		"성공적으로 대여되었습니다.";
	}
}
