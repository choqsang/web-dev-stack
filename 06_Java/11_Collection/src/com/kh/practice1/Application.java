package com.kh.practice1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
	
	public static void main(String[] args) {
		// 1등 당첨 기준이 로또 번호 6개
		// 둘 다 랜덤! 로또 번호는 1번!
		// 내 번호는 맞출 때까지 반복! (1~45)
		// 당첨까지 횟수 체크, 정렬이 딱 맞으면 equals로 비교 가능
		// 반복문이 로또번호가 6개 될 때까지!
		
		// 만약, 2등 당첨! 보너스 번호 일치 + 5개 일치
		// 3등 당첨 - 5개만 같은 경우
		// 4등 당첨 - 4개만 같은 경우
		// 5등 당첨 - 3개만 같은 경우
		
		Application a = new Application();
		a.randomBall();
	}

	boolean check = true;
	int count = 0;
	int[] result = new int[4];
	// index) 0: 2등, 1: 3등, 2: 4등, 3: 5등
	public void randomBall() {

		Set<Integer> lotto = new HashSet<>();
		
		while (lotto.size() < 7) {
			int ball = (int)(Math.random()*45 +1);
			if(!lotto.contains(ball)) {
				lotto.add(ball);
			}
		}
		
		List<Integer> lottolist = new ArrayList<>(lotto);
		List<Integer> realLottolist = lottolist.subList(0, 6);
		int bonus = lottolist.get(6);
		Collections.sort(realLottolist); 
		
		while(check) {
			Set<Integer> myLotto = new HashSet<>();
			while (myLotto.size() < 6) {
				int ball2 = (int)(Math.random()*45 +1);
				if(!myLotto.contains(ball2)) {
					myLotto.add(ball2);
				}
			} 
			List<Integer> myLottolist = new ArrayList<>(myLotto);
			Collections.sort(myLottolist);
			count++;
			System.out.println("");
			System.out.println("로또 번호 : " + realLottolist + "\n보너스 번호 : [" + bonus + "]");
			System.out.println("내 로또 번호 : " + myLotto); 
			
			int match = 0;
			for(int ball : realLottolist) {
				if(myLotto.contains(ball)) {
					match++;
				}
			}
			
			if(realLottolist.equals(myLottolist)) {
				check = false;
				System.out.println("==========");
				System.out.println("★★★ 1등 당첨 ★★★ (" + count + "회 반복)");
				System.out.println("총 구매금액 : " + String.format("%,d원",(count*1000)) + "입니다.");
				
			} else if (match == 5 && myLotto.contains(bonus)) {
				System.out.println("2등 당첨! (" + count + "회 반복)"); result[0]++;
			} else if (match == 5) {
				System.out.println("3등 당첨! (" + count + "회 반복)"); result[1]++;
			} else if (match == 4) {
				System.out.println("4등 당첨! (" + count + "회 반복)"); result[2]++;
			} else if (match == 3) {
				System.out.println("5등 당첨! (" + count + "회 반복)"); result[3]++;
			}
			for (int i=0; i>0; i++) {
				System.out.println((i+2) + "등 횟수 : " + result[i] + "회");
			}
		}
	}

	// List<Integer> 리스트명 = new ArrayList<>(set명); => 세트에서 리스트로 바꾸는 명령어
	
	
}