package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.ProductVO;

public class ProductDAO {
	
	SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 카테고리별 상품목록
	public List<ProductVO> select( String category ){
		List<ProductVO> list = sqlSession.selectList("p.product_list", category);
		return list;
	}
	
	// 상품등록
	public int insert( ProductVO vo ){
		int res = sqlSession.insert("p.product_insert", vo);
		return res;
	}
	
	// 상세보기를 위한 상품 조회
	public ProductVO selectOne( int idx ){
		ProductVO vo = sqlSession.selectOne("p.product_detail", idx);
		return vo;
	}

}
