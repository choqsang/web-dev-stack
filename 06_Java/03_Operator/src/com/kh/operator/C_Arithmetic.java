package com.kh.operator;

public class C_Arithmetic {
	
	/*
	 * 산술 연산자 (사칙연산)
	 * + : 더하기
	 * - : 빼기
	 * * : 곱하기
	 * / : 나누기
	 * % : 나머지 
	 * */

	public static void main(String[] args) {
		C_Arithmetic c = new C_Arithmetic();
//		c.method1();
		c.method2();

	}
	public void method1() {
		int num1 = 10;
		int num2 = 3;
		System.out.println("+ : "+(num1+num2)); // 13 
		// 수식에 문자열이 추가될 경우, 숫자가 문자 취급되어 텍스트 이어짐 현상 발생되니 괄호로 묶어줄 것.
		System.out.println("- : "+(num1-num2)); // 7
		System.out.println("* : "+(num1*num2)); // 30
		System.out.println("/ : "+(num1/num2)); // 3 (자바스크립트와 다르게 정수 타입끼리의 연산이기 때문에 알아서 나누기 몫이 도출됨)
		System.out.println("% : "+(num1%num2)); // 1			
	}
	
	public void method2() {
		int a = 5;
		int b = 10;
		int c = (++a) + b++; // 6+10 =16, b=11
		int d = c / a; // 2 
		int e = c % a; // 4
		int f = e++; // 4, e=5
		int g = (--b) + (d--); // 10 + 2 = 12, d=1
		int h = c-- * b; // 16*10=160, c=15
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h);
		 // 6 + 10 / (14/4) * (12-1) % (6+160) = 39
		// i값은 얼마일까?
		System.out.println(i);
	}
	
	
}
