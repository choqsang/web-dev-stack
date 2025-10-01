package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVO;

public class VisitDAO {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<VisitVO> selectList(){
		List<VisitVO> list = sqlSession.selectList("v.visit_list");
		return list;
	}
	
	public int register(VisitVO vo){
		int res = sqlSession.insert("v.visit_insert", vo);
		return res;
	}
	
	public int del(int idx){
		int res = sqlSession.delete("v.visit_delete", idx);
		return res;
	}
	
	public VisitVO modify(int idx){
		VisitVO vo = sqlSession.selectOne("v.visit_select", idx);
		return vo;
	}
	
	public int modifyFin(VisitVO vo){
		int res = sqlSession.update("v.visit_update", vo);
		return res;
	}
	
	public VisitVO checkPwd(String pwd) {
		VisitVO vo = sqlSession.selectOne("v.pwd_check", pwd);
		return vo;
	}
}
