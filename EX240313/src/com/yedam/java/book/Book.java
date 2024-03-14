package com.yedam.java.book;

public class Book {
	private String bookNum; // 도서번호
	private String title; // 도서제목
	private String author; // 도서저자
	private String date; // 출판일자
	private String introduction; // 도서소개
	
    public Book(String bookNum, String title, String author, String date, String introduction) {
        this.bookNum = bookNum;
        this.title = title;
        this.author = author;
        this.date = date;
        this.introduction = introduction;
    }
    public String getBookNum() {
        return bookNum;
    }
    public void setBookNum(String bookNum) {
        this.bookNum = bookNum;
    }

    // 도서제목의 getter
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    // 도서저자의 getter
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    // 출판일자의 getter
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    // 도서소개의 getter
    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public String getBookInfo() {
    	return bookNum + " "+ title + " " + author + " " + date + " " + introduction;
    }
    
}

