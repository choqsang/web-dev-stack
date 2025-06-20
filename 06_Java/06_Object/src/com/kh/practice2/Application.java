package com.kh.practice2;

import com.kh.practice2.controller.SnackController;
import com.kh.practice2.model.Snack;

public class Application {

	public static void main(String[] args) {
		// 아래 실행 결과에 따른 코드 작성
		
		SnackController ctrl = new SnackController();
//		Snack snack = new Snack("빵", "케이크", "블루베리", 1, 15000);
		ctrl.saveData();
		ctrl.confirmData();
				
	}	
}
