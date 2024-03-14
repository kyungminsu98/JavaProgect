package com.yedam.java.String;

public class StringExample {

	public static void main(String[] args) {
		String ssn = "010624-1230123";
		char gender = ssn.charAt(7);
		
	switch(gender){
		case '1' :
		case '3' :
			System.out.println("남자압니다");
			break;
		case '2' :
		case '4' :
			System.out.println("여자입니다.");
			break;
	}
	
	// indexOf() : 문장에 원하는 값이 있는지 없는지
	String subject = "자바 프로그래밍";
	int Iocation =subject.indexOf("프로그래밍");
	System.out.println(Iocation);
	
	if(subject.indexOf("자바") > -1) {
		System.out.println("지바와 관련된 책이군요");
	}else {
		System.out.println("자바와 관련없는 책이군요");
	}
	// substring(), length()
	String search =subject.substring(Iocation, subject.length());
	System.out.println(search);
	
	ssn ="010624-1230123";
	String birthday =ssn.substring(0,6);
	System.out.println(birthday);
	
	// toLowerCase(), toUpperCase()
	String valA = "Hello, World";
	String valB = "HELLO, WORLD";
	if(valA.toLowerCase().equals(valB.toLowerCase())) {
		System.out.println("같은 글자입니다.");
	}else {
		System.out.println("다른 글자입니다.");
	}
	System.out.println(valA.toLowerCase());
	System.out.println(valB.toLowerCase());
	}

}
