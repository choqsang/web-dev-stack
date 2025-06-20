package com.kh.practice2.model;
public class Snack {
	
	private String kind; // 종류
	private String name; // 이름
	private String flavor; // 맛
	private int numOf; // 개수
	private int price; // 가격
	public Snack() {}


	public Snack (String kind, String name, String flavor, 
			int numOf, int price) {
	this.kind = kind;
	this.name = name;
	this.flavor = flavor;
	this.numOf = numOf;
	this.price = price;
}

	public String toString() {
		return "종류 : " + kind + "\n이름 : " + name + "\n맛 : " + flavor + "\n개수 : "
				+ numOf + "\n가격 : " + price;
}
	public String getkind() {
		return kind; 	}
	public void setkind(String kind) {
		this.kind = kind; }
	
	public String getname() {
		return name; 	}
	public void setname(String name) {
		this.name = name; }
	
	public String getflavor() {
		return flavor; 	}
	public void setflavor(String flavor) {
		this.flavor = flavor; }
	
	public int getnumOf() {
		return numOf; 	}
	public void setnumOf(int numOf) {
		this.numOf = numOf; }
	
	public int getprice() {
		return price; 	}
	public void setprice(int price) {
		this.price = price; }
	
}
