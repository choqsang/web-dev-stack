package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import config.ServerInfo;
import controller.BookController;
import controller.MemberController;
import controller.RentController;
import dao.BookDAO;
import dao.MemberDAO;
import dao.RentDAO;
import vo.Member;

public class BookRentApp {

	private Scanner sc = new Scanner(System.in);
	
	// 로그인 했을 시 사용자 정보 담을 객체!
	private Member member = null;
	private BookController bc = new BookController();
	private MemberController mc = new MemberController();
	private RentController rc = new RentController();
	private MemberDAO md;
	private BookDAO bd;
	private RentDAO rd;
	
	
	public static void main(String[] args) throws Exception {
		BookRentApp app = new BookRentApp();
		app.menu();
	}
	
	boolean check = true;
	public void menu() {
		// 최초 비로그인 상태일 때
				// 1. 전체 책 조회 - 로그인 X
				// 2. 회원 가입 - 로그인 X
				// 3. 로그인 - 로그인 X
				
		// 관리자로 로그인 했을 때 (관리자 : admin, 1234)
				// 1. 책 신규 등록 - 로그인 O 
				// 2. 책 삭제 - 로그인 O
				// 3. 로그아웃 - 로그인 O
					
		// 일반회원이 들어왔을 때
				// 1. 회원 탈퇴 - 로그인 O (관리자 X)
				// 2. 로그아웃 - 로그인 O
				// 3. 책 대여 - 로그인 O
				// 4. 내가 대여한 책 조회 - 로그인 O
				// 5. 대여 취소 - 로그인 O
		
		while(check) {
			if(member == null) { 
				// 로그인 X
				titleMenu();
		} else if(member.getId().equals("admin") && member.getPwd().equals("1234")) {
				// 관리자 로그인 O
				adminMenu();
		} else {
				// 일반유저 로그인 O
				geneMenu();
		}
		}
	}
		
	
		public void titleMenu() {
			System.out.println("-----------------");
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 회원 가입");
			System.out.println("3. 로그인");
			System.out.println("-----------------");
			System.out.print("메뉴 번호를 선택해주세요 : ");
			int titleMenu = Integer.parseInt(sc.nextLine());
				
		switch(titleMenu) {
			case 1: // 1. 전체 책 조회
			try {
				System.out.println(bd.printBookAll());
			} catch (SQLException e) {
				e.printStackTrace();
			}
				break;
			
			case 2: // 2. 회원 가입
				Member member = new Member();
				System.out.print("아이디를 입력해주세요 : ");
				String id = sc.nextLine();
				member.setId(id);
				System.out.print("이름을 입력해주세요 : ");
				String name = sc.nextLine();
				member.setName(name);
				System.out.print("비밀번호를 입력해주세요 : ");
				String pwd = sc.nextLine();
				member.setPwd(pwd);
				System.out.print("나이를 입력해주세요 : ");
				int age = Integer.parseInt(sc.nextLine());
				member.setAge(age);
			try {
				md.register(member);
			} catch (SQLException e) {
				e.printStackTrace();
			}
				break;
				
			case 3: // 3. 로그인
				Member lMember = new Member();
				System.out.print("아이디를 입력해주세요 : ");
				String lId = sc.nextLine();
				lMember.setId(lId);
				System.out.print("비밀번호를 입력해주세요 : ");
				String lPwd = sc.nextLine();
				lMember.setPwd(lPwd);
				lMember = mc.login(lId, lPwd);
//				if(member!=null) {
//					System.out.println(member.getName() + "님이 로그인 하셨습니다!");
//				} else {
//					System.out.println("로그인 실패! 다시 입력해주세요.");
//				}
//						
//				md.login(lId, lPwd);
				break;
				
			default:
				System.out.println("다시 입력해주세요.");	
				
		}		
		}
				
		public void adminMenu() {
				System.out.println("-----------------");
				System.out.println("1. 책 신규 등록");
				System.out.println("2. 책 삭제");
				System.out.println("3. 로그아웃");
				System.out.println("-----------------");
				System.out.print("메뉴 번호를 선택해주세요 : ");
				int adminMenu = Integer.parseInt(sc.nextLine());
				
				switch(adminMenu) {
					case 1: // 1. 책 신규 등록
						System.out.print("제목을 입력해주세요 : ");
						String title = sc.nextLine();
						System.out.print("저자를 입력해주세요 : ");
						String author = sc.nextLine();
						System.out.print("연령 제한을 입력해주세요 : ");
						int accessAge = Integer.parseInt(sc.nextLine());
						bc.registerBook(title, author, accessAge);
						break;
						
					case 2: // 2. 책 삭제	
						System.out.print("삭제를 원하시는 도서의 번호를 입력해주세요 : ");
						int bookNo = Integer.parseInt(sc.nextLine());
						bc.sellBook(bookNo);
						break;
						
					case 3: // 3. 로그아웃
						System.out.println("정상적으로 로그아웃 되었습니다.");
						md.logout();
						
					default:
						System.out.println("다시 입력해주세요.");
					}	
				}
				
		public void geneMenu() {
				System.out.println("-----------------");
				System.out.println("1. 회원 탈퇴");
				System.out.println("2. 로그아웃");
				System.out.println("3. 책 대여");
				System.out.println("4. 내가 대여한 책 조회");
				System.out.println("5. 대여 취소");
				System.out.println("-----------------");
				System.out.print("메뉴 번호를 선택해주세요 : ");
				int geneMenu = Integer.parseInt(sc.nextLine());
		
			switch(geneMenu) {
			case 1: // 1. 회원 탈퇴
				System.out.print("아이디를 입력해주세요 : ");
				String dId = sc.nextLine();
				System.out.print("정말 탈퇴하시겠습니까? 탈퇴를 원하신다면 '삭제'라고 입력해주세요.");
				String fCheck = sc.nextLine();
				if(member.getId().equals(dId) && fCheck.equals("삭제")) {
					md.delete(dId);
				}
				break;
				
			case 2: // 2. 로그아웃
				this.member = null;
				break;
				
			case 3: // 3. 책 대여
				System.out.print("아이디를 입력해주세요 : ");
				String rId = sc.nextLine();
				System.out.print("대여를 원하시는 도서의 번호를 입력해주세요 : ");
				int rBookNo = Integer.parseInt(sc.nextLine());
				rc.rentBook(rId, rBookNo);
				break;
				
			case 4: // 4. 내가 대여한 책 조회
				System.out.print("아이디를 입력해주세요 : ");
				String bId = sc.nextLine();
				rc.printRentBook(bId);
				break;
				
			case 5: // 5. 대여 취소
				System.out.print("취소를 원하시는 대여 번호를 입력하세요 : ");
				int rentNo = Integer.parseInt(sc.nextLine());
				rc.deleteRent(rentNo);
				break;
				
			default:
				System.out.println("다시 입력해주세요.");
		}
}
}
		


