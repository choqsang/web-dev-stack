package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication { // Application 실행 시, 해당 페이지로부터 시작된다

	public static void main(String[] args) {
		// JPA (Java Persistance API)
        // 객체와 데이터베이스를 쉽게 연결하기 위한 표준 인터페이스
        // 객체를 DB 테이블과 자동으로 매핑
        // 자동화, 생산성 UP
        // DB가 많아지면 복잡도가 높아진다 (관리가 어려울 수 있음)

        SpringApplication.run(DemoApplication.class, args);
	}

}
