package com.kh.condition;

import java.util.Scanner;

public class B_Switch {

	Scanner sc = new Scanner(System.in);
	
	/*
	 * switch문
	 * 
	 * switch(조건식){
	 * 		case 값1 : 
	 * 			조건식의 결과가 값1과 같은 경우 실행
	 * 			break;
	 * 		case 값2 :
	 * 			조건식의 결과가 값2와 같은 경우 실행
	 * 			break;
	 * 		...
	 * 		default :
	 * 			조건식의 결과가 일치하는 case문이 없을 때 실행
	 * } 
	 * 
	 * - case 문의 수는 제한이 없다
	 * - 조건식 결과는 정수, 문자, 문자열이어야 한다
	 * - 조건문을 빠져나가려면 break가 필요하다
	 * - default 문은 생략 가능하다
	 * */
	
	/*
	 * 숫자를 입력받아
	 * 1일 경우 "빨간색입니다"
	 * 2일 경우 "파란색입니다"
	 * 3일 경우 "초록색입니다"
	 * 잘못 입력했을 경우 "잘못입력했습니다"
	 * */
	
	public void method1() {
		System.out.println("숫자를 입력해주세요.");
		int num = sc.nextInt();
		
		switch(num) {
			case 1:
				System.out.println("빨간색입니다");
				break;
			case 2:
				System.out.println("파란색입니다");
				break;
			case 3:
				System.out.println("초록색입니다");
				break;
			default:
				System.out.println("잘못입력했습니다");
		}
	}
	
	/*
	 * 주민번호를 입력받아 "남자"인지 "여자"인지 출력
	 * 그 외에는 "사람이 아닙니다"
	 * 주민번호 입력 : 000000-0000000
	 * 남자
	 * */
	
	public void method2() {
		System.out.println("주민번호 입력 : 000000-0000000");
		String code = sc.nextLine();
		String noStr = code.substring(7,8);
		
		System.out.println(noStr);
//		if (code.charAt(7) == '1' || code.charAt(7) == '3') {
//			System.out.println("남자");
//		} else if (code.charAt(7) == '2' || code.charAt(7) == '4') { 
//			System.out.println("여자");
//		} else 
//			System.out.println("사람이 아닙니다");
	
	switch(code.charAt(7)) {
		case '1', '3': // 위 문자열에서 추출한 noStr의 경우, case "1":(쌍따옴표)로 확인 가능
				  // 혹은 Integer.parseInt(noStr) 를 통해 정수 변환도 가능하다. case 1: 로 가능
				  // 최근 버전 기준으로 case를 묶어서 표현할 수 있음 (원칙적으로는 1개씩)
			System.out.println("남자");
			break;
		case '2', '4':
			System.out.println("여자");
			break;
		default: System.out.println("사람이 아닙니다");
	}
}	
	
	
	public static void main(String[] args) {
		B_Switch b = new B_Switch();
//		b.method1();
		b.method2();
		
	}
	
}
