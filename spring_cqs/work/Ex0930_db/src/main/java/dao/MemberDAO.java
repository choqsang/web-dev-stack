package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVO;

public class MemberDAO {
	
	SqlSession sqlSession;

	// 기본 생성자가 없기 때문에 반드시 세션을 파라미터로 받아서 수행하게끔
	public MemberDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<MemberVO> selectList(){
		List<MemberVO> list = sqlSession.selectList("m.member_list");
		return list;
	}
	
	public MemberVO selectOne(int idx){
		MemberVO vo = sqlSession.selectOne("m.member_select", idx);
		return vo;
	}
	
	// 회원 등록
	public int register(MemberVO vo){
		int res = sqlSession.insert("m.member_insert", vo);
		return res;
	}
	
	// 회원 수정
	public int modify(MemberVO vo){
		int res = sqlSession.update("m.member_update", vo);
		return res;
	}
	
//	// 회원 삭제
//	public int del(int idx) {
//		int res = sqlSession.delete("m.member_delete", idx);
//		return res;
//	}

	// 회원 삭제
	public int memberDel(int idx) {
		int res = sqlSession.delete("m.member_delete", idx);
		return res; // (삭제 성공: 1, 실패: 0)
	}	

	// 로그인 : 입력받은 아이디에 해당하는 유저가 있는 지 조회
	public MemberVO selectIdCheck(String id) {
		MemberVO vo = sqlSession.selectOne("m.id_check", id);
		return vo;
	}
}
