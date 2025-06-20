package com.kh.practice;

import java.util.Scanner;

public class OperatorPractice {
	
	Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {

		OperatorPractice o = new OperatorPractice();
//		o.method1();
//		o.method2();
//		o.method3();
//		o.method4();
//		o.method5();
//		o.method6();
//		o.method7();
		o.method8();
		
	}

	//모든 사람이 연필을 골고루 나눠가지려고 한다. 인원 수와 연필 개수를 입력 받고 
	//1인당 동일하게 나눠가진 연필 개수와 나눠주고 남은 연필의 개수를 출력하세요.
	public void method1() {
		System.out.println("인원 수를 입력해주세요.");
		int per = sc.nextInt();
		System.out.println("연필 개수를 입력해주세요.");
		int pen = sc.nextInt();
		
		System.out.println("1인당 연필 "+ pen/per + 
				"자루씩 나눠 가진 후 " + pen%per + "자루가 남았습니다!");
	}
	
	//입력 받은 숫자를 산술 연산자만 사용해서 십의 자리 이하는 버리는 코드를 작성하세요.
	//만약 432이라면 400, 111이라면 100이 출력됩니다.
	public void method2() {
		System.out.println("숫자를 입력해주세요.");
		int num = sc.nextInt();
		System.out.println(num - num%100);
		
	}

	//3개의 수를 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
	public void method3() {
		System.out.println("첫 번째 숫자를 입력해주세요.");
		int num1 = sc.nextInt();
		System.out.println("두 번째 숫자를 입력해주세요.");
		int num2 = sc.nextInt();
		System.out.println("세 번째 숫자를 입력해주세요.");
		int num3 = sc.nextInt();
		
		if(num1 == num2 && num2 == num3) {
			System.out.println("true");
		} else System.out.println("false");
	}

	//입력 받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "짝수가 아니다"를 출력하세요.
	public void method4() {
		System.out.println("하나의 정수를 입력해주세요.");
		int i = sc.nextInt();
		if(i==0) System.out.println("0이다");
		else if (i%2 == 0) System.out.println("짝수다");
		else System.out.println("짝수가 아니다");
	}

	//주민번호(-포함)를 입력받아 남자인지 여자인지 구분하여 출력하세요
	public void method5() {
		System.out.println("주민번호를 입력해주세요. (-포함/숫자 13자리)");
		char code = sc.nextLine().charAt(7);
		if (code == '1' || code == '3') System.out.println("남자");
		else if (code == '2' || code == '4') System.out.println("여자");
		else System.out.println("잘못 입력하셨습니다.");
	}

	//나이를 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 
	//성인(19세 초과)인지 출력하세요.
	public void method6() {
		System.out.println("나이를 입력해주세요.(숫자로만)");
		int age = sc.nextInt();
		// int age = Integer.parseInt(sc.nextLine());
		// System.out.println(age > 19 ? "성인" : age > 13 ? "청소년" : "어린이");
		if (age<=13) System.out.println("어린이");
		else if (age<=19) System.out.println("청소년");
		else System.out.println("성인");
	}

	//사과의 개수와 바구니의 크기(바구니 1개의 들어가는 사과의 개수)를 입력받아
	//필요한 바구니의 수를 출력하세요
	public void method7() {
		System.out.println("사과의 개수를 입력해주세요.");
		int app = sc.nextInt();
		System.out.println("바구니 1개에 들어가는 사과의 개수를 입력해주세요.");
		int bas = sc.nextInt();

		if (app%bas==0) System.out.println("바구니는 총 "+(app/bas)+"개가 필요합니다.");
		else System.out.println("바구니는 총 "+(app/bas+1)+"개가 필요합니다.");
	}
	
	//초 단위 시간을 입력받아 1시간 1분 1초 형식으로 출력
	public void method8() {
		System.out.println("초 단위로 시간을 입력해주세요.");
		int time = sc.nextInt();
//		System.out.println(time/3600 + "시간 "+ (time%3600)/60 + "분 "+ ((time%3600)%60) +"초");
		int hour = time/3600;
		int min = (time%3600)/60;
		int sec = (time%3600)%60;
		System.out.printf("%d시간 %d분 %d초",hour ,min ,sec);
	}
	
}