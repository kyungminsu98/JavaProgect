package com.yedam.java.exam;

public class Book { // 한권
	//필드 => 값을 저장 / 제목, 작가, 메모
	String title; //제목
	String writer; //작가
	String message; //메모
	
	//생성자 => 인스턴스(객체)를 만듦
	Book(String title, String writer, String message){
		this.title = title;
		this.writer = writer;
		this.message = message;
	}
}
