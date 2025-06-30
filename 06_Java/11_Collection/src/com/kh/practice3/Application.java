package com.kh.practice3;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice3.controller.MusicController;
import com.kh.practice3.model.Music;

public class Application {
	
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();

	public static void main(String[] args) {
		
		Application app = new Application();
		app.menu();

	}
	
	public void menu() {
		try {
			boolean check = true;
			while(check) {
				System.out.println("===== 메인 메뉴 =====");
				System.out.println("1. 특정 곡 추가");
				System.out.println("2. 전체 곡 목록 출력");
				System.out.println("3. 특정 곡 검색");
				System.out.println("4. 특정 곡 수정");
				System.out.println("5. 특정 곡 삭제");
				System.out.println("6. 종료");
				System.out.println("7. (신규) 가수 정렬 기능");
				System.out.println("8. (신규) 곡 정렬 기능");
				System.out.print("메뉴 번호 입력 : ");
				switch(Integer.parseInt(sc.nextLine())) {
					case 1:
						mc.addList();
						break;
					case 2:
						mc.printAll();
						break;
					case 3:
						mc.searchMusic();
						break;
					case 4:
						mc.updateMusic();
						break;
					case 5:
						mc.removeMusic();
						break;
					case 6:
						System.out.println("종료");
						check = false;
						break;
					case 7:
						mc.descArtist();
						break;
					case 8:
						mc.ascSong();
						break;
					default: 
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
			}
		} catch(Exception e) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			e.printStackTrace();
			menu();
		}
	}
	
	
	

}