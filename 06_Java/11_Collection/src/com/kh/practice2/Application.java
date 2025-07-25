package com.kh.practice2;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice2.controller.BookController;
import com.kh.practice2.controller.MemberController;
import com.kh.practice2.model.Book;
import com.kh.practice2.model.Member;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	Member member;
	MemberController mc = new MemberController();
	BookController bc = new BookController();

	// 멤버들의 정보가 들어갈 공간
	ArrayList<Member> members = new ArrayList<>();	{
		
	}
	// 대여 가능한 책 목록
	ArrayList<Book> books = new ArrayList<>();	{
	    books.add(new Book("디스 이즈 이탈리아", false, 0));
	    books.add(new Book("리얼 런던", true, 0));
	    books.add(new Book("집에서 즐기는 스페인 요리 여행", false, 0));
	    books.add(new Book("사퀴트리 샌드위치", false, 0));
	    books.add(new Book("원피스 111", true, 15));
	    books.add(new Book("귀멸의 칼날 23", false, 19));
	    books.add(new Book("진격의 거인 Before the fall 16", false, 19));
	   }    				// 이름, 쿠폰, 나이 제한
	
	public static void main(String[] args) {
		Application app = new Application();
		try {
			app.menu();
		} catch(Exception e) {
			System.out.println("잘못된 입력값입니다! 다시 입력해주세요.");
			app.menu(); // 다만, 함수 내 예외처리가 아니기 때문에 무한 반복되지는 않는다.
		}
		
		/*
		 * 이름 : 
		 * 나이 : 
		 * -> 회원가입/로그인 -> 조건 : 이름과 나이가 일치한 경우!
		 * -> 기존에 회원 중 이름이 있으면 "이미 존재하는 이름입니다. 다시 입력해주실래요?"
		 * 
		 * ==== 메뉴 ====
		 * 1. 마이페이지 -> 본인 정보
		 * 2. 도서 대여하기
		 * 		-> 1. 한 사람 당 대여할 수 있는 책은 총 3권
		 * 			"더 이상 대여할 수 없습니다."
		 * 		-> 2. 해당 사람이 대여한 책은 대여 불가능
		 * 			"이미 대여한 책입니다."
		 * 		-> 3. 나이 제한에 걸리는 책들 대여 불가능
		 * 			"나이 제한으로 대여 불가능합니다."
		 * 		-> 4. 쿠폰이 있는 경우 나이 제한 걸려도 대여 가능
		 * 		-> (선택사항) 5. 각 책들마다 가능한 대여가 3명까지만 가능, 이후론 불가
		 * 					HashMap 사용 -> getOrDefault(키, 초기값)
		 * 		-> 대여 가능한 경우 : "성공적으로 대여되었습니다."
		 * 3. 로그아웃
		 * 4. 프로그램 종료
		 * */
	}	
	
	// 회원가입/로그인 화면
	public void menu() {
		System.out.println("==== 로그인 ====");
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		// 매칭되는 이름-나이가 없을 경우, 입력된 정보로 회원 정보 저장
		boolean result = mc.registerAndLogin(name, age);
		// 기존에 회원 중 이름이 있으면 "이미 존재하는 이름입니다. 다시 입력해주실래요?"
		if(!result) {
			System.out.println("이미 존재하는 이름입니다. 다시 입력해주실래요?");
			menu();
		} else
		// 이름-나이가 일치할 경우, 로그인 성공!
		System.out.println(name + "님이 로그인되었습니다.");
		
		boolean check = true;
		while (check) {
		System.out.println("==== 메뉴 ====");
		System.out.println("1. 마이페이지");
		System.out.println("2. 도서 대여하기");
		System.out.println("3. 로그아웃");
		System.out.println("4. 프로그램 종료");
		System.out.print("이동하시려는 메뉴를 선택해주세요 > ");
		int menu = sc.nextInt();
		
		switch (menu) {
			case 1: // 마이페이지
				System.out.println("==== 회원정보 ====");
//				System.out.println(mc.getMember());
				System.out.println("이름 : " + member.getName());
				System.out.println("나이 : " + age);
//				System.out.println("보유 중인 쿠폰 수 : " + member.getCoupon());
//				System.out.println("대여중인 도서 : " + member.getBooklist());
				break;
				
			case 2: // 도서 대여하기
				rent();
				break;
				
			case 3: // 사용자가 많아질 때 구현 -> 로그아웃
				mc.logout();
				System.out.println("");
				System.out.println("로그아웃 되었습니다.");
				menu();
				break;
				
			case 4: // 프로그램 종료
				System.out.println("");
				System.out.println("프로그램이 종료되었습니다. 안녕히 가세요.");
				check = false;
				break;
				
			} // switch문
		} // while문
	}
	
	public void rent() {
		Member member = new Member();
		// 향상된 for문 : 값만 가지고 올 때 간단히
		// 인덱스까지 필요하시다면 일반 for문 사용하기!
		System.out.println("==== 보유 중인 도서목록 ====");
		for(int i=0; i<books.size(); i++) {
			System.out.println((i+1) + ") " + books.get(i).getTitle());
		} System.out.print("\n대여를 원하시는 책의 번호를 입력해주세요 > ");
		int bookNum = sc.nextInt()-1;
		// 내가 대여할 책 Book 객체 하나
//		System.out.println(books.get(bookNum));
		// Member 객체에 bookList 여기에 추가
		// member.getBooklist().add(books.get(bookNum));
		Object result = bc.rentBook(books.get(bookNum), mc.getMember());
		if(result instanceof Member) {
			System.out.println("성공적으로 대여되었습니다.");
			mc.setMember((Member)result);
		} else {
			System.out.println(result);
		}
	}
}
