package com.kh.practice2.view;

import java.util.Scanner;

import com.kh.practice2.controller.SnackController;
import com.kh.practice2.model.Snack;

// View : HTML, CSS, JavaScript
// 첫 번째 프로젝트 : JSP
// 두 번째 프로젝트 : React

public class SnackView {
	
	Scanner sc = new Scanner(System.in);
	String kind;
	String name;
	String flavor;
	int numOf;
	int price;
	
	Snack snackData = new Snack(); // 자바스크립트에서도 객체로 값을 한꺼번에 담아서 보냄

	public void input() {
		
		System.out.println("스낵류를 입력하세요.");
		
		System.out.print("종류 : ");
//		String kind = sc.nextLine();
		snackData.setkind(sc.nextLine());
	
		System.out.print("이름 : ");
//		String name = sc.nextLine();
		snackData.setname(sc.nextLine());
		
		System.out.print("맛 : ");
//		String flavor = sc.nextLine();
		snackData.setflavor(sc.nextLine());
		
		System.out.print("개수 : ");
//		int numOf = sc.nextInt();
		snackData.setnumOf(Integer.parseInt(sc.nextLine()));
		
		System.out.print("가격 : ");
//		int price = sc.nextInt();
		snackData.setprice(Integer.parseInt(sc.nextLine()));
}
	
		public void result() {
			SnackController controller = new SnackController();
			System.out.println(controller.saveData(snackData));
			System.out.println(controller.confirmData());
	}
}
