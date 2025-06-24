package com.kh.polymorphism;

import java.util.Scanner;

import com.kh.polymorphism.controller.EmployeeController;
// ↓ FQCN(Full Qualified Class Name) : 패키지명까지 포함되어 있는 클래스명
import com.kh.polymorphism.model.*; // model 모두 import

/*
	 * 다형성(Polymorphism)
	 * - 하나의 객체변수가 여러가지 모양과 모습을 가지는 능력
	 * - 부모 타입으로 자식 객체를 생성하는 것
	 * 
	 * Liskov Substitution Principle, LSP
	 * - 부모 객체는 자식 객체로 교체해도 문제 없다
	 * - 다형성이 제대로 설계되었는 지 판단하는 기준 중 하나
	 * */

public class Appliaction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeController ec = new EmployeeController();

		Employee em = new Employee("문채은", 3000000);
		Engineer en = new Engineer("최다인", 3500000, "자바", 300000);
		Manager ma = new Manager("김은진", 4000000, "개발팀");
		Secretary se = new Secretary("전영현", 4500000, "문채은");

//		System.out.println(em);
//		System.out.println(en);
//		System.out.println(ma);
//		System.out.println(se);

		// 다형성 + 객체 배열
		Employee[] emp = { em, en, ma, se };

		for(Employee employee : emp) {
			System.out.println(employee);
		}
		System.out.println("--------------------------------");
			// 이름으로 사람 찾기
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();
//		int sum = 0;
//
//		for (int i = 0; i < emp.length; i++) {
//			if (name.equals(emp[i].getName())) {
//				System.out.println(emp[i]);
//			// 찾은 사람의 연봉은?
//				System.out.println("연봉은 " + emp[i].getSalary() * 12 + "원 입니다.");
//			}
//			// 전체 총 월급은?
//			sum += emp[i].getSalary();
//		}
//		System.out.println("전체 총 월급은 " + sum + "원 입니다.");

		// 일단 반복문!
		// 이름으로 사람(Employee) 찾기 -> 이름은 문자열(equals), getName
	
		Employee findEmployee = ec.findEmployee(emp, name);
		System.out.println(ec.findEmployee(emp, name));
		
		// 찾은 사람의 연봉(getSalary)은?
		// 특정 자식 객체 찾는 방법!
		int annual = ec.getAnnualSalary(findEmployee);
		if(annual != -1) {
			System.out.println(annual);
		} 
		
		// 전체 총 월급 (for문 필요! 각 getSalary 더해나가기)
		System.out.println(ec.totalSalary(emp));
	}

}
