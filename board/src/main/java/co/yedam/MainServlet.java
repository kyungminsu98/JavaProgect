package co.yedam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.BoardMapper;
import co.yedam.vo.BoardVO;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get요청을 실행
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); // 출력 스트림
		out.print("안녕하세요");
		out.print("<br><a href='info/resume.html'>resume 페이지로 이동</a>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		SqlSession session = DataSource.getInstance().openSession(true);
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		if (mapper.deleteBoard(Integer.parseInt(request.getParameter("bno"))) == 1) {
			response.getWriter().println("OK");
		} else {
			response.getWriter().println("NG");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		// 저장 후 "저장성공" 메세지 출력.
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		System.out.println(title + " " + content + " " + writer);
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		SqlSession session = DataSource.getInstance().openSession(true);
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		if (mapper.insertBoard(board) == 1) {
			response.getWriter().println("OK");
		} else {
			response.getWriter().println("NG");
		}
	}

}
