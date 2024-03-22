package com.yedam.java.homework;

public abstract class Culture {
	//필드
	protected String title;
	protected int director;
	protected int actor;
	protected int audience;
	protected int totalScore;
	
	//생성자
	public Culture(String title, int director, int actor) {
		this.title = title;
		this.director = director;
		this.actor = actor;
	}
	
	//메소드
	public void setTotalScore(int score) {
		this.audience++;
		this.totalScore += score;
	}
	
	public String getGrade() {
		int avg = this.totalScore/this.audience;
		String grade = null;
		switch(avg) {
		case 1:
			grade = "☆";
			break;
		case 2:
			grade = "☆☆";
			break;
		case 3:
			grade = "☆☆☆";
			break;
		case 4:
			grade = "☆☆☆☆";
			break;
		case 5:
			grade = "☆☆☆☆☆";
			break;
		}
		
		return grade;
	}
	
	public abstract void getInformation();
	
}
