package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.MemberDAO;
import vo.Member;

class MemberDAOTest {
	
	private MemberDAO dao;
	
	// @BeforeEach : 각 테스트 메서드가 실행되기 전에 무조건 실행
	// 보통 DAO나 Service 객체 초기화
	@BeforeEach
	void setUp() {
		dao = MemberDAO.getInstance();
	}
	
	// @AfterEach : 각 테스트 메서드가 실행된 후에 무조건 실행
	@AfterEach
	void setDown() throws SQLException {
		dao.connect().prepareStatement("DELETE FROM member").executeUpdate();
	}
	
	@Test
	void testRegister() throws SQLException {
		Member m = new Member("test01","테스트01","pass01",1);
		dao.register(m);
	}
	
	@Test
	void testLogin() throws SQLException {
		Member m = new Member("test01","테스트01","pass01",1);
		dao.register(m);
		
		m = dao.login("test01", "pass01"); // null인지 아닌지
		assertNotNull(m); // 해당 값이 null이 아니라면 테스트 통과!
	}
	

}
