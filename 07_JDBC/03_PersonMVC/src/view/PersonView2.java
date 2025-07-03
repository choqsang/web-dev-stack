package view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import controller.PersonController2;
import vo.Person;

public class PersonView2 {
	PersonController2 pc2 = new PersonController2();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		PersonView2 view = new PersonView2();
		view.menu();
	}
	
	public void menu() {
		while (true) {
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("1. 회원 추가");
			System.out.println("2. 전체 조회");
			System.out.println("3. 아이디 조회");
			System.out.println("4. 회원 정보 변경");
			System.out.println("5. 회원 삭제");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.print("메뉴 선택 : ");
			int select = Integer.parseInt(sc.nextLine());
			switch(select) {
			case 1:
				System.out.println(addPerson());
				break;
			case 2:
				searchAllPerson();
				break;
			case 3:
				searchPerson();
				break;
			case 4:
				System.out.println(updatePerson());
				break;
			case 5:
				System.out.println(removePerson());
				break;
			}
		}
	}

	public String addPerson() {
		try {
			System.out.print("이름 > ");
			String name = sc.nextLine();
			System.out.print("나이 > ");
			int age = Integer.parseInt(sc.nextLine());
			System.out.print("주소 > ");
			String addr = sc.nextLine();
			return pc2.addPerson(name, age, addr);
		} catch (NumberFormatException e) {
			return "숫자를 입력해주세요.";
		} 
	}
	
	public void searchAllPerson() {
			List<Person> list = pc2.searchAllPerson();
			if (list != null) {
				for (Person p : list) {
					System.out.println(p);
				}
			}
		}
	
	public void searchPerson() {
			searchAllPerson();
			System.out.print("아이디 > ");
			int id = Integer.parseInt(sc.nextLine());
			Person person = pc2.searchPerson(id);
			if(person!=null) System.out.println(person + " 조회 완료!");
			else System.out.println("입력하신 아이디가 존재하지 않습니다!");
		
	}
	
	public String updatePerson() {
		searchAllPerson();
		
		System.out.print("아이디 > ");
		int id = Integer.parseInt(sc.nextLine());
		Person person = pc2.searchPerson(id);
		// 아이디가 있는 경우만 수정할 수 있도록!
		// 아이디가 없는 경우 내보내기!
		if(person == null) return "조회된 아이디가 없습니다!";
		
		System.out.print("이름 변경 > ");
		String name = sc.nextLine();
		System.out.print("변경된 나이 > ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("변경된 주소 > ");
		String addr = sc.nextLine();
		
		return pc2.updatePerson(name, age, addr, id);
	}
	
	public String removePerson() {
		searchAllPerson(); // 콘솔 내 리스트 노출 원치 않을 경우 주석 처리
		
		System.out.print("아이디 > ");
		int id = Integer.parseInt(sc.nextLine());
		Person person = pc2.searchPerson(id);
		
		// 아이디가 있는 경우만 삭제할 수 있도록!
		// 아이디가 없는 경우 내보내기!
		if(person == null) return "조회된 아이디가 없습니다!";
		return pc2.removePerson(id);
	}
}




