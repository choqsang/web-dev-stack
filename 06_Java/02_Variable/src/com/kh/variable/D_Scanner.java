package com.kh.variable;

import java.util.Scanner;

public class D_Scanner {
	
	/*
	 * Scanner (prompt와 유사, 대문자로 시작하기 때문에 클래스)
	 * - 화면(콘솔)에서 데이터를 "입력"받는 클래스
	 * 
	 * 1. import java.util.Scanner; 추가
	 * 
	 * 2. Scanner 객체 생성
	 * 	  Scanner sc = new Scanner(System.in);
	 *    
	 * 3. Scanner 메서드 사용
	 *    입력값이
	 *    	- 문자(열)일 때 : sc.next() >> 공백 있을 경우, 공백 이전까지
	 *    				  sc.nextLine() >> 공백 포함 엔터 전까지 (얘만 다름) 
	 *    	- 정수일 때 : sc.nextInt()
	 *    	- 실수일 때 : sc.nextFloat(), sc.nextDouble()
	 *    
	 *    	=> 권장하기는 sc.nextLine()만 사용하는 것을 권장!
	 *    	   얘만 enter 처리 / 라인을 쓰든, 라인을 아예 안쓰든 통일하는 게 좋다.
	 *    
	 * */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // 객체 생성 시 뜨는 오류에서 import를 클릭하여도 된다.
		
		System.out.print("당신의 이름은 무엇입니까? > ");
		String name = sc.next(); // enter 처리 X
		sc.nextLine(); // 남아있는 enter 처리
		
		System.out.print("당신의 나이는 몇 살입니까? > ");
//		int age = sc.nextInt(); // enter 처리 X
//		sc.nextLine(); // enter 처리 O
		
		// String => int로 변환
		int age = Integer.parseInt(sc.nextLine());
		
		System.out.print("당신의 집은 어디입니까? > ");
		String addr = sc.nextLine();
		
		System.out.print("당신의 키는 몇입니까? (소숫점 첫째 자리까지) > ");
//		double tall = sc.nextDouble();
		double tall = Double.parseDouble(sc.nextLine());
		
		System.out.print("당신의 성별은 무엇입니까? (남/여) > ");
//		String gender = sc.nextline();
		char gender = sc.nextLine().charAt(0);
		
//		System.out.println("당신의 이름은 " + name + "이고, 성별은 " + gender + "자, 나이는 " + age + "살 입니다. \n"
//				+ "사는 곳은 " + addr + ", 키는 " + tall + "cm 입니다.");
	
		// 동일한 결과값을 printf로 나타내보자.
		System.out.printf("이름은 %s, 성별은 %c자, 나이는 %d살, 사는 곳은 %s, 키는 %.1fcm입니다.",
				name, gender, age, addr, tall);
						
	}

}
