package com.kh.practice;

import java.util.Scanner;

public class VariablePractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		VariablePractice v = new VariablePractice();
		v.method1();
		v.method2();
		v.method3();
		v.method4();
		v.method5();
		v.method6();
		v.method7();
	}
	
	/*
	 * 영화관의 요금표는 다음과 같다.
	 *  - 성인 : 10000원
	 *  - 청소년 : 7000원
	 * 
	 * 성인 2명과 청소년 3명이 영화를 보려고 할 때 지불해야 할 금액을 계산 후 출력하세요.
	 * */
	public void method1() {
		int adult = 10000;
		int teenager = 7000;
		int ticket = adult * 2 + teenager * 3;
		System.out.println(ticket+"원");
	}
	
	/*
	 * x=5, y=7, z=9의 값을 직접 변경하지 않고 변수를 사용하여
	 * 
	 * x=7
	 * y=9
	 * z=5
	 * 
	 * 로 출력하세요.
	 * */
	public void method2() {
		int x = 5;
		int y = 7;
		int z = 9;
		
		// 코드 적어주세요!

		System.out.println("x=" + y + "\ny=" + z + "\nz=" + x);

	}
	

	/*
	 * 정수 두 개를 입력 받아 두 수의 합(+), 차(-), 곱(*), 나누기(/)한 몫을 출력하세요.
	 * 
	 * 첫 번째 정수 : 23
	 * 두 번째 정수 : 7
	 * 더하기 : 30
	 * 빼기 : 16
	 * 곱하기 : 161
	 * 나누기 몫 : 3
	 * */
	public void method3() {
		System.out.println("첫 번째 숫자를 입력해주세요.");
		int a = sc.nextInt();
		System.out.println("두 번째 숫자를 입력해주세요.");		
		int b = sc.nextInt();
		System.out.println("두 수의 합은 " + (a+b) + ", 차는 " + (a-b) + 
				", 곱은 "+ (a*b) + ", 나누기는 " + (a/b) + " 나머지는 "+ (a%b) +"입니다.");
	}

	/*
	 * 가로, 세로 값을 입력 받아 사각형의 면적과 둘레를 계산하여 출력하세요.
	 * 공식) 면적 : 가로 * 세로
	 *       둘레 : (가로 + 세로) * 2
	 * 
	 * 가로 : 13.5
	 * 세로 : 41.7
	 * 면적 : 562.95
	 * 둘레 : 110.4
	 * */
	public void method4() {
		System.out.println("가로 길이를 입력해주세요.");
		double garo = sc.nextDouble();
		System.out.println("세로 길이를 입력해주세요.");		
		double sero = sc.nextDouble();
		System.out.println("도형의 면적은 " + (garo * sero) + 
				"이며, 둘레는 " + ((garo + sero) * 2) +"입니다.");
	}

	/*
	 * 영어 문자열 값을 입력 받아 문자에서 첫번째, 두번째, 마지막 글자(문자열.length())를 출력하세요.
	 * 
	 * 문자열을 입력하세요 : apple
	 * 첫번째 문자 : a
	 * 두번째 문자 : p
	 * 마지막 문자 : e
	 * */
	public void method5() {

		System.out.println("영어로 된 문자열을 입력해주세요.");
		String word = sc.next();
		char word0 = word.charAt(0);
		char word1 = word.charAt(1);
		char words = word.charAt(word.length()-1);
			
		System.out.println("첫 번째 문자 : " + word0 +
						   "\n두 번째 문자 : " + 	word1 +
						   "\n마지막 문자 : "	 + words);
	}

	/*
	 * 문자 하나를 입력 받아 그 문자와 다음 문자의 유니코드를 출력하세요.
	 * 
	 * 문자 : A
	 * A unicode : 65
	 * B unicode : 66
	 * */
	public void method6() {
		System.out.println("문자 하나를 입력해주세요.");
		String uni = sc.next();
		char aa = (int)uni;
		System.out.println(aa);
	}
	
	/*
	 * 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
	 * 
	 * 국어 : 75
	 * 영어 : 63
	 * 수학 : 80
	 * 총점 : 218
	 * 평균 : 72.67
	 * */
	public void method7() {
		System.out.println("국어 점수를 입력해주세요.");
		int kor = sc.nextInt();
		System.out.println("영어 점수를 입력해주세요.");		
		int eng = sc.nextInt();
		System.out.println("수학 점수를 입력해주세요.");		
		int math = sc.nextInt();
		System.out.println("총점 평균.");
	}

}