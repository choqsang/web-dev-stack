package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CartVO;

public class CartDAO {
	
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static CartDAO single = null;

	public static CartDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new CartDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	SqlSessionFactory factory;
	public CartDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
		
	}
	
	// 회원별 장바구니 목록
	public List<CartVO> select(int m_idx){
		
		SqlSession sqlSession = factory.openSession();
		List<CartVO> list = sqlSession.selectList("c.cart_list", m_idx);
		sqlSession.close();
		
		return list;
	}
	
	// 장바구니에 담긴 상품들의 총 합계
	public int selectTotalAmount(int m_idx) {
		SqlSession sqlSession = factory.openSession();
		int total = sqlSession.selectOne("c.cart_total_amount", m_idx);
		sqlSession.close();
		
		return total;
	}
	
	// 이미 장바구니에 등록된 상품인지 조회
	public CartVO selectOne(CartVO vo) {
		SqlSession sqlSession = factory.openSession();
		CartVO res = sqlSession.selectOne("c.cart_one", vo);
		sqlSession.close();
		
		return res;
		// null일 경우, 장바구니에 담을 수 있음
	}
	
	// 장바구니 항목 추가
	public int insert(CartVO vo) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.selectOne("c.cart_insert", vo);
		sqlSession.close();
		
		return res;
	}
}
