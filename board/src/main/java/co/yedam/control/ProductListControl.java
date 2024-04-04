package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.vo.ProductVO;

public class ProductListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String prodCode = req.getParameter("code");
        String prodName = req.getParameter("name");
        String prodDesc = req.getParameter("desc");
        int price = Integer.parseInt(req.getParameter("price"));
        Integer salePrice = null;
        if (req.getParameter("salePrice") != null && !req.getParameter("salePrice").isEmpty()) {
            salePrice = Integer.parseInt(req.getParameter("salePrice"));
        }
        int likeCnt = 3; // likeCnt는 기본값으로 3 설정
        String prodImg = req.getParameter("Img");

        // 상품 정보를 담은 객체 생성
        ProductVO product = new ProductVO();
        product.setProdCode(prodCode);
        product.setProdName(prodName);
        product.setProdDesc(prodDesc);
        product.setPrice(price);
        product.setSalePrice(salePrice);
        product.setLikeCnt(likeCnt);
        product.setProdImg(prodImg);
        }
}