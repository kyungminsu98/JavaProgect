package com.yedam.java.book;

import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		BookDAO dao = new BookDAO();
		while(run) {
			System.out.println("=======================================");
			System.out.println(" 1.등록 |2.목록 |3.수정 |4.삭제 |5.종료 |6.종료");
			System.out.println("=======================================");
			
			System.out.println("메뉴선택 >");
			int menu = Integer.parseInt(sc.nextLine());
			
			if(menu == 1) { //등록
				System.out.println("=====게시글 등록=====");
                System.out.println("도서번호 >");
                String bookNum = sc.nextLine();
				System.out.println("도서제목 >");
				String title = sc.nextLine();
				System.out.println("도서저자 >");
				String author = sc.nextLine();
				System.out.println("출판일자 >");
				String date = sc.nextLine();
				System.out.println("도서내용 >");
				String introduction = sc.nextLine();
				
				// 1)
				dao.addBook(title, author, date, introduction, introduction);
				// 2)
//				Book book = new Book(bookNum, title, author, date, introduction);
//				dao.addBook(book);
			}else if(menu == 2) { // 목록
				System.out.println("=====도서 목록=====");
				dao.printAllBook();
			}else if(menu == 3) { // 수정
				System.out.println("=====도서 수정=====");
				System.out.print("수정할 도서 제목 >");
				String title = sc.nextLine();
				
				Book book = dao.getBook(title);
				System.out.println(book.getBookInfo());
				
				System.out.print("수정할 내용 >");
				String introduction = sc.nextLine();
				dao.updateBook(title, introduction);
			}else if(menu == 4) { // 삭제
				System.out.println("=====도서 삭제=====");
				System.out.print("삭제할 도서 제목 >");
				String title = sc.nextLine();
				
				dao.delBook(title);
			}else if(menu == 5) { // 검색
                System.out.println("=====도서 검색=====");
                System.out.print("검색어 > ");
                String keyword = sc.nextLine();
                dao.searchBook(keyword);
			}else if(menu == 6) { // 종료
				run = false;
			}else {
				System.out.println("메뉴를 잘못선택했습니다.");
				
		
		}System.out.println("프로그램 종료되었습니다.");	

		}
	}
}
