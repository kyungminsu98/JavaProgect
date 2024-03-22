package com.yedam.java.homework;

public class CultureExample {
	public static void main(String[] args) {
		Movie movieInfo = new Movie("추격자", 7, 5, "영화");
		movieInfo.setTotalScore(4);
		movieInfo.setTotalScore(1);
		movieInfo.setTotalScore(2);
		movieInfo.setTotalScore(5);
		
		movieInfo.getInformation();
		System.out.println("================================");
		
		Performance performance = new Performance("지킬앤하이드", 9, 10, "공연");
		
		performance.setTotalScore(5);
		performance.setTotalScore(5);
		performance.setTotalScore(5);
		performance.setTotalScore(5);
		performance.setTotalScore(5);
		performance.setTotalScore(5);
		performance.setTotalScore(5);
		performance.setTotalScore(5);
		performance.setTotalScore(2);
		performance.setTotalScore(1);
		performance.setTotalScore(3);
		
		performance.getInformation();
	}
}
