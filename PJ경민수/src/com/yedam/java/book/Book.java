package com.yedam.java.book;

public class Book {
	private String isbn; // isbn
	private String title; //도서제목
	private String author; // 저자
	private String content; // 내용
	private int stock; // 재고
	// 생성자 => 기본 생성자
	@Override
	public String toString() {
		return "Book [ISBN(국제표준도서번호) : " + isbn + ", 도서제목 : " + title + ", 도서저자 : " + author + ", 도서내용 : " + content
				+ " ,도서재고 : " + stock + "]";
	}
	public Book() {
    }
    public Book(String isbn, String title, String author, String content, int stock) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.content = content;
        this.stock = stock;
    }

	// 메서드 => getter/setter + toString
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
