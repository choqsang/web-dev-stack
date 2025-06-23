package com.kh.inheritance;

import com.kh.inheritance.model.Notebook;
import com.kh.inheritance.model.Smartphone;

public class Application {

	public static void main(String[] args) {
		Notebook notebook = new Notebook("애플", "app-01", "맥북 프로", 2390000, "M4");
		System.out.println(notebook);
//		Smartphone phone = new Smartphone("삼성", "sma-01", "갤럭시 S25 울트라", 1841400, "KT");
		Smartphone phone = new Smartphone();
		phone.setBrand("삼성");
		phone.setpCode("sam-01");
		phone.setName("갤럭시 S25 울트라");
		phone.setPrice(1841400);
		phone.setAgency("KT");
		System.out.println(phone);
	}

}
