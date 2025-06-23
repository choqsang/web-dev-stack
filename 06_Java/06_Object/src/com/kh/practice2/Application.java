package com.kh.practice2;

import java.util.Scanner;

import com.kh.practice2.controller.SnackController;
import com.kh.practice2.model.Snack;
import com.kh.practice2.view.SnackView;

// POJO(Plain Old Java Object) : 예전 (순수)자바방식으로 구현하는 경우, 테스트 용도 등으로 활용됨
// Application 파일의 경우 JDBC 이후 DB와 화면단이 구현되면 사용하지 않게 된다.

public class Application {

	public static void main(String[] args) {
		// 아래 실행 결과에 따른 코드 작성

		SnackView view =  new SnackView();
		view.input();
		view.result();				
	}	
}
