package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DBConnectionTest1 {

	public static void main(String[] args) {

		// JDBC (Java DataBase Connectivity)
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이버 로딩...!");
			
			// 2. 데이터베이스 연결
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "qwer1234"); // 경로, 계정, 패스워드
			System.out.println("2. 데이터베이스 연결...!");
			
			// 3. PreparedStatement 객체 생성 -> 쿼리 : SELECT문 사용해서 film
			ps = connect.prepareStatement("SELECT * FROM film");
			
			// 4. 쿼리 실행
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int filmId = rs.getInt("film_id"); // .get데이터타입("컬럼명") 일치하는 지 확인 후 입력하여 가져오기
				String title = rs.getString("title");
				String desc = rs.getString("description");
				LocalDate update = rs.getDate("last_update").toLocalDate();
				double cost = rs.getDouble("replacement_cost");
				
				System.out.println(filmId + " / " + title + " / " + desc + " / " + update + " / " + cost);
			}
			// System.out.println(rs.next()); // 데이터가 존재할 경우 true값 출력! 없으면 false!
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally { // 자원반납을 위한 개별 변수 선언
			try {
				// 5. 자원반납 (실행 역순으로 하는 게 좋다 : 필수 아님)
				rs.close();
				ps.close();
				connect.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
