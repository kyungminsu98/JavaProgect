//package co.yedam.control;
//
//import java.io.IOException;
//import java.util.Date;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import co.yedam.common.Control;
//import co.yedam.service.MemberService;
//import co.yedam.service.MemberServiceImpl;
//import co.yedam.vo.MemberVO;
//
//public class AddMemberControl implements Control {
//
//    @Override
//    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String memberId = req.getParameter("memberID");
//        String memberPw = req.getParameter("memberPw");
//        String memberNm = req.getParameter("memberName");
//        Date createDate = req.getParameter("createDate");
//        String phone = req.getParameter("phone");
//        // MemberVO 객체를 생성하여 회원 정보를 설정합니다.
//        MemberVO member = new MemberVO();
//        member.setMemberId(memberId);
//        member.setMemberPw(memberPw);
//        member.setMemberNm(memberNm);
//        member.setCreateDate(createDate);
//        member.setPhone(phone);
//        
//        
//        // MemberService를 사용하여 회원 가입을 처리합니다.
//        MemberService memberService = new MemberServiceImpl();
//        boolean isSuccess = memberService.addMember(member);
//        
//        // 회원 가입 성공 여부에 따라 적절한 응답을 합니다.
//        if (isSuccess) {
//            // 회원 가입이 성공하면 메인 페이지로 리다이렉트합니다.
//            resp.sendRedirect("main.jsp");
//        } else {
//            // 회원 가입에 실패하면 오류 메시지를 설정하고 회원 가입 페이지로 포워딩합니다.
//            req.setAttribute("errorMsg", "회원 가입에 실패했습니다. 다시 시도해 주세요.");
//            req.getRequestDispatcher("signup.jsp").forward(req, resp);
//        }
//    }
//
//        
//      
//}

