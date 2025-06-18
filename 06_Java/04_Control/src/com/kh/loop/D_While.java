package com.kh.loop;

import java.util.Random;
import java.util.Scanner;

public class D_While {

	Scanner sc = new Scanner(System.in);
	
	/*
	 * while문
	 * 
	 * while(조건식) {
	 * 		조건이 true일 경우 계속 실행
	 * }
	 * */
	
	// 1~5까지 출력
	public void method1() {
		int i = 1;
		while (i<=5) {
			System.out.println(i);
			i++;
		}
	}
	
	/*
	 * 무한루프 & break문
	 * - switch, 반복문의 실행을 중지하고 빠져나갈 때 사용
	 * - 반복문이 중첩되는 경우 break문이 포함되어 있는 반복문에서만 빠져나간다
	 * */ 
	public void method2() {
		while (true) {
			System.out.print("숫자 입력 > ");
			int num = sc.nextInt();
			System.out.println(num);
			// 숫자가 0인 경우 중지!
			if(num == 0) break;
		}
	}
	
	/*
	 * do {
	 * 		실행 코드
	 * } while(조건식);
	 * - 조건과 상관없이 무조건 한 번은 실행
	 * */
	
	public void method3() {
		int number = 1;
		
		while(number == 0) {
			System.out.println("while");
		}
		do {
			System.out.println("do-while");
		} while(number == 0);
	}
	
	/*
	 * 숫자 맞히기 게임
	 * 1과 100사이의 값 중에 정답을 저희가 정하고
	 * 컴퓨터(random)가 맞히도록! 몇 번만에 끝내는 지 출력!
	 * 해당 숫자보다 정답이 높으면 Up! 낮으면 Down!
	 * */
	public void method4() {
		
		System.out.println("1부터 100사이에 숫자를 입력해주세요.");
		int pass = sc.nextInt();
		int min = 1;
		int max = 100;
		int count = 0;
		while (true) {
			count++;
		int random = (int) (Math.random() *(max-min+1) +min); // min~max 범위의 경우, random*(max-min+1) +min 형태이다.
//		System.out.println(random);
			if (random < pass) {
				System.out.println(random + " : Up!");
				min = random +1;
			}
			else if (random > pass) {
				System.out.println(random + " : Down!");
				max = random -1;
			}
			else if (random == pass) {
				System.out.println(random + " : 정답! " + count + "번의 시도 끝에 성공했습니다.");
			break;
			}
		}			  
	}
	
	/*
	 * 숫자 맞히기 게임2
	 * 컴퓨터(random) 1과 100사이의 값 중에 무작위로 정하고
	 * 우리가 정답을 맞히도록! 몇 번만에 끝내는 지 출력!
	 * 해당 숫자보다 정답이 높으면 Up! 낮으면 Down!
	 * */
	public void method5() {
		
		int min = 1;
		int max = 100;
		int count = 0;
		int random = (int) (Math.random() *(max-min+1) +min);
		
		while (true) {
			System.out.println("1부터 100사이에 숫자를 입력해주세요.");
			int ans = sc.nextInt();
			count++;
		if (ans<random) {
			System.out.println(ans + " : Up!");
		} else if (ans>random) {
		System.out.println(ans + " : Down!");
		} else { 
			System.out.println(ans + " : 정답! " + count + "번의 시도 끝에 성공했습니다.");
			break;
			} 
		}
	}
	
	/*
	 * -----------------------------
	 * 1.예금 | 2.출금 | 3.잔고 | 4.종료
	 * -----------------------------
	 * 선택 > 1
	 * 예금액 > 10000
	 * -----------------------------
	 * 1.예금 | 2.출금 | 3.잔고 | 4.종료
	 * -----------------------------
	 * 선택 > 2
	 * 출금액 > 5000
	 * -----------------------------
	 * 1.예금 | 2.출금 | 3.잔고 | 4.종료
	 * -----------------------------
	 * 선택 > 3
	 * 잔고 확인 > 5000
	 * -----------------------------
	 * 1.예금 | 2.출금 | 3.잔고 | 4.종료
	 * -----------------------------
	 * 선택 > 4
	 * 프로그램 종료
	 * */
	
	public void method6() {
		String print = "------------------------------\r\n"
				+ " 1.예금 | 2.출금 | 3.잔고 | 4.종료\r\n"
				+ "------------------------------";
		int acc = 10000;	
		
		while (true) {
		System.out.print(print + "\n선택 > ");
		int opt = sc.nextInt();
		
		if(opt==1) {System.out.print("예금액 > ");
			int in = sc.nextInt();
			acc += in;
			System.out.println(in + "원 입금 반영되었습니다. \n누적 금액 : " + acc + "원");
			continue;}
		else if(opt==2) {System.out.print("출금액 > ");
			int out = sc.nextInt(); 
			acc -= out;
			System.out.println(out + "원 출금 반영되었습니다. \n누적 금액 : " + acc + "원");
			continue;}
		else if(opt==3) {System.out.println("잔고 확인 > 현재 "+ acc + "원 확인됩니다.");
			continue;}
		else if(opt==4) {System.out.print("프로그램 종료"); break;
		}
		else {System.out.println("정확한 값을 입력해주세요."); continue;
		} 
	}
		
}
	
//	public void method6() {
//		int account = 0;
//		int deposit = 0;
//		int withdrawal = 0;
//		boolean check = true; 
//		while(check)
//		while(true) {
//			System.out.println("----------------------------------");
//			System.out.println(" 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
//			System.out.println("----------------------------------");
//			System.out.print("선택 > ");
//			int select = sc.nextInt();
//			switch(select) {
//				case 1:
//					System.out.print("예금액 > ");
//					deposit = sc.nextInt();
//					account += deposit;
//					break;
//				case 2:
//					System.out.print("출금액 > ");
//					withdrawal = sc.nextInt();
//					account -= withdrawal;
//					break;
//				case 3:
//					System.out.println("잔고 > " + account);
//					break;
//				case 4:
//					System.out.println("프로그램을 종료합니다.");
//					return; // check = false;
//				default: System.out.printf("\n제시된 숫자를 선택해주세요.\n");
//			}
//		}
//	}
	
	public static void main(String[] args) {
		D_While d = new D_While();
//		d.method1();
//		d.method2();
//		d.method3();
//		d.method4();
//		d.method5();
		d.method6();
	}

}
