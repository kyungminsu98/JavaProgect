package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.cart.control.AddCartControl;
import co.yedam.cart.control.CartListControl;
import co.yedam.cart.control.CartListJson;
import co.yedam.cart.control.ModifyCartControl;
import co.yedam.cart.control.RemoveCartControl;
import co.yedam.control.TestControl;

public class FrontControl extends HttpServlet {
	Map<String, Control> map;

	public FrontControl() {
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/test.do", new TestControl());
		// 장바구니
		map.put("/cartList.do", new CartListControl()); // 카트페이지 이동
		map.put("/cartListJson.do", new CartListJson()); // 카트페이지에 정보넘기는 기능
		map.put("/removeCart.do", new RemoveCartControl()); // 카트삭제
		map.put("/modifyCart.do", new ModifyCartControl()); // 카트수정
		map.put("/addCart.do", new AddCartControl()); // 카트등록
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());

		System.out.println("uri : " + uri + ", context : " + context + ", path : " + path);
		Control control = map.get(path);
		control.exec(req, resp);
	}
}
