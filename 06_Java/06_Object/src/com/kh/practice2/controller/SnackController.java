package com.kh.practice2.controller;

import java.util.Scanner;

import com.kh.practice2.model.Snack;


public class SnackController {
	
	private Snack snack = new Snack();
	
	public String saveData(Snack snackData)
	{
		snack.setkind(snackData.getkind());
		snack.setname(snackData.getname());
		snack.setflavor(snackData.getflavor());
		snack.setnumOf(snackData.getnumOf());
		snack.setprice(snackData.getprice());
		return "저장 완료되었습니다.";
}
	
	
	public Snack confirmData() {
		
//		return snack.getkind()+ "("+snack.getname()+" - "
//				+snack.getflavor()+") "+snack.getnumOf()+"개 " 
//				+snack.getprice()+"원";
		
		return snack;
	}
		
}
