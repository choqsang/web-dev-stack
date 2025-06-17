package com.kh.condition;

import java.util.Scanner;

public class A_If {
		
	Scanner sc = new Scanner(System.in);
		
	/*
	 * if문
	 * 
	 * if(조건식) {
	 * 		조건식이 참(true)일 때 실행
	 * } else {
	 * 		조건식이 거짓(false)일 때 실행
	 * }
	 * - 보통 조건식에는 비교연산자, 논리연산자를 주로 사용
	 * */
	public void method1() {
		// 입력받은 성적이 60점 이상이면 "합격입니다" 출력
		// 아닐 경우 "불합격입니다" 출력
		System.out.println("성적을 입력해주세요.");
		int score = sc.nextInt();
		if (score >= 60) {
			System.out.println("합격입니다.");
		} else System.out.println("불합격입니다.");
		
		// 한 줄인 경우에만 {중괄호} 생략 가능
//		if(score>=60) System.out.println("합격");
//		else System.out.println("불합격");
		
		// 삼항연산자 (조건식?참:거짓)
//		System.out.println(score>=60 ? "합격" : "불합격");
	}
	
	public void method2() {
		// 본인의 이름을 입력했을 때 본인이면 "본인이다", 아니면 "본인이 아니다" 출력
		System.out.println("이름을 입력해주세요.");
		String name = sc.next();
		char name1 = name.charAt(0);
		char name2 = name.charAt(1);
		char name3 = name.charAt(2);
		
		if (name1 == '조' && name2 == '규' && name3 == '상')
			System.out.println("본인이다");
		else System.out.println("본인이 아니다");
		
		System.out.println("name : " + System.identityHashCode(name));
		System.out.println("조규상 : " + System.identityHashCode("조규상"));
		// String(문자열)은 클래스이기 때문에 값 자체가 아닌 주소로 저장된다.
		// 위 명령어를 통해 확인해보면 메모리 주소가 서로 달라 '==' 만으로는 true값을 도출할 수 없다.
		// 따라서, 아래 equals를 활용하여 문자열 내용에 대한 비교가 가능하다!
		
		if (name.equals("조규상")) {
			System.out.println("본인이다");
		} else {
			System.out.println("본인이 아니다");
		}
		
	}
	/*
	 * if - else if - else 문
	 * 
	 * if(조건식1) {
	 * 		조건식1이 참(true)일 때 실행
	 * } else if(조건식2) {
	 * 		조건식1이 거짓(false)이면서 조건식2이 참(true)일 때 실행
	 * } else {
	 * 		조건식1, 조건식2 모두 거짓(false)일 때 실행
	 * }
	 * - else if의 수는 제한이 없다
	 * */
	
	/*
	 * 사용자에게 점수(0~100)를 입력받아서 점수별로 등급 출력
	 * - 90점 이상은 A등급
	 * - 90점 미만 80점 이상은 B등급
	 * - 80점 미만 70점 이상은 C등급
	 * - 70점 미만 60점 이상은 D등급
	 * - 60점 미만은 F등급
	 * */

	public void method3() {
		System.out.println("점수를 입력해주세요. (0~100점)");
		int score = sc.nextInt();
//		if (score>=90) { 
//			System.out.println("A등급");
//		} else if (score>=80) { 
//			System.out.println("B등급");
//		} else if (score>=70) { 
//			System.out.println("C등급");
//		} else if (score>=60) { 
//			System.out.println("D등급");
//		} else System.out.println("F등급");
		
		char grade = '\u0000'; // char 변수 선언 및 초기화
		
		if(score < 0 || score > 100) {
			System.out.println("잘못된 입력값입니다.");
			return; // 리턴을 만나는 순간 메서드 종료됨, 뒤에 위치한 명령어들 모두 실행 불가
		}
		else if(score >= 90) grade = 'A';
		else if(score >= 80) grade = 'B';
		else if(score >= 70) grade = 'C';
		else if(score >= 60) grade = 'D';
		else grade = 'F';
		System.out.println(grade + " 등급");
	}
	
	/*
	 * 세 정수를 입력했을 때 짝수만 출력
	 * 
	 * num1 입력 : 3
	 * num2 입력 : 4
	 * num3 입력 : 8
	 * 4
	 * 8
	 * */
	
	public void method4() {
		System.out.println("첫 번째 정수를 입력해주세요.");
		int num1 = sc.nextInt();
		System.out.println("두 번째 정수를 입력해주세요.");
		int num2 = sc.nextInt();
		System.out.println("세 번째 정수를 입력해주세요.");
		int num3 = sc.nextInt();
		
		if(num1%2==0) System.out.println(num1);
		if(num2%2==0) System.out.println(num2);
		if(num3%2==0) System.out.println(num3);
	}
	
	
	public static void main(String[] args) { // 메서드 실행 용도의 메인이기 때문에, 굳이 최상단에 위치할 필요는 없다.
		A_If a = new A_If();
//		a.method1();
//		a.method2();
//		a.method3();
		a.method4();
	}

}