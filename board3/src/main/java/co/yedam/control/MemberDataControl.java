package co.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;
import co.yedam.vo.MemberVO;

public class MemberDataControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// json OR xml 포맷의 데이터 전송
		// js object => {name:"홍길동", age:20, ...}
		// json의 경우 모두 문자열 => {"name":"홍길동", "age":20, "point":110, ...}
		// {"name":"홍길동", "age": 20, "point": 120, "phone":"010-1111-2222"}
		resp.setContentType("text/json;charset=utf-8");
		String json = "{\"name\":\"홍길동\", \"age\": 20, \"point\": 120, \"phone\":\"010-1111-2222\"}";
		
		json = ""; // [{}, {}, {}, {}, ...]
		MemberService svc = new MemberServiceImpl();
		List<MemberVO> list = svc.memberList();
		
		int pos = 1;
		json += "[";
		for(MemberVO vo : list) {
			json += "{";
			json += "\"mid\":\""+vo.getMemberId()+"\",";
			json += "\"name\":\""+vo.getMemberNm()+"\",";
			json += "\"phone\":\""+vo.getPhone()+"\"";
			json += "}";
			if(pos++ != list.size()) {
				json += ",";
			}
		}
		json += "]";
		
		resp.getWriter().print(json);
		// redirect, forwording
	}

}
