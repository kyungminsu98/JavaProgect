package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.control.AddBoard;
import co.yedam.control.AddBoardForm;
import co.yedam.control.AddMemberAjax;
import co.yedam.control.AddMemberControl;
import co.yedam.control.AddMemberForm;
import co.yedam.control.AddReply;
import co.yedam.control.BoardControl;
import co.yedam.control.BoardListControl;
import co.yedam.control.CartList;
import co.yedam.control.ChartForm;
import co.yedam.control.ChartJson;
import co.yedam.control.DataForm;
import co.yedam.control.DataTable;
import co.yedam.control.DelCart;
import co.yedam.control.DomForm;
import co.yedam.control.EditCart;
import co.yedam.control.LoginControl;
import co.yedam.control.LoginFormControl;
import co.yedam.control.LogoutControl;
import co.yedam.control.MemberAjax;
import co.yedam.control.MemberDataControl;
import co.yedam.control.MemberForm;
import co.yedam.control.MemberListControl;
import co.yedam.control.ModifyBoard;
import co.yedam.control.ModifyBoardForm;
import co.yedam.control.RemoveBoard;
import co.yedam.control.RemoveBoardForm;
import co.yedam.control.RemoveMemberControl;
import co.yedam.control.RemoveReply;
import co.yedam.control.ReplyCount;
import co.yedam.control.ReplyList;

// init -> service -> destroy
public class FrontControl extends HttpServlet {

	// url pattern - 실행서블릿. 관리.
	Map<String, Control> map;

	public FrontControl() {
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainControl());
		map.put("/second.do", null);
		map.put("/resume.do", new ResumeControl());

		// 게시글목록.
		map.put("/boardList.do", new BoardListControl());
		map.put("/getboard.do", new BoardControl());
		map.put("/addForm.do", new AddBoardForm());// 등록화면.
		map.put("/addBoard.do", new AddBoard());// 등록기능.
		map.put("/modifyForm.do", new ModifyBoardForm());
		map.put("/modifyBoard.do", new ModifyBoard());
		map.put("/removeForm.do", new RemoveBoardForm());
		map.put("/removeBoard.do", new RemoveBoard());

		// member관련.
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());

		// 회원가입.
		map.put("/addMemberForm.do", new AddMemberForm());
		map.put("/addMember.do", new AddMemberControl());
		map.put("/memberList.do", new MemberListControl());

		// json 데이터 생성.
		map.put("/domForm.do", new DomForm());
		map.put("/memberData.do", new MemberDataControl());

		map.put("/memberForm.do", new MemberForm()); // 회원관리화면 Ajax처리.
		map.put("/memberAjax.do", new MemberAjax()); // 회원목록 json 반환.
		map.put("/removeMember.do", new RemoveMemberControl());
		map.put("/addMemberAjax.do", new AddMemberAjax());

		map.put("/replyList.do", new ReplyList()); // 목록json
		map.put("/removeReply.do", new RemoveReply()); // 삭제json
		map.put("/replyCount.do", new ReplyCount());
		map.put("/addReply.do", new AddReply());

		// 차트.
		map.put("/chartForm.do", new ChartForm());
		map.put("/chartJson.do", new ChartJson());

		// datatable.
		map.put("/datatable.do", new DataTable());
		
		// 카트목록.
		map.put("/cartList.do", new CartList());
		// 수량변경.
		map.put("/editCart.do", new EditCart());
		// 카트상품삭제.
		map.put("/delCart.do", new DelCart());

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		resp.setContentType("text/html;charset=utf-8");

		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());

		System.out.println("uri: " + uri + ", contxt: " + context + ", path: " + path);
		Control control = map.get(path);
		control.exec(req, resp);
	}
}
