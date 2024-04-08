package co.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;
import co.yedam.vo.MemberVO;

public class MemberListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService svc = new MemberServiceImpl();
		
		List<MemberVO> list = svc.memberList();
		
		req.setAttribute("mlist", list);
		
		// 관리자인지 체크
		HttpSession session = req.getSession();
		String auth = (String) session.getAttribute("auth");
		auth = auth != null ? auth : "";
		if (auth.equals("Admin")) {
			req.getRequestDispatcher("member/memberList.tiles").forward(req, resp);
		} else {
			req.setAttribute("msg", "권한이 없습니다.");
			req.getRequestDispatcher("board/error.tiles").forward(req, resp);
		}
	}

}
