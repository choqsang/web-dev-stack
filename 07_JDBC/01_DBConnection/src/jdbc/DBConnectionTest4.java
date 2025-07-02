package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import config.ServerInfo;

public class DBConnectionTest4 {

	public static void main(String[] args) {

		try {
			Properties p = new Properties();
			p.load(new FileInputStream("src/config/db.properties"));
			
			// 1. 드라이버 로딩
			Class.forName(p.getProperty("driver"));
			
			// 2. 데이터베이스 연결
			Connection connect = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("password"));
			
			// 3. PreparedStatement 객체 생성 - 쿼리 : DELETE문 - user_no 선택하여 삭제
			String query = "DELETE FROM user_info WHERE USER_NO = 1";
			PreparedStatement ps = connect.prepareStatement(query);
			
			// 4. 쿼리문 실행 - ps.executeUpdate()
			System.out.println(ps.executeUpdate() + "명 삭제!");
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
