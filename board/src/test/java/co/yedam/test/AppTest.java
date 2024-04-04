package co.yedam.test;

import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.SearchVO;

public class AppTest {

	public static void main(String[] args) {
		SearchVO search =new SearchVO();
		search.setPage(1);
		search.setSearchCondition("W");
		search.setKeyword("user01");
		
		
		BoardService svc = new BoardServiceImpl();
		svc.boardList(search).forEach(board -> System.out.println(board.toString()));

	}

}
