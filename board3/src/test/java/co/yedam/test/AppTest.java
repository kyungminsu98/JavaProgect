package co.yedam.test;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.SearchVO;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;
import co.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		SearchVO search = new SearchVO();
		search.setBno(3);
		search.setRpage(1);

		// json문자열생성
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.replyList(search);

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String json = gson.toJson(list);
		System.out.println(json);
	}
}
