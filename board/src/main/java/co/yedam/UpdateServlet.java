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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get 요청일 실행.
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 저장 후 "저장성공"메세지 출력
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		System.out.println("title : "+title+",content : "+ content +",writer :" + writer);
		
		BoardVO board =new BoardVO();
    	board.setTitle(title);
    	board.setWriter(writer);
    	board.setContent(content);
    	
    	SqlSession session = DataSource.getInstance().openSession(true);
    	BoardMapper mapper =session.getMapper(BoardMapper.class);
    	if(mapper.updateBoard(board) == 1) {
    		response.getWriter().println("OK");
    		session.commit();
    	}else {
    		response.getWriter().println("NG");
    	}

    	
	}

}