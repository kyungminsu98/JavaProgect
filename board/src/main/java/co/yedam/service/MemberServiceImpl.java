package co.yedam.service;

import co.yedam.common.DataSource;
import co.yedam.mapper.MemberMapper;
import co.yedam.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	MemberMapper mapper = DataSource.getInstance().//
			openSession(true).getMapper(MemberMapper.class);
	
	@Override
	public MemberVO loginCheck(MemberVO mvo) {
		return mapper.selectMember(mvo);
	}

}
