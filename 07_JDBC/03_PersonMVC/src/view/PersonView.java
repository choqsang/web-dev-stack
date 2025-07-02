package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import config.ServerInfo;
import controller.PersonController;

public class PersonView {
	
	public static void main(String[] args) throws Exception {
		PersonController pc = new PersonController();
		Scanner sc = new Scanner(System.in);
		
			try {
				Class.forName(ServerInfo.DRIVER);
				Connection connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			// 테스트 용도!
		
			boolean check = true;
			while(check) {
				
				System.out.println("======== 메인 메뉴 ========");
//				System.out.println("※ 주의 : 정확한 값을 입력하지 않으면 시스템 다운");
				System.out.println("1. 사용자 추가");
				System.out.println("2. 전체 사용자 조회");
				System.out.println("3. 아이디 조회");
				System.out.println("4. 사용자 수정");
				System.out.println("5. 미성년자 삭제");
				System.out.println("====================");
				System.out.print("원하시는 메뉴를 선택하세요 : ");
				int menu = Integer.parseInt(sc.nextLine());
				
				switch(menu) {
					case 1:
						// person 테이블에 데이터 추가 - INSERT
						System.out.println("사용자 정보를 추가합니다.");
						System.out.print("이름을 입력해주세요 : ");
						String name = sc.nextLine();
						System.out.print("나이를 입력해주세요 : ");
						int age = Integer.parseInt(sc.nextLine());
						System.out.print("주소를 입력해주세요 : ");
						String addr = sc.nextLine();
						
						pc.addPerson(name, age, addr);
						break;
						
					case 2:
						// person 테이블에 있는 데이터 전체 보여주기 - SELECT
						System.out.println("======== 사용자 목록 ========");
						pc.searchAllPerson();
						break;
						
					case 3:
						// person 테이블에서 데이터 한 개만 가져오기 - SELECT + id로 조회
						System.out.print("아이디를 입력해주세요 : ");
						String search = sc.nextLine();
						System.out.println("======== 사용자 정보 ========");
//						if(search.equals(id)||search.equals(name)) {}
						pc.searchPerson(search);
						break;
						
					case 4:
						// person 테이블에 데이터 수정 - UPDATE (이름을 입력 받아 주소를 수정)
						System.out.println("사용자 정보를 수정합니다.");
						System.out.print("수정을 원하는 사용자의 이름을 입력해주세요 : ");
						String mName = sc.nextLine();
						System.out.print("변경된 주소를 입력해주세요 : ");
						String mAddr = sc.nextLine();
						pc.updatePerson(mAddr, mName);
						break;
						
					case 5:
						// person 테이블에 데이터 삭제 - DELETE (성인이 아닐 경우 삭제)
						System.out.println("\n성인이 아닌 사용자는 삭제됩니다.\n");
						pc.removePerson();
						break;
					default:
						System.out.println("\n다시 입력해주세요.\n");
				}
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	}

	


