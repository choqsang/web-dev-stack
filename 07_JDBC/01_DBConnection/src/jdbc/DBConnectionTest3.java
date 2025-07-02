package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import config.ServerInfo;

public class DBConnectionTest3 {
	
	public static void main(String[] args) {

		try {
			// 1. 드라이버 로딩
			Class.forName(ServerInfo.DRIVER); // 인터페이스에 상수를 담아서 활용
			
			// 2. 데이터베이스 연결
			Connection connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			
			// 3. PreparedStatement 객체 생성 - 쿼리 : UPDATE문 - user_no 선택해서 email 수정
			String query = "UPDATE user_info SET EMAIL = ? WHERE USER_NO = ?";
			PreparedStatement ps = connect.prepareStatement(query);
			
			ps.setString(1, "없음");
			ps.setInt(2, 1);
			
			// 4. 쿼리문 실행 - ps.executeUpdate()
			System.out.println(ps.executeUpdate() + "명 업데이트!");
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	}


