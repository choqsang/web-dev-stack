package com.kh.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class Member {

	private String id;
	private String name;
	private String pwd;
	private int age;
	
}
