package co.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// HttpServlet(부모)은 생명주기가 존재
// init() -> service() ... -> destroy()

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.BoardMapper;
import co.yedam.vo.BoardVO;

public class FirstServlet extends HttpServlet{ 
	private static final long serialVersionUID = 1L;
	
	// constructor
	public FirstServlet() {
		System.out.println("FirstServlet 생성자 호출");
	}
	
	// init()
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출");
	}
	
	// service()
	// 사용자의 요청정보 처리할 : HttpServletRequest req
	// 사용자에게 전달할 응답정보 : HttpServletResponse resp
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 게시글목록 출력.
		resp.setContentType("text/html;charset=utf-8"); // 기본-> text/plain = text 형식 출력.
		
		SqlSession session = DataSource.getInstance().openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		//List<BoardVO> list = mapper.selectList(1);
		
		PrintWriter out = resp.getWriter();
		
		String html = "<table border='1'>";
		html += "<thead><tr><th>글번호</th><th>제목</th><th>내용</th><th>작성자</th><th>작성일시</th></thead>";
		html += "<tbody>";
//		for (BoardVO board : list) {
//			html += "<tr>"
//				  + "<td>"+ board.getBoardNo() +"</td><td>"+ board.getTitle() +"</td><td>"+ board.getContent() +"</td>"
//				  + "<td>"+ board.getWriter() +"</td><td>"+ board.getCreateDate()+"</td>"
//				  + "</tr>";
//		}
		html += "</tbody>";
		html += "</table>";
		
		
		out.print(html);
	}
	
	// destroy()
	@Override
	public void destroy() {
		System.out.println("destroy() 호출");
	}
}
