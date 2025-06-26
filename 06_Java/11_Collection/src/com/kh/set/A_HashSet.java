package com.kh.set;

import java.util.HashSet;
import java.util.Iterator;

import com.kh.list.model.Person;

/*
 * Set 특징 (리스트와 거의 반대 개념)
 * - 중복 제거 
 * - 순서 없음
 * */

public class A_HashSet {
	
	public void method1 () {
		HashSet<String> set = new HashSet<>();
		set.add("전현무");
		set.add("박나래");
		set.add("기안84");
		set.add("키");
		set.add("박나래"); // 여러 번 추가하더라도 중복값 제거됨!
		
		System.out.println(set);
		System.out.println("몇 명이 들어있나요? " + set.size() + "명");
		System.out.println("기안84가 포함되어있나요? " + set.contains("기안84"));
		
		set.remove("박나래"); // 삭제
		System.out.println(set);
		
		set.clear(); // 전체 삭제
		System.out.println("비어있는가? " + set.isEmpty());
	}
	
	public void method2() {
		HashSet<Person> set = new HashSet<>();
		set.add(new Person("전현무", "삼성동", 47));
		set.add(new Person("박나래", "이태원동", 39));
		set.add(new Person("기안84", "과천시", 40));
		set.add(new Person("키", "한남동", 33));
		set.add(new Person("키", "한남동", 33));
		
		for(Person p : set) {
			System.out.println(p);
		}
		/*
		 * Iterator
		 * - 컬렉션에 저장된 요소를 접근하는데 사용하는 인터페이스
		 * - iterator()를 호출해서 Iterator를 구현한 객체를 얻어서 사용
		 * */
		System.out.println("---");
		Iterator<Person> it = set.iterator();
		while(it.hasNext()) { // 읽어올 요소가 있는 지 확인
			System.out.println(it.next()); // 다음 요소를 읽어옴
		}
		
		System.out.println(it.hasNext()); // 첫 번째 값이 있니?
		System.out.println(it.next()); // 첫 번째 값 출력
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext()); // false : 값이 없음
		System.out.println(it.next()); // 범위 내 모든 데이터 출력되었을 경우, 오류가 뜨며 출력불가! 	
	}

	public static void main(String[] args) {
		A_HashSet a = new A_HashSet();
//		a.method1();
		a.method2();
	}

}
