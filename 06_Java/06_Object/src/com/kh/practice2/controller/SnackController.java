package com.kh.practice2.controller;

import java.util.Scanner;

import com.kh.practice2.model.Snack;


public class SnackController {
	
	private Snack snack = new Snack();
	
	public void saveData()
	{Scanner sc = new Scanner(System.in);
		System.out.println("스낵류를 입력하세요.");
		
		System.out.print("종류 : ");
		String kinds = sc.nextLine();
		snack.setkind(kinds);
		
		System.out.print("이름 : ");
		String names = sc.nextLine();
		snack.setname(names);
		
		System.out.print("맛 : ");
		String flavors = sc.nextLine();
		snack.setflavor(flavors);
		
		System.out.print("개수 : ");
		int numOfs = sc.nextInt();
		snack.setnumOf(numOfs);
		
		System.out.print("가격 : ");
		int prices = sc.nextInt();
		snack.setprice(prices);
		
		System.out.println("저장 완료되었습니다.");
		
}
	
	
	public void confirmData() {
		
		System.out.println(snack.getkind()+ "("+snack.getname()+" - "
				+snack.getflavor()+") "+snack.getnumOf()+"개 " 
				+snack.getprice()+"원");
	}
		
}
