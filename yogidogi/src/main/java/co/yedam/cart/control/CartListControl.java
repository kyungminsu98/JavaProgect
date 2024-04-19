package co.yedam.cart.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;

public class CartListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		resp.setContentType("text/json;charset=utf-8");
//		String memberNo = req.getParameter("memberNo");
//
//		CartService svc = new CartServiceImpl();
//		List<CartVO> list = svc.cartList(Integer.parseInt(memberNo));
//		Gson gson = new GsonBuilder().create();
//		
//		try {
//			resp.getWriter().print(gson.toJson(list));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		req.setAttribute("cartList", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("cart/cartList.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}

