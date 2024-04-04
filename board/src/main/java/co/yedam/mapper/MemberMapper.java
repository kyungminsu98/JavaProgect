package co.yedam.mapper;

import co.yedam.vo.MemberVO;

public interface MemberMapper {
	public MemberVO selectMember(MemberVO mvo);
	public int insertMember(MemberVO mvo);
	
	
}
