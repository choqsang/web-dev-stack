package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.ProductVO;

public class ProductDAO {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<ProductVO> selectList(){
		List<ProductVO> list = sqlSession.selectList("p.product_list");
		return list;
	}
	
	
	/*
	 * // 카테고리별 상품목록 public List<ProductVO> select( String category ){
	 * 
	 * SqlSession sqlSession = factory.openSession(); List<ProductVO> list =
	 * sqlSession.selectList("p.product_list", category); sqlSession.close();
	 * 
	 * return list; }
	 * 
	 * // 상품등록 public int insert( ProductVO vo ){
	 * 
	 * SqlSession sqlSession = factory.openSession(true); int res =
	 * sqlSession.insert("p.product_insert", vo); sqlSession.close();
	 * 
	 * return res; }
	 * 
	 * // 상세보기를 위한 상품 조회 public ProductVO selectOne( int idx ){
	 * 
	 * SqlSession sqlSession = factory.openSession(true); ProductVO vo =
	 * sqlSession.selectOne("p.product_detail", idx); sqlSession.close();
	 * 
	 * return vo; }
	 */
}
