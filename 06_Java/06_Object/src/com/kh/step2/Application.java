package com.kh.step2;

import com.kh.step2.model.Card;

public class Application {

	public static void main(String[] args) {
		
		// 클래스 변수는 객체 생성 없이 호출 가능!
		System.out.println(Card.height);
		System.out.println(Card.width);
		
		Card card1 = new Card();
		card1.kind = "Heart";
		card1.number = 7;
		
		Card card2 = new Card();
		card2.kind = "Spade";
		card2.number = 2;
		
		// 클래스 변수는 모든 객체가 하나의 저장공간을 공유하므로 항상 공통된 값을 갖는다.
		Card.height = 50; // 이게 더 명확하고 클래스명으로 직접 접근하는 게 확실하다! (밑줄 경고 없음)
		card2.width = 30; 
		// 인스턴스 변수 바꾸는 것처럼 보이지만, 실제는 클래스 변수 값을 바꿈
		// 카드2에만 값을 담아도 1에도 동일한 값이 부여되어 있는 것을 확인
		
		System.out.println("첫 번째 카드는 " + card1.kind + " " + card1.number + "이며, "
							+ "크기는 " + card1.width + " X " + card1.height + "입니다.");
		System.out.println("두 번째 카드는 " + card2.kind + " " + card2.number + "이며, "
							+ "크기는 " + card2.width + " X " + card2.height + "입니다.");
	}

}
