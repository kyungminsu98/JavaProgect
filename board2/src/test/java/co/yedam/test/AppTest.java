package co.yedam.test;

import co.yedam.common.SearchVO;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;

public class AppTest {
	public static void main(String[] args) {
//		SqlSessionFactory factory = DataSource.getInstance();
//		SqlSession session = factory.openSession();
//		BoardMapper mapper = session.getMapper(BoardMapper.class);
//		
//		String time = session.selectOne("co.yedam.mapper.BoardMapper.getTimes");
//		System.out.println(time);
//		
//		List<BoardVO> list = mapper.selectList();
//		list.forEach(board -> {
//			System.out.println(board.toString());
//		});
		
		SearchVO search = new SearchVO();
		search.setPage(1);
		search.setSearchCondition("T");
		search.setKeyword("java");
		BoardService svc = new BoardServiceImpl();
		svc.boardList(search).forEach(board -> System.out.println(board.toString()));;
	}
}
