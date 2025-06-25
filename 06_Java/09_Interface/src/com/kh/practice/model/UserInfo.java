package com.kh.practice.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * https://projectlombok.org/download (롬복) : 자바의 장황한 코드를 줄이고 생산성을 높이기 위해 컴파일 타임에 코드를 자동 생성
 * generate (Shift+Alt+S)없이 어노테이션만으로 모델 관리 가능
 * @NoArgsConstructor : 기본 생성자
 * @AllArgsConstructor : 모든 필드를 매개변수로 받는 생성자
 * @Getter	@Setter : 모든 필드의 Getter / Setter 메서드 
 * @ToString : toString 메서드
 * @Data : Getter, Setter, ToString, EqualsAndHashCode, RequiredArgsConstructor 포함
 * */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class UserInfo {
	private int userNo;
	private String id;
	private String password;
	private String email;
	private String name;
	private String phone;
	private String addr;
	private String gender;
	private LocalDate birthDate;
	// 임시적으로 넣어놓을게요!
	private int deptNo;
	private Department department;
}
