package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;
import co.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		MemberService svc = new MemberServiceImpl();
		
		MemberVO vo = new MemberVO();
		vo.setMemberId(id);
		vo.setMemberPw(pw);
		
		vo = svc.loginCheck(vo);
		HttpSession session = req.getSession();
		if(vo != null) {
			session.removeAttribute("msg");
			session.setAttribute("logId", vo.getMemberId());
			session.setAttribute("auth", vo.getResponsibility()); // User / Admin
			
//			session.setAttribute("logPw", vo.getMemberPw());
			if (vo.getResponsibility().equals("Admin")) {
				// 관리자 페이지
				resp.sendRedirect("memberList.do");
//				req.getRequestDispatcher("member/user.tiles").forward(req, resp);
			} else {
				// 사용자 페이지
				req.getRequestDispatcher("user/user.tiles").forward(req, resp);
//				resp.sendRedirect("boardList.do");
			}
		} else {
			session.setAttribute("msg", "id와 password를 확인하세요.");
			resp.sendRedirect("loginForm.do");
//			req.getRequestDispatcher("board/loginForm.tiles").forward(req, resp);
		}
		
	}

}
