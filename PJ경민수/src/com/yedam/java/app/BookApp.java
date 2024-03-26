package com.yedam.java.app;
import java.util.List;
import java.util.Scanner;

import com.yedam.java.book.Book;
import com.yedam.java.book.BookDAO;
import com.yedam.java.member.Member;
import com.yedam.java.member.MemberDAO;

public class BookApp {
	private Scanner sclogin = new Scanner(System.in);
	
	//싱글톤
	private static Member loginInfo = null;
	public static Member getLoginInfo() {
		return loginInfo;
	}
	
	//권한체크
	public static boolean selectLoginRole() {
		int memberRole = loginInfo.getMemberRole();
		if(memberRole == 0) {
			return true;
		}else {
			return false;
		}
	}
	//필드
	private Scanner sc = null;
	private BookDAO bookDAO = null;
	// 생성자
	public BookApp() {
		sc = new Scanner(System.in);
		bookDAO = BookDAO.getInstance();
	}
	
	public void run() {
		while(true) {
			// 메뉴출력
			menuPrint();
			// 메뉴선택
			int menu = selectMenu();
			// 각 메뉴별 실제 실행
			if(menu == 1) { // 전체조회
				selectBookAll();
			}else if(menu == 2) { //단건조회
				selectBookOne();
			}else if(menu == 3) { //로그인
				login();
			}else if(menu == 4) {
				end();
				break;
			}else {
				showError();
			}			
		}
	}
	
	public void showError() {
		System.out.println("숫자로 입력해주시기 바랍니다.");
		System.out.println("메뉴에서 선택해주시기 바랍니다.");
	}
	
	private void end() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	private void menuPrint() {
		String menu = "";
		menu += "1.전체조회 ";
		menu += "2.개별조회 ";
		menu += "3.로그인 ";
		menu += "4.종료 ";
		System.out.println("==========");
		System.out.println(menu);
		System.out.println("==========");
	}
	
	private int selectMenu() {
		System.out.print("선택 > ");
		return inputNumber();		
	}
	
	private int inputNumber() {
		int num = 0;
		try {
			num = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("숫자로 입력해주시기 바랍니다.");
		}
		return num;
	}
	
	public void selectBookAll() {
		//1. 부서정보 전체조회
		List<Book> list = bookDAO.selectBookAll();
		
		//2. 결과처리
		//2-1) Success : 전체 출력
		//2-2) fail    : 별도 메세지 출력
		if(list.isEmpty()) {
			System.out.println("데이터가 존재하지 않습니다.");
		}else {
			System.out.println("ISBN | 도서제목 | 저자 | 내용 | 재고");
			for(Book book : list) {
				System.out.println(book);
			}
		}
	}
	
	public void selectBookOne() {
		System.out.println("조회할 도서 정보를 입력하세요.");
		System.out.println("1. ISBN  2. 도서 제목  3. 저자");
		    int searchType = inputNumber();
		// 입력
		String searchValue = "";
		    if (searchType == 1) {
		        searchValue = inputisbn();
		    }else if (searchType == 2) {
		        searchValue = inputtitle();
		    }else if (searchType == 3) {
		        searchValue = inputauthor();
		    }else {
		        System.out.println("잘못된 입력입니다.");
		        return;
		    }
		// 조회
		Book book = null;
			switch (searchType) {
		        case 1:
		            book = bookDAO.selectBookInfo(searchValue, null, null);
		            break;
		        case 2:
		        	book = bookDAO.selectBookInfo(null, searchValue, null);
		            break;
		        case 3:
		        	book = bookDAO.selectBookInfo(null, null, searchValue);
		            break;
		    }
		// 출력
		if (book == null) {
			System.out.println("해당 도서는 존재하지 않습니다.");
		}else {
			System.out.println("도서 정보");
		    System.out.println("ISBN: " + book.getIsbn());
		    System.out.println("도서 제목: " + book.getTitle());
		    System.out.println("저자: " + book.getAuthor());
		    System.out.println("내용: " + book.getContent());
		    System.out.println("재고: " + book.getStock());
		}
	}
	
	private String inputisbn() {
	    System.out.print("ISBN을 입력하세요 > ");
	    return sc.nextLine();
	}
	private String inputtitle() {
		System.out.println("도서제목을 입력하세요 >");
		return sc.nextLine();
	}
	private String inputauthor() {
		System.out.println("도서저자를 입력하세요 >");
		return sc.nextLine();
	}
	private void login() {
		//아이디와 비밀번호 입력
		Member inputInfo = inputMember();
		//로그인 시도
		loginInfo = MemberDAO.getInstance().selectOne(inputInfo);
		//실패할 경우 그대로 메소드 종료
		if(loginInfo == null) { 
			System.out.println("|로그인 실패|");
			return;
		}
	    System.out.println("|로그인 성공|");
	    if (loginInfo.getMemberRole() == 0) {
	    	System.out.println("|관리자 계정 로그인|");
	        new AdminLogin().run(); // 관리자 계정으로 로그인한 경우
	    } else {
	    	System.out.println("|사용자 로그인|");
	        new UserLogin().run(); // 일반 사용자 계정으로 로그인한 경우
	    }
	}
	private Member inputMember() {
		Member info = new Member();
		System.out.print("아이디 > ");
		info.setMemberId(sclogin.nextLine());
		System.out.print("비밀번호 > ");
		info.setMemberPassword(sclogin.nextLine());
		return info;
	}
}


