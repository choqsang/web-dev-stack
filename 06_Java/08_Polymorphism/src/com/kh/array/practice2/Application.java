package com.kh.array.practice2;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.array.practice1.model.Student;
import com.kh.array.practice2.controller.MemberController;
import com.kh.array.practice2.model.Member;

public class Application {

	public static void main(String[] args) {

		/*
		 * 회원 수가 3명이 최대 등록 가능
		 * 3명 모두 등록되면 "회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈합니다."와 함께
		 * '1. 새 회원 등록 하지 못하게' 화면상 보이지 않게 처리!
		 * 
		 * 최대 등록 가능한 회원 수는 3명입니다.
		 * 현재 등록된 회원 수는 ~명입니다.
		 * 
		 * 1. 새 회원 등록
		 * 		 -> 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 있는 경우
		 * 			"중복된 아이디입니다. 다시 입력해주세요." 출력 후
		 * 			다시 아이디 입력부터 나올 수 있게 처리
		 * 
		 *          아이디 : 
		 *          이름 : 
		 *          비밀번호 : 
		 *          이메일 : 
		 *          성별(M/F) : 
		 *          나이 : 
		 *          
		 * 2. 회원 정보 수정
		 * 		-> 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 없는 경우
		 * 			"회원 정보가 없습니다." 출력 후 다시 메인 화면으로
		 * 			
		 * 		   수정할 회원의 아이디 : 
		 * 		   수정할 이름 : 
		 *         수정할 이메일 : 
		 *         수정할 비밀번호 :
		 *         
		 * 3. 전체 회원 정보 출력
		 * 		-> 반복문 사용해서 끝!
		 * 
		 * 9. 끝내기 -> 프로그램 종료
		 * 
		 * 그 외의 번호 -> 잘못 입력하셨습니다. 다시 입력해주세요
		 * 
		 * 메뉴 번호 : 
		 * */
		
		MemberController controller = new MemberController();
//		controller.idCheck();
		Member[] members = new Member[3];
		
		Scanner sc = new Scanner(System.in);
//		Member[] members = {new Member(), new Member(), new Member()};
//		Member[] memberarr = new Member[3];
//		Member member = new Member();
		
				
		 
		int count = 0;
//		for(int i=0; i<members.length; i++) {
//			System.out.println(members[i]);
		 while (true) {	
			 System.out.println("최대 등록 가능한 회원 수는 3명입니다.");
			 System.out.println("현재 등록된 회원 수는 "+ count +"명입니다.");
			 if(count<3) { System.out.println("1. 새 회원 등록"); }
			 else if(count>=3) {System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈합니다.");} 
			
		System.out.println("2. 회원 정보 수정");
		System.out.println("3. 전체 회원 정보 출력");
		System.out.println("9. 끝내기");
		System.out.print("메뉴 번호 : "); 

		int select = sc.nextInt();
		
		switch (select) {
		case 1:	
			Member m = new Member();
//			for(int i=0; i<members.length; i++) {
			System.out.print("아이디 : ");
			m.setId(sc.next());
//				if (id.equals(members[i].getId())) {
//					System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
//				}
			System.out.print("이름 : ");
			m.setName(sc.next());
			System.out.print("비밀번호 : ");
			m.setPwd(sc.next());
			System.out.print("이메일 : ");
			m.setEmail(sc.next());
			System.out.print("성별(M/F) : ");
			m.setGender(sc.next().charAt(0));
			System.out.print("나이 : ");
			m.setAge(sc.nextInt());
			members[count++] = m; 
//					new Member(id, name, pwd, email, gender, age);
			break;
			
			
		case 2:
				System.out.print("수정할 회원의 아이디 : ");
				String id = sc.next();
//				if (id.equals(members.getId())) {
//						System.out.println("회원 정보가 없습니다.");
//						continue;
//					} else members.setId(id);
				System.out.print("수정할 이름 : ");	
				String name = sc.next();
				System.out.print("수정할 이메일 : ");	
				String email = sc.next();
				System.out.print("수정할 비밀번호 : ");	
				String pwd = sc.next();
				
				for(int i=0; i<members.length; i++) {
				if(members[i]!=null && members[i].getId().equals(id)) {
				members[i].setName(name);
				members[i].setEmail(email);
				members[i].setPwd(pwd);
				}
			}	
			
		case 3:
			for (Member member : members) {
				if(member!=null) {
					System.out.println(member);
//				System.out.println("아이디 : " + members[j].getId());
//				System.out.println("이름 : " + members[j].getName());
//				System.out.println("비밀번호 : " + members[j].getPwd());
//				System.out.println("이메일 : " + members[j].getEmail());
//				System.out.println("성별 : " + members[j].getGender());
//				System.out.println("나이 : " + members[j].getAge());
//				System.out.println("====================");
				}
			} continue;
		case 9:
			System.out.println("=== 프로그램이 종료되었습니다 ===");
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			continue;
		}
		}
	}
	 
 }	
