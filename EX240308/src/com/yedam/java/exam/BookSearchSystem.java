package com.yedam.java.exam;

import java.util.Scanner;

public class BookSearchSystem {
	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		Book[] bookList = new Book[10];
		int current = 0;
		
		while(run) {
			System.out.println("=============================");
			System.out.println(" 1.도서등록 | 2.도서검색 ");
			System.out.println(" 3.전체목록 | 5.종료");
			System.out.println("=============================");
			
			System.out.print("메뉴 선택>");
			int menu = Integer.parseInt(sc.nextLine());
			
			if(menu == 1) { //도서등록
				System.out.println("도서 제목 > ");
				String title = sc.nextLine();
				System.out.println("도서 작가 > ");
				String writer = sc.nextLine();
				System.out.println("도서 메모 > ");
				String message = sc.nextLine();
				
				Book book = new Book(title, writer, message);
				bookList[current] = book;
				current = current + 1;
				
			}else if(menu == 2) { //도서검색
				//1. 검색어
				System.out.print("검색어 > ");
				String keyword = sc.nextLine();
								
				//2. 실제 검색
				for(int i=0; i<current; i++) {
					Book book = bookList[i];
					
					if(keyword.equals(book.title)) {
						System.out.printf("%s, %s, %s\n", 
							book.title, book.writer, book.message);
					};
				}
				
			}else if(menu == 3) { //전체목록
				for(int i=0; i<current; i++) {
					Book book = bookList[i];
					System.out.printf("%s, %s, %s\n", 
							book.title, book.writer, book.message);
				}
			}else if(menu == 5) {
				run = false;
			}else {
				System.out.println("메뉴를 잘못 입력했습니다.");
			}
		}
		
		System.out.println("프로그램을 종료하겠습니다.");
		sc.close();
	}
}
