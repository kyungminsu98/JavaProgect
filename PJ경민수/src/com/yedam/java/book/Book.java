package com.yedam.java.book;

public class Book {
	private int isbn; // isbn
	private String title; //도서제목
	private String author; // 저자
	private String content; // 내용
	private int inventory; // 재고
	// 생성자 => 기본 생성자
		@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", content=" + content
				+ ", inventory=" + inventory + "]";
	}
	// 메서드 => getter/setter + toString
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
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
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
	
}
