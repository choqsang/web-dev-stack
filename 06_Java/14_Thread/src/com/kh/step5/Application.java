package com.kh.step5;

public class Application {

	public static void main(String[] args) {

		// 스레드들은 공유자원을 서로 공유한다
		Calculator cal = new Calculator();
		
		User1 user1 = new User1();
		User2 user2 = new User2();
		
		user1.setCalculator(cal);
		user2.setCalculator(cal);
		
		// run()으로 부를 때, start()로 부를 때 차이
		// : start()로 부르면 스레드 호출로 동시다발적으로 실행 되지만 run()은 각각 실행됨
		user1.run();
		user2.run();
		
		user1.start();
		user2.start();
	}

}
