package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class AddBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// title, content, writer 3개의 파라미터가 넘어옴
		BoardService svc = new BoardServiceImpl();
		
		// 생성자 매개값 1.요청정보, 2.저장경로, 3.최대크기, 4.인코딩, 5.리네임정책
		String savePath = req.getServletContext().getRealPath("upload");
		int maxSize = 1024 * 1024 * 5;
		
		MultipartRequest multi = new MultipartRequest(req, savePath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String writer = multi.getParameter("writer");
		String img = multi.getFilesystemName("myImg");

		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		vo.setImg(img);
		
		if (svc.addBoard(vo)) {
			resp.getWriter().print("{\"retCode\" : \"Success\"}");
			resp.sendRedirect("boardList.do");
		} else {
			resp.getWriter().print("{\"retCode\" : \"Fail\"}");
			req.setAttribute("msg", "등록중 에러가 발생.");
			req.getRequestDispatcher("board/error.tiles").forward(req, resp);
		}
	}

}
