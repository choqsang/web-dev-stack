package com.kh.practice;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.practice.controller.RockPaperScissorController;
import com.kh.practice.model.RockPaperScissor;
import com.kh.practice.view.RockPaperScissorView;

class LoopPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		LoopPractice l = new LoopPractice();
//		l.method1();
//		l.method2();
//		l.method3();	
//		l.method4();
//		l.method5();
//		l.method6();
		l.method6_3();
		
	}
 
    /*
        사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오.
        사용자 입력 : 5
        5
        4
        3
        2
        1
     */
    public void method1() {
    	System.out.print("사용자 입력 (숫자 1~100) : ");
    	int countdown = sc.nextInt();
    	for (int i=countdown; i>0; i--) {
    		System.out.println(i);
    	}
    }

    // 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
    public void method2() {
    	
    	int oddeven = 0;
    	int sum = 0;
    	int count = 0;
    	
    	while (true) { // while(sum<100) 으로도 반복 조건을 제한할 수 있음.
    		oddeven++;
    		count++;
    		if (oddeven%2 == 1) {
    			sum += oddeven;
    	}
    		else if (oddeven%2 == 0) {
    			sum -= oddeven;
    	}
//    		System.out.println(sum);
    		if (sum>=100) break;
    	} 	System.out.println(count+"까지 더하면 총합이 100 이상 도달한다.");
    }

    /*
        사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요. 

        문자열 : banana
        문자 : a
        banana 안에 포함된 a 개수 : 3

    */
    public void method3() {
		System.out.println("문자열을 입력해주세요.");
		String str = sc.nextLine();
		System.out.println("검색하실 문자를 입력해주세요.");
		char ch = sc.nextLine().charAt(0);
		int count = 0;		
		
		for (int i=0; i<str.length(); i++) {
//			System.out.println(str.charAt(i));
			if (ch==str.charAt(i)) {
				count++;
				} 
		} 	System.out.println(str + " 안에 포함된 "+ ch + " 개수 : " + count);			
    }	

    /*
        0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10)
        7
        3
        4
        2
        3
        4
        0
     */
    public void method4() {
    	
    	int count = 0;
    	while (true) {
    		count++;
    		int random = (int)(Math.random() * 11);
    		System.out.println(random);
    		
    		if (random == 0) {
    			System.out.print(count + "회만에 성공!"); break;
    		}
    	}
    }

    /*
        주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)

        1 : 3
        2 : 2
        3 : 1
        4 : 0
        5 : 4
        6 : 0

     */
    public void method5() {
    	int count1 = 0;
    	int count2 = 0;
    	int count3 = 0;
    	int count4 = 0;
    	int count5 = 0;
    	int count6 = 0;
    	
    	for (int i = 1; i<=10; i++) {
    		int random = (int)(Math.random() * 6+1);
//    		System.out.println(random);
    		
    		if (random == 1) {count1++;}
    		else if (random == 2) {count2++;}
    		else if (random == 3) {count3++;}
    		else if (random == 4) {count4++;}
    		else if (random == 5) {count5++;}
    		else if (random == 6) {count6++;} 
    	}
    		System.out.println("1 : "+count1+"\n2 : "+count2+"\n3 : "
    				+count3+"\n4 : "+count4+"\n5 : "+count5+"\n6 : "+count6);
    		
		int[] dice = new int[6]; // dice[0] : 1, ... dice[5] : 6
		
		for(int i = 1; i <= 10; i++) {
    		int random = (int) (Math.random() * 6); // 1 ~ 6 -> 0 ~ 5
    		dice[random]++;
    	}
    	for(int i = 0; i < dice.length; i++) System.out.println((i + 1) + ": " + dice[i]);
    }
    
    /*
        사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 
        컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요.
        사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.

        당신의 이름을 입력해주세요 : 김미경
        가위바위보 : 가위
        컴퓨터 : 가위
        김미경 : 가위
        비겼습니다.

        가위바위보 : 가위 
        컴퓨터 : 바위
        김미경 : 가위
        졌습니다 ㅠㅠ

        가위바위보 : 보
        컴퓨터 : 바위
        김미경 : 보
        이겼습니다 !
	    비긴 횟수 : 1, 진 횟수 : 1, 이긴 횟수 : 1
    */
    public void method6() {
    	
    	System.out.print("당신의 이름을 입력해주세요 : ");
    	String name = sc.nextLine();
    	
    	int countWin = 0;
    	int countLose = 0;
    	int countDraw = 0;
    	
    while (true) {
    	int rsp = (int)(Math.random() * 3);
    	// 가위: 0, 바위: 1, 보: 2
    	String rspstr = "";
    	switch (rsp) {
    	case 0 : rspstr = "가위"; break;
    	case 1 : rspstr = "바위"; break;
    	case 2 : rspstr = "보"; break;
    	}
    	    	
    	System.out.print("가위바위보 : ");
    	String player = sc.nextLine();
    	int pint = 0;
    	switch (player) {
    	case "가위" : pint = 0; break;
    	case "바위" : pint = 1; break;
    	case "보" : pint = 2; break;
    	}    	
    	
    	System.out.println("컴퓨터 : " + rspstr);
    	System.out.println(name + " : " + player);
    	   	
    	if (pint-rsp==1||pint-rsp==-2) {
    		countWin++;
    		System.out.println("이겼습니다!");
    		break;
    	}
    	else if(rsp==pint) {
    		countDraw++;
    		System.out.println("비겼습니다.");
    		continue;
    	} else {
    		countLose++;
    		System.out.println("졌습니다 ㅠㅠ");
    		continue;
    	} 
    }	
    System.out.println("비긴 횟수 : " + countDraw + ", 진 횟수 : " + countLose + ", 이긴 횟수 : " + countWin);
    }

    /*
     * 
     * public void method6() {
    	int win = 0;
    	int lose = 0;
    	int draw = 0;
    	
    	System.out.print("당신의 이름을 입력해주세요 : ");
    	String name = sc.nextLine();
    	
    	while(true) {
    		System.out.print("가위바위보 : ");
    		String input = sc.nextLine();
    		
    		// 컴퓨터 - 0 : 가위, 1 : 바위, 2 : 보
    		int computer = (int)(Math.random() * 3);
    		String computerName = "";
    		switch(computer) {
	    		case 0:
	    			computerName = "가위";
	    			break;
	    		case 1:
	    			computerName = "바위";
	    			break;
	    		case 2:
	    			computerName = "보";
	    			break;
    		}
    		System.out.println("컴퓨터 : " + computerName);
    		System.out.println(name + " : " + input);
    		
    		
    		if(input.equals(computerName)) { // 비겼을 경우
    			System.out.println("비겼습니다.");
    			draw++;
    		} else if(
    				input.equals("가위") && computerName.equals("보")
    				|| input.equals("바위") && computerName.equals("가위")
    				|| input.equals("보") && computerName.equals("바위")
    				) { // 이겼을 경우
    			System.out.println("이겼습니다!!");
    			win++;
    			System.out.println("비긴 횟수 : " + draw
    								+ ", 진 횟수 : " + lose
    								+ ", 이긴 횟수 : " + win);
    			break;
    		} else { // 졌을 경우
    			System.out.println("졌습니다 ㅠㅠ");
    			lose++;
    		}
    	}
    	
    	
    	String[] rps = {"가위", "바위", "보"};
   		// 컴퓨터 - 0 : 가위, 1 : 바위, 2 : 보
    		int computer = (int)(Math.random() * 3);
    		
    	// 사용자는 값으로 인덱스를 찾으면 어떨까?
    	// 배열에서 값으로 인덱스 찾기
    }
		// MVC패턴에 맞게 (객체지향적으로/ 별도클래스생성)
		// ALT + SHIFT + S : 
		//새로운 모델에서 Generate Constructors from Superclass 눌러서 적용
		// Generate Constructors using fields

 */
    public void method6_3() {
    	
    	RockPaperScissorView view = new RockPaperScissorView();
    	view.gameStart();
    	
//    	RockPaperScissor rpsModel = new RockPaperScissor();
//    	String[] rps = rpsModel.getRps();
//    	int win = rpsModel.getWin();
//    	int lose = rpsModel.getLose();
//    	int draw = rpsModel.getDraw();
    	
//    	RockPaperScissorController controller = new RockPaperScissorController();
//    	private int computer;
//    	
//    	System.out.print("당신의 이름을 입력해주세요 : ");
//    	String name = sc.nextLine();
//    	
//    	while(true) {
//    		System.out.print("가위바위보 : ");
//    		String input = sc.nextLine();
//    		
//    		// 컴퓨터 - 0 : 가위, 1 : 바위, 2 : 보
//    		computer = (int)(Math.random() * 3);
//    		
//    		// 컴퓨터는 인덱스로 값을 찾음!
//    		System.out.println("컴퓨터 : " + controller.randomComputer());    		
//    		System.out.println(name + " : " + input);
//    		
//    		// 컴퓨터 랜덤값
//    		public int computer() {
//    			return computer;
//    		}
//    		
//    		// 사용자가 입력한 값으로 인덱스 찾기
//    		// 배열에서 값으로 인덱스 찾기 -> 사용자가 입력한 값을 숫자로!
//    		int inputResult = controller.userIndex(input); 
//    				Arrays.asList(rpsModel.getRps()).indexOf(input);
//    		
//    		public void rpsDraw() { // 비겼을 경우
//    			rpsModel.setDraw(rpsModel.getDraw()+1);
//    		} else if(
//    				inputResult == 0 && computer == 2
//    				|| inputResult == 1 && computer == 0
//    				|| inputResult == 2 && computer == 1
//    				) { // 이겼을 경우
//    			System.out.println("이겼습니다!!");
//    			controller.rpsWin();
//    			System.out.println(controller.rpsResult());
//    			break;
//    		} else { // 졌을 경우
//    			System.out.println("졌습니다 ㅠㅠ");
//    			rpsModel.setWin(rpsModel.getLose() + 1);
//    		}
//    	}
//    	
    }
    
}


