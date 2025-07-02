package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnectionTest2 {
	
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/erp";
	public static final String USER = "root";
	public static final String PASSWORD = "qwer1234";

	public static void main(String[] args) {

		try {
		// 1. 드라이버 로딩
		Class.forName(DRIVER);
		
		// 2. 데이터베이스 연결 : 스키마 - erp
		Connection connect = DriverManager.getConnection(URL, USER, PASSWORD); // 경로, 계정, 패스워드
		
		// 3. PreparedStatement 객체 생성 - INSERT문 - user_info 테이블 사람 한 명 추가 쿼리문 작성
		String query = "INSERT INTO user_info(id, password, name) VALUES(?, ?, ?)"; // 바뀌는 부분을 물음표(?)로 치환
		PreparedStatement ps = connect.prepareStatement(query);
		
		ps.setString(1, "user03"); // 물음표 갯수만큼 set추가 (자리, 값) 입력 
		ps.setString(2, "2222");
		ps.setString(3, "이상엽");
		
		// 4. 쿼리문 실행 - ps.executeUpdate() : SELECT문을 제외하고는 데이터 수정이 이루어지기 때문에 executeUpdate()를 사용함.
			System.out.println(ps.executeUpdate() + "명 추가!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
