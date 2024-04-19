package co.yedam.cart.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.cart.service.CartService;
import co.yedam.cart.service.CartServiceImpl;
import co.yedam.cart.vo.CartVO;
import co.yedam.common.Control;

public class AddCartControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
        resp.setContentType("application/json; charset=utf-8");
        
        // memberNo와 proNo 요청 파라미터를 받아옴
        String memberNoStr = req.getParameter("memberNo");
        String proNoStr = req.getParameter("proNo");
        int quantity = 1;

        // 파라미터를 int로 변환하고 예외를 처리
        int memberNo = 0;
        int proNo = 0;

        try {
            memberNo = Integer.parseInt(memberNoStr);
            proNo = Integer.parseInt(proNoStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }

        // CartVO 객체 생성 및 설정
        CartVO vo = new CartVO();
        vo.setMemberNo(memberNo);
        vo.setProNo(proNo);
        vo.setQty(quantity);
        
        // CartService 인스턴스 생성
        CartService svc = new CartServiceImpl();
        Map<String, Object> map = new HashMap<>();
        
        // addCart() 메서드 호출
        int result = svc.addCart(vo);
        if (result == 1) {
            map.put("retCode", "OK");
        } else if (result == 2) {
            map.put("retCode", "CK");
        } else {
            map.put("retCode", "NG");
        }
        
		
		Gson gson = new GsonBuilder().create();
		try {
			resp.getWriter().print(gson.toJson(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
