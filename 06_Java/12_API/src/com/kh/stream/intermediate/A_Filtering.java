package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.kh.stream.model.Student;

/*
 * 필터링
 * - 중간 처리 기능으로 요소를 걸러내는 역할
 * */

public class A_Filtering {

	List<String> names = Arrays.asList("오재덕", "이승민", "이환희", "오재덕", "이승민", "이환희", "박기민", "조규상", "이상엽", "성예찬");
	List<Student> students = Arrays.asList(
				new Student("오재덕", 20, "남자", 80, 90),
				new Student("이승민", 19, "남자", 75, 80),
				new Student("이환희", 18, "여자", 50, 100),
				new Student("박기민", 17, "남자", 70, 90),
				new Student("조규상", 18, "남자", 75, 85),
				new Student("이상엽", 20, "남자", 100, 60),
				new Student("성예찬", 19, "남자", 70, 95),
				new Student("박기민", 17, "남자", 70, 90),
				new Student("조규상", 18, "남자", 75, 85),
				new Student("이상엽", 20, "남자", 100, 60),
				new Student("성예찬", 19, "남자", 70, 95)
			);
	
	
	// distinct : 중복 제거
	public void method1() {
		Stream<String> stream = names.stream();
		stream
			.distinct()
			.forEach(name -> System.out.print(name+ " "));
		
		students.stream()
				.distinct()
				.forEach(student -> System.out.println(student));
	}
	// filter : 조건문 사용한다라고 보시면 됩니다!
	public void method2() {
		names.stream()
			 .distinct() // 중간 처리 한 번에 여러 개 적용 가능
			 .filter(name -> name.startsWith("이")) // '이'로 시작하는 (성씨가 이 씨인) 사람
			 .forEach(name -> System.out.print(name + " "));
		
		// students
		// 나이가 19살 이상인 사람만 출력
		students.stream()
				.distinct()
				.filter(students -> students.getAge()>=19)
				.forEach(students -> System.out.println(students));
				
		System.out.println("================================");
		// 수학 점수, 영어 점수 둘 다 70점 이상인 사람만 출력
		students.stream()
				.distinct()
				.filter(students -> students.getMath()>=70 && students.getEnglish()>=70)
				.forEach(students -> System.out.println(students));

		
	}
	
	public static void main(String[] args) {
		A_Filtering a = new A_Filtering();
//		a.method1();
		a.method2();
	}

}
