package com.kh.operator;

import java.util.Scanner;

public class E_Logical {

	/*
	 * 논리 연산자
	 * - 두 개의 논리값을 연산해주는 연산자
	 * - 논리연산한 결과마저 논리값
	 * 
	 * 논리값 && 논리값 (and) : 왼쪽, 오른쪽 둘 다 true일 경우만 결과값이 true
	 * 논리값 || 논리값 (or) : 왼쪽, 오른쪽 둘 중에 하나라도 true일 경우 결과값이 true
	 * 
	 * */
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		E_Logical e = new E_Logical();
//		e.method1();
//		e.method2();
		e.practice();
	}

	public void method1() {
		// 사용자가 입력한 정수값이 1부터 100사이의 값인지 확인
		System.out.println("정수값 입력 > ");
		int number = sc.nextInt();
//		System.out.println(1<=number && number<=100);
		boolean result = 1<=number && number<=100;
		System.out.println(result);
	}
	
	public void method2() {
		int number = 10;
		boolean result = false;
		
		// Short Cut Evaluation
		// true && true = true (모두 true여야 결과값 true)
		// true && false = false
		// false && true = false (전위 결과값이 false인 경우, 뒤에 나오는 조건은 계산하지 않고 넘어감)
		// false && false = false
		// : && 연산자를 기준으로 앞에서 이미 false면 굳이 뒤쪽 연산 수행 하지 않음! 
		
		result = (number < 5) && (++number > 0);
		System.out.println(result); // false
		System.out.println(number); // 10

//		result = (number > 5) && (++number > 0);
		System.out.println(result); // true
		System.out.println(number); // 11
		
		// true || true = true
		// true || false = true
		// false || true = true
		// false || false = false
		// : || 연산자를 기준으로 앞에서 이미 true면 굳이 뒤쪽 연산 수행 하지 않음!
		
		result = (number < 20) || (++number > 0);
		System.out.println(result); // true
		System.out.println(number); // 10
	}
	
	/*
	 * 문제!
	 * 사용자가 입력한 문자 값이 알파벳인지 확인하기
	 * A~Z: 65~90, a~z: 97~122
	 * */
	
	public void practice() {
		System.out.println("문자를 입력해주세요.");
		char alph = sc.nextLine().charAt(0);
		int abet = (int)alph; // 값 비교를 위해서는 굳이 정수 치환을 할 필요는 없다. 아래의 결과값들은 모두 동일.
//		System.out.println(65<=abet&&abet<=90 || 97<=abet&&abet<=122);
//		System.out.println('A'<=abet&&abet<='Z' || 'a'<=abet&&abet<='z');
		boolean result = 65<=alph&&alph<=90 || 97<=alph&&alph<=122;
		System.out.println("알파벳이 맞는가? " + result);
	}
	
}




