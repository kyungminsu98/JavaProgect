package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.MemberVO;
import co.yedam.vo.ProductVO;

public interface MemberMapper {
	public MemberVO selectMember(MemberVO mvo);
	public List<MemberVO> selectList();
	public int addMember(MemberVO mvo);
	public int deleteMember(String mid);
	// 제품 관련
	public List<ProductVO> selectProdList();
}
