package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.ServerInfo;

public class TransactionTest1 {

	public static void main(String[] args) {
		try {
			Class.forName(ServerInfo.DRIVER);
			Connection connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			
			// 트랜잭션 시작!
			connect.setAutoCommit(false); // commit 없이 자동 저장되지 않음! 
			
			String query1 = "INSERT INTO member VALUES(?, ?, ?)";
			PreparedStatement ps1 = connect.prepareStatement(query1);
			ps1.setString(1, "user06");
			ps1.setString(2, "유저");
			ps1.setString(3, "pass01");
			
			ps1.executeUpdate(); // 추가가 되는 시점!
			
			String query2 = "SELECT * FROM member WHERE id = ?";
			PreparedStatement ps2 = connect.prepareStatement(query2);
			ps2.setString(1, "user07");
			
			ResultSet rs = ps2.executeQuery(); // 조회가 이루어지는 시점!
			
			if(rs.next()) { // 사람이 존재하는 경우 true
				connect.rollback();
				System.out.println("회원이 존재하여 회원 추가 취소!");
			} else {
				connect.commit();
				System.out.println("회원이 존재하지 않으므로 추가!");
			}
			
			// 트랜잭션 끝! 다시 원래 설정대로
			connect.setAutoCommit(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
