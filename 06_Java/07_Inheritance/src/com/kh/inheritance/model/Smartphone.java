package com.kh.inheritance.model;

import com.kh.inheritance.model.parent.Product;

public class Smartphone extends Product {
	
	private String agency;

	public Smartphone() {
	}
	
	public Smartphone(String brand, String pCode, String name, int price, String agency) {
		super(brand, pCode, name, price);
		this.agency = agency;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	@Override
	public String toString() {
		return super.getBrand() + ", " + super.getpCode() + ", " + 
			   this.getName() + ", " + getPrice() + ", " + this.getAgency();
	}
}