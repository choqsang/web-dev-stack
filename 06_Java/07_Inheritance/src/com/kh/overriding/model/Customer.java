package com.kh.overriding.model;

import java.util.Objects;

import com.kh.inheritance.model.parent.Product;

/*
 * 클래스 간의 관계 : 상속 vs 포함 (기존 만들어진 코드 extends 이외 일반적으로 포함을 많이 쓰게 된다)
 * - 상속 관계 : ~은 ~이다 (is - a)
 * - 포함 관계 : ~은 ~을 가지고 있다 (has - a)
 * */

public class Customer {
	
	protected String name; // 고객 이름
	protected String grade; // 고객 등급
	protected int bonusPoint; // 보너스 포인트
	protected double bonusRatio; // 보너스 적립 비율
	protected int price; // 상품 가격
		
	// ↓ 포함관계 : 고객은 상품을 가지고 있다
	// 	→ MODEL(DB와 1:1), JOIN(1:M)
	protected Product product;
	
	public Customer() {
//		System.out.println("부모 생성자!");
	}
	
	public Customer(String name) {
		this.name = name;
		this.grade = "SILVER";
		this.bonusRatio = 0.01;
		this.price = 100000;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public double getBonusRatio() {
		return bonusRatio;
	}

	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override // generate에서도 가능
	public boolean equals(Object obj) {
		Customer c = (Customer) obj;
		return c.name == this.name;	
	}

	@Override
	public String toString() {
//		return "Customer [name=" + name + ", grade=" + grade + ", bonusPoint=" + bonusPoint + ", bonusRatio="
//				+ bonusRatio + "]";
		return name + "님의 등급은 " + grade + "이며, 지불해야 하는 금액은 " + price + "원이며, 적립된 포인트는 " + bonusPoint + "점입니다.";
	}
	
	public void calc(int price) {
		this.bonusPoint = (int)(price * bonusRatio);
		this.price = price;
	}
}
