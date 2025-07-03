package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.ServerInfo;

public class TransactionTest2 {
	
	/*
	 * 지은 -> 지연 : 3만원 씩 이체
	 * 지은님의 잔액이 마이너스가 될 경우 이체 취소!
	 * UPDATE 2개, SELECT 1개
	 * */


	public static void main(String[] args) {

		try {
			Class.forName(ServerInfo.DRIVER);
			Connection connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);

			connect.setAutoCommit(false);
			int balance = 30000;
			String from = "지은";
			String to = "지연";		
			
			String query1 = "UPDATE bank SET BALANCE = (BALANCE - ?) WHERE NAME = ?";
			PreparedStatement ps1 = connect.prepareStatement(query1);

			ps1.setInt(1, balance);
			ps1.setString(2, from);
			ps1.executeUpdate();
			
			String query2 = "UPDATE bank SET BALANCE = (BALANCE + ?) WHERE NAME = ?";
			PreparedStatement ps2 = connect.prepareStatement(query2);

			ps2.setInt(1, balance);
			ps2.setString(2, to);
			ps2.executeUpdate();

			String query3 = "SELECT * FROM bank WHERE BALANCE < 0";
							// SELECT BALANCE FROM bank WHERE NAME = ?
							// ps3.setString(1, from);
			PreparedStatement ps3 = connect.prepareStatement(query3);
			ResultSet rs = ps3.executeQuery();

			if(rs.next()) {
				connect.rollback();
				// if(rs.getInt("balance") < 0 
				System.out.println("잔액이 마이너스이므로 이체 취소!");
			} else {
				connect.commit();
				System.out.println("3만원 이체가 진행되었습니다!");
			}
			connect.setAutoCommit(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
			// 스프링에서는 @Modifying @Transactional 어노테이션 활용함
	}

}	
