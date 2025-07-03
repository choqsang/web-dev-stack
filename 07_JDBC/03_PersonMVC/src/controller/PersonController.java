package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import config.ServerInfo;
import view.PersonView;

public class PersonController {

	// 리턴 타입이나 파라미터 자유롭게 변경 가능!
	// 메서드 추가 가능!
	
	 public PersonController() throws Exception {
		 Class.forName(ServerInfo.DRIVER);
	 };
	 
	// 컨트롤러 내 모든 메서드에 try-catch가 있을 경우,
	// 가독성이 너무 떨어지기 때문에 throws로 던져두고 view단에서 try-catch를 잡아도 좋다!
	
	// 고정적으로 반복되는 코드 (DB 연동) 
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}

	// 자원 반납 코드
	public void close(PreparedStatement ps, Connection connect) throws SQLException {
		ps.close();
		connect.close();
	}
	// 오버로딩!
	public void close(ResultSet rs, PreparedStatement ps, Connection connect) throws SQLException {
		rs.close();
		ps.close();
		connect.close();
		// close(ps, connect); 로 한 번 더 줄일 수 있음
	}
	
	// ------- 변동적인 반복 : DAO(Database Access Object)
	
	// person 테이블에 데이터 추가 - INSERT
	public void addPerson(String name, int age, String addr) throws Exception {
		Connection connect = getConnect();
		// PreparedStatement ps = connect.prepareStatement(null);
		PersonView pv = new PersonView();
			
			String query = "INSERT INTO person(name, age, addr) VALUES(?, ?, ?)"; // 이름, 나이, 주소  
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, addr);
			
		System.out.println(ps.executeUpdate() + "명 추가되었습니다!");
		close(ps, connect);
	}
	
	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public void searchAllPerson() throws SQLException {
		Connection connect = getConnect();
		
			String query = "SELECT * FROM person";  
			PreparedStatement ps = connect.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				
				System.out.println(id + "번 - 이름 : " + name + " / 나이 : " + age + " / 주소 : " + addr);
			}
			
		close(rs, ps, connect);	
	}
	
	// person 테이블에서 데이터 한 개만 가져오기 - SELECT + id로 조회
	public void searchPerson(int id) throws SQLException {
		Connection connect = getConnect();
		PersonView pv = new PersonView();
		
			String query = "SELECT * FROM person WHERE id = ?";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeQuery();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				
				System.out.println("이름 : " + name + " / 나이 : " + age + " / 주소 : " + addr);
			}
		
		close(rs, ps, connect);
	}
	
	// person 테이블에 데이터 수정 - UPDATE (이름을 입력 받아 주소를 수정)
	public void updatePerson(String mAddr, String mName) throws SQLException {
		Connection connect = getConnect();
		
			String query = "UPDATE person SET addr = ? WHERE name = ?"; 
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, mAddr);
			ps.setString(2, mName);
			
		System.out.println(ps.executeUpdate() + "명 수정되었습니다!");
		close(ps, connect);
	}
	
	// person 테이블에 데이터 삭제 - DELETE (성인이 아닐 경우 삭제)
	public void removePerson() throws SQLException {
		Connection connect = getConnect();
			
			String query = "DELETE FROM person WHERE age < ?"; // 성인이 아닐 경우 삭제한다 
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setInt(1, 20);
			
		System.out.println(ps.executeUpdate() + "명 삭제되었습니다!");
		close(ps, connect);
	}
	
	
}
