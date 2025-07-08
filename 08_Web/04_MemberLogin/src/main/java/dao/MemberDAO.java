package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import vo.Member;

public class MemberDAO {

	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}

	public MemberDAO() {
		try {
			// 1. 드라이버 로딩
			Class.forName(ServerInfo.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection connect() throws SQLException {
		// 2. DB 연결
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	
	// 회원가입
	public void register(Member member) throws SQLException {
		Connection connect = connect();
		String query = "INSERT INTO member VALUES(?, ?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, member.getId());
		ps.setString(2, member.getName());
		ps.setString(3, member.getPwd());
		ps.setInt(4, member.getAge());
		ps.executeUpdate();
}
	// 멤버 조회
	public ArrayList<Member> showAll() throws SQLException {
		Connection connect = connect();
		ArrayList<Member> list = new ArrayList<>();
		String query = "SELECT * FROM member";
		PreparedStatement ps = connect.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Member member = new Member();
			member.setId(rs.getString("id"));
			member.setName(rs.getString("name"));
			member.setPwd(rs.getString("pwd"));
			member.setAge(rs.getInt("age"));
			list.add(member);
		}
		return list;
	}
	
	public Member showSearch(String id) throws SQLException {
		Connection connect = connect();
		String query = "SELECT * FROM member WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		Member member = null;
		if(rs.next()) {
			member = new Member();
			member.setId(rs.getString("id"));
			member.setName(rs.getString("name"));
			member.setPwd(rs.getString("pwd"));
			member.setAge(rs.getInt("age"));
		}
		return member;
	}
	

}
