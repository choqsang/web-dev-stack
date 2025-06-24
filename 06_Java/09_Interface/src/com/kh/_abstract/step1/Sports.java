package com.kh._abstract.step1;

public abstract class Sports { // keyword:'abstract'를 통해 추상클래스화!

	protected int numOfPlayers; // 참여 인원 수

	public Sports(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}
	
	// 추상메서드! 즉, 미완성된 메서드! 구현부가 X -> 자식 클래스에서 강제 구현!
	public abstract void rule(); 
//	{
//		System.out.println("해당 운동마다 규칙이 존재한다");
//	}
}
