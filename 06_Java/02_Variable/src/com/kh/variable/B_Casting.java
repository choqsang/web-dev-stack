package com.kh.variable;

public class B_Casting {
	
	/*
	 * 형 변환(Casting)
	 * - 값의 타입을 다른 타입으로 변환하는 것
	 * - boolean을 제외한 7개의 기본형은 서로 형변환이 가능
	 * */
	
	public static void main(String[] args) {
		B_Casting casting = new B_Casting();
//		casting.autoCasting();
		casting.casting();
	}
	
	/*
	 * 자동 형 변환 (묵시적 형 변환)
	 * - 자동으로 형 변환이 이루어지기 때문에 따로 형 변환하지 않아도 된다.
	 * */
	public void autoCasting() {
		// 정수
		byte b = 10; // 1byte
		short s = b; // 2byte : 자동 형변환 (byte → short)
		// 작은 그릇에서 큰 그릇으로 옮기는 거라 당연한 것이고 별다른 작업이 없다.
		int i = s; // 4byte
		long l = i; // 8byte
		
		// 실수
		float f = 1; // 4byte
		double d = f; // 8byte
		
		d = i; // int(4,정수) → double(8,실수)
		f = l; // long(8,정수) → float(4,실수)
		// 표현 가능한 수의 범위가 더 넓기 때문에, 아래의 경우도 바이트의 크기와 무관하게 담아진다.
		
		int result = b + s; // byte, short 타입의 데이터는 연산 시 무조건 int타입
		System.out.println(result);
		
		double result2 = 10 + 3.3;
		System.out.println(result2);
	}
	
	
	/*
	 * 강제 형 변환 (명시적 형 변환)
	 * 
	 * (자료형)값;
	 * 
	 * - 범위가 큰 크기의 자료형의 데이터를 작은 크기의 자료형으로 변환하려고 할 때
	 * - 강제 형 변환의 경우 데이터 손실이 발생할 수 있다.
	 * */
	
	public void casting() {
		double d = 4.12345678901234567890; // 소숫점 15자리까지만 출력 가능함
		System.out.println(d);
	
		float f = (float) d; // float에서는 6자리까지만 출력됨 - 강제 형 변환으로 인해 소숫점 이하 강제 손실
		// 그릇이 작은 곳으로 이동하는 것은 부자연스럽고 자동으로 변환되지 않기 때문에 괄호 안에 자료형을 명시하는 것을 통해 변환 가능하다. 
		System.out.println(f);
	
		int i = (int) f;
		System.out.println(i);
		
		int number = 129;
		// => byte값으로 형 변환 : -127
		byte bNumber = (byte) number;
		System.out.println(bNumber);
		
		// char ↔ int : 각 문자들마다 고유한 숫자가 지정되어 있기 때문 (아스키코드, 유니코드)
		// 쌍방향으로 형 변환 가능
		// char는 음수값 저장 불가 => 값의 범위가 0~65535
		
		int num = 'A';
		System.out.println(num); // 65
		
		char ch = 52143;
		System.out.println(ch);
		
	}
		
	
	
	
	
	
}
