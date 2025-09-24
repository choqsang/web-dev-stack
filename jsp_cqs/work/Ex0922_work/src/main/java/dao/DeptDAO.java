package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DeptVO;

public class DeptDAO {
	
	SqlSessionFactory factory;
	
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static DeptDAO single = null;

	public static DeptDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new DeptDAO();
		//생성된 객체정보를 반환
		return single;
	}

	public DeptDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}

	// 사원 목록 조회
	public List<DeptVO> select() {
		
		SqlSession sqlSession = factory.openSession();
		List<DeptVO> list = sqlSession.selectList("d.dept_select");
		sqlSession.close();
		
		return list;
	}
	
	// 사원 등록
	public int insert(DeptVO vo) {
		
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.insert("d.insert_dept", vo);
		sqlSession.close();
		
		return res;
		
	}
	
	// 사원 삭제
	public int delete(int no) {
		
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.insert("d.delete_dept", no);
		sqlSession.close();
		
		return res;
		
	}
	
	// 사원 수정
	public DeptVO updateDept(int deptno) {
		
		SqlSession sqlSession = factory.openSession();
		
		DeptVO vo = sqlSession.selectOne("d.update_one", deptno);
		
		sqlSession.close();
		
		return vo;
		
	}
	
	// 부서 정보 수정2
	public int updateFin(Map<String, Object> map) {

		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.update("d.update_dept_fin", map);
		sqlSession.close();
		
		return res;
	}

}
