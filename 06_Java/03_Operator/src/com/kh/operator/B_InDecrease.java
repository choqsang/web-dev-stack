package com.kh.operator;

public class B_InDecrease {
	
	/*
	 * 증감 연산자
	 * 
	 * (증감연산자)값; 또는 값(증감연산자);
	 * 
	 * - 값을 1 증가시키거나 1 감소시키는 연산자
	 * - ++ : 값 1 증가
	 * - -- : 값 1 감소
	 * - (증감연산자)값 : 전위 연산으로 먼저 증감 연산을 수행하고 다른 연산을 수행
 	 * - 값(증감연산자) : 후위 연산으로 먼저 다른 연산을 수행하고 증감 연산을 수행
	 * */
	
	public static void main(String[] args) {
		B_InDecrease b = new B_InDecrease();
//		b.method1();
		b.method2();		
	}
	
	public void method1() {
		int number = 10;
		// 전위 연산자 : 연산자 적용 이후에 출력
		System.out.println("1회 수행 후 값 : " + ++number); // 11
		System.out.println("2회 수행 후 값 : " + ++number); // 12
		System.out.println("전위 연산자 적용 후 : " + number); // 12
		
		int number2 = 10;
		// 후위 연산자 : 출력 먼저 그 이후에 연산자 적용
		System.out.println("1회 수행 후 값 : " + number2++); // 10, number2=11
		System.out.println("2회 수행 후 값 : " + number2++); // 11, number2=12
		System.out.println("후위 연산자 적용 후 : " + number2); // 12
	}
	
	public void method2() {
		int number = 20;  // 각 함수 내 동일한 변수명 사용은 가능하나, 외부(전역변수)에 기재될 경우 에러! 
		int result = number++ *3; // 20 * 3 : 후위 연산자 적용 시점 이전에 출력과 곱연산 적용
		System.out.println(number); // 21
		System.out.println(result); // 60
		
		int number1 = 10;
		int number2 = 20;
		int number3 = 30;
		
		System.out.println(number1++); // 10, number1=11
		System.out.println((++number1)+(number2++)); // 12+20= 32, number2=21		
		System.out.println((number1++)+(--number2)+(number3--)); // 12+20+30= 62
		
		System.out.println(number1); // 13
		System.out.println(number2); // 20
		System.out.println(number3); // 29
	}
	
	
	
	
}
