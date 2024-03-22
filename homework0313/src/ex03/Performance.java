package com.yedam.java.homework;

public class Performance extends Culture {
	private String genre;
	
	public Performance(String title, int director, int actor, String genre) {
		super(title, director, actor);
		this.genre = genre;
	}
	
	@Override
	public void getInformation() {
		System.out.println(genre + "제목 : " + title);
		System.out.println("감독 : " + director);
		System.out.println(genre + "총점 : " + totalScore);
		System.out.println(genre + "평점 : " + getGrade());
	}

}
