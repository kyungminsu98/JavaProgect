package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;
import co.yedam.vo.SearchVO;

public class ModifyBoardForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bno = Integer.parseInt(req.getParameter("bno"));
		
		BoardService svc = new BoardServiceImpl();
		BoardVO bvo = svc.getBoard(bno);
		
		req.setAttribute("bvo", bvo);
		
		// 페이지 따라가기
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		String page = req.getParameter("page");
		
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		req.setAttribute("page", page);
		
		req.getRequestDispatcher("board/modifyForm.tiles").forward(req, resp);
	}
}
