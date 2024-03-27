package com.yedam.java.book;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	// 필드 = > 실제 자료를 저장하는 변소
	private List<Book> bookList;
	// 생성자
	public BookDAO() {
		this.bookList =new ArrayList<>();

	}
	// 등록
	public void addBook(String bookNum, String title, String author, String date, String introduction) {
//		String bookNum = newBookNum();
		Book book = new Book(bookNum, title, author, date, introduction);
		bookList.add(book);
	}
//	public String newBookNum() {
//		int maxNum = 0;
//	}
	// 수정
	public void updateBook(String bookNum, String introduction) {
		for(int i =0; i<=bookList.size()-1;i++) {
			Book selBook = bookList.get(i);
			if(bookNum.equals(selBook.getBookNum())) {
//				boardList.get(i).setContent(content);
				selBook.setIntroduction(introduction);
			}
		}
	}
	// 삭제
	public void delBook(String title) {
		for(int i=0; i<=bookList.size()-1;i++) {
			Book selBook = bookList.get(i);
				
			if(title.equals(selBook.getTitle())){
	            bookList.remove(i);
	            System.out.println("도서를 삭제했습니다.");
	            return; 
			}
		}
	}
	// 1) 단건 조회
	public Book getBook(String bookNum) {
		Book selected = null;
		for(Book book : bookList) {
			if(bookNum.equals(book.getBookNum())) {
				selected = book;
			}
		}return selected;
	}
	// 2) 전체조회
	public void printAllBook() {
		for(Book book : bookList) {
			System.out.println(book.getBookInfo());
		}
	}

}
	
	
