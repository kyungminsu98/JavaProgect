package com.yedam.java.exam;

import java.util.Scanner;

public class BookSearchSystem {

	public static void main(String[] args) {
		/* 
		== 도서 검색 시스템 : 클래스명 BookSearchSystem
		메뉴
		 1.도서등록 | 2.도서검색 | 3.전체출력 | 5.종료
		 
		[메뉴1] 도서등록
		  한 도서 정보(제목, 작가, 메모)을 등록
		  => 클래스가 필요, 클래스명은 Book
		  => 필드(제목, 작가, 메모)와 생성자만 
		  등록할 수 있는 도서 수는 최대 10권
		[메뉴2] 도서검색
		  사용자가 도서제목을 입력할 경우
		  해당 도서 정보(제목, 작가, 메모)를 출력
		[메뉴3] 전체출력
		  현재 등록되어 있는 모든 도서들의 정보(제목, 작가, 메모)를 출력
		  
		*/
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		Book[] bookList = new Book[10];
		int current = 0;
		
		while(run) {
			System.out.println("=============================");
			System.out.println("1.도서등록 |2.도서검색");
			System.out.println("3.전체출력 |4.종료");
			System.out.println("=============================");
			
			System.out.println("메뉴 선택 >");
			int menu = Integer.parseInt(sc.nextLine());
			if(menu == 1){
				System.out.print("도서 제목 >");
				String title = sc.nextLine();
				System.out.print("도서 작가 >");
				String writer = sc.nextLine();
				System.out.print("도서 메모 >");
				String message = sc.nextLine();
				Book book = new Book(title, writer, message);
				bookList[current] = book;
				current = current + 1;
				// 46행 증감연산자를 써도된다.
			}else if(menu ==2) { // 도서검색
				// 1.검색어
				System.out.println("검색어 >");
				String keyword = sc.nextLine();
				// 2.실제검색
				for(int i=0;i< current;i++) {
					Book book = bookList[i];
					
					if(keyword.equals(book.title)) {
						System.out.printf("%s, %s, %s\n",book.title,book.writer,book.message);
					}
				}
			}else if(menu ==3) { // 전체목록
				for(int i=0;i< current;i++) {
					Book book = bookList[i];
					System.out.printf("%s, %s, %s\n",book.title,book.writer,book.message);
				}
			}else if(menu ==4) {
				run = false;
			}
			}
		System.out.println("프로그램을 종료하겠습니다.");
		sc.close();
	}

}
