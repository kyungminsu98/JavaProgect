package com.yedam.java.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.java.app.BookApp;
import com.yedam.java.book.Book;
import com.yedam.java.book.BookDAO;
public class UserLogin {
	// 필드
	private Scanner sc = null;
	private BookDAO bookDAO = null;

	// 생성자
	public UserLogin() {
		sc = new Scanner(System.in);
		bookDAO = BookDAO.getInstance();
	}
	BookApp bookApp = new BookApp();
	public void run() {
		while (true) {
			// 메뉴출력
			usermenuPrint();
			// 메뉴선택
			int menu = selectMenu();

			if (menu == 1) {
				bookApp.selectBookAll();
			}else if (menu == 2) {
                bookApp.selectBookOne();
			}else if (menu == 3) {
				// 도서대출
			}else if (menu == 4) {
				// 도서반납
			}else if (menu == 5) {
				
			}else if(menu == 9){
				logout();
				break;
			}else {
	            bookApp.showError();
			}			
		}

	}
	
	private void logout() {
		System.out.println("|로그아웃|");
	}
	private void usermenuPrint() {
		String menu = "";
		menu += "1.전체조회 ";
		menu += "2.개별조회 ";
		menu += "3.도서대출 ";
		menu += "4.도서반납 ";
		menu += "5.문의 ";
		menu += "9.로그아웃";
		
		System.out.println("===");
		System.out.println(menu);
		System.out.println("===");
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
}
