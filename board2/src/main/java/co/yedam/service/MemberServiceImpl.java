package co.yedam.service;

import java.util.List;

import co.yedam.common.DataSource;
import co.yedam.mapper.MemberMapper;
import co.yedam.vo.MemberVO;
import co.yedam.vo.ProductVO;

public class MemberServiceImpl implements MemberService{
	MemberMapper mapper = DataSource.getInstance().//
			openSession(true).getMapper(MemberMapper.class);
	
	@Override
	public MemberVO loginCheck(MemberVO mvo) {
		return mapper.selectMember(mvo);
	}

	@Override
	public boolean signUp(MemberVO mvo) {
		// TODO Auto-generated method stub
		return mapper.addMember(mvo) == 1;
	}

	@Override
	public List<MemberVO> memberList() {
		return mapper.selectList();
	}
	
	// 제품 관련
	@Override
	public List<ProductVO> prodList() {
		return mapper.selectProdList();
	}
	
	@Override
	public boolean removeMember(String mid) {
		return mapper.deleteMember(mid) == 1;
	}
	@Override
	public boolean addMember(MemberVO mvo) {
		return mapper.addMember(mvo) == 1;
	}

}
