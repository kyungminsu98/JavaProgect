package com.yedam.java.ch02;

import java.util.Scanner;

public class InOutExample {

	public static void main(String[] args) {
		
		String name = "Hong";
		int age = 20;
		double score = 90.86;
		
		// 이름 : Hong, 나이 : 20 / 평균점수 : 90.8
		System.out.print("이름 : " + name);
		System.out.print(" , 나이 : " + age);
//		System.out.print(" / 평균점수 : " + String.format("%.1f", score) + "\n");
		System.out.println(" / 평균점수 : " + String.format("%.1f", score) + "\n");
		
		System.out.printf("이름 : %s , 나이 : %d / 평균점수 : %.1f \n", name, age, score);
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력> ");
		String strVal = sc.nextLine();
		System.out.println("실제 출력 : "+ strVal);
		
		sc.close();
		
	}

}
