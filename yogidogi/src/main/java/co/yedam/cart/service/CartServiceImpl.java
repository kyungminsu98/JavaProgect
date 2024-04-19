package co.yedam.cart.service;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;

import co.yedam.cart.mapper.CartMapper;
import co.yedam.cart.vo.CartVO;

public class CartServiceImpl implements CartService {

	SqlSession session = DataSource.getInstance().openSession(true);
	CartMapper mapper = session.getMapper(CartMapper.class);

	@Override
	public List<CartVO> cartList(int memberNo) {
		return mapper.selectList(memberNo);
	}

	@Override
	public int addCart(CartVO vo) {
		// 장바구니 데이터 체크
		CartVO checkCart = mapper.checkCart(vo);
		if(checkCart != null) {
			return 2;
		}
		return mapper.insertCart(vo);
	}

	@Override
	public boolean remCart(int cartNo) {
		return mapper.deleteCart(cartNo) == 1;
	}

	@Override
	public boolean modCart(CartVO vo) {
		return mapper.updateCart(vo) == 1;
	}

}
