package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ProductVO;

public class ProductDAO {
	
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static ProductDAO single = null;

	public static ProductDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new ProductDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	SqlSessionFactory factory;

	public ProductDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}
	
	// 카테고리별 상품목록
	public List<ProductVO> select( String category ){
		
		SqlSession sqlSession = factory.openSession();
		List<ProductVO> list = sqlSession.selectList("p.product_list", category);
		sqlSession.close();
		
		return list;
	}
	
	// 상품등록
	public int insert( ProductVO vo ){
		
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.insert("p.product_insert", vo);
		sqlSession.close();
		
		return res;
	}
	
	// 상세보기를 위한 상품 조회
	public ProductVO selectOne( int idx ){
		
		SqlSession sqlSession = factory.openSession(true);
		ProductVO vo = sqlSession.selectOne("p.product_detail", idx);
		sqlSession.close();
		
		return vo;
	}

}
