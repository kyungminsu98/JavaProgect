package co.yedam.service;

import java.util.List;

import co.yedam.vo.MemberVO;
import co.yedam.vo.ProductVO;

public interface MemberService {
	public MemberVO loginCheck(MemberVO mvo);
	public List<MemberVO> memberList();
	public boolean signUp(MemberVO mvo);
	public boolean removeMember(String mid);
	public boolean addMember(MemberVO mvo);
	// 상품목록
	public List<ProductVO> prodList();
}
