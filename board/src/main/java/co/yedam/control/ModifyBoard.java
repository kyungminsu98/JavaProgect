package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class ModifyBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//boardNo, title, content
        String boardNoStr = req.getParameter("boardNo"); // 게시글 번호를 문자열로 가져옴
        int boardNo = Integer.parseInt(boardNoStr); // 문자열을 int로 변환
        String title = req.getParameter("title");
        String content = req.getParameter("content");
		String page =req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
        BoardVO vo = new BoardVO(); 
        vo.setBoardNo(boardNo);
        vo.setContent(content);
        vo.setTitle(title);
        
		req.setAttribute("page", page);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
        BoardService svc = new BoardServiceImpl();
        if(svc.modifyBoard(vo)) { // 수정 메서드로 변경
            resp.sendRedirect("boardList.do?page=" + page + "&searchCondition=" + sc + "&keyword=" + kw);
        } else {
            req.setAttribute("msg", "수정 중 에러가 발생.");
            req.getRequestDispatcher("WEB-INF/view/error.jsp").forward(req, resp);
        }
    }
}

