package co.yedam.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainControl implements Control{
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("main.do 요청이 되었습니다.");
	}
}
