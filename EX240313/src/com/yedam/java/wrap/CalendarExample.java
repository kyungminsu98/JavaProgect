package com.yedam.java.wrap;

import java.util.Calendar;

public class CalendarExample {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int mouth = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		System.out.printf("%d년 %2d월 %2d일",year, mouth, day);
		
		int week =cal.get(Calendar.DAY_OF_WEEK);
		String strWeek = null;
		
	}

}
