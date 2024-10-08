package co.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;
import co.yedam.vo.ProductVO;

public class ProductListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberService svc = new MemberServiceImpl();
		
		List<ProductVO> list = svc.prodList();
		
		req.setAttribute("plist", list);
		
		req.getRequestDispatcher("prod/productList.tiles").forward(req, resp);
	}
}
