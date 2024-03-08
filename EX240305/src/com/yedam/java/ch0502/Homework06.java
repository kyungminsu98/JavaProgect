package com.yedam.java.ch0502;

import java.util.Scanner;

public class Homework06 {

	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0; // 학생수 -> 배열의 최대크기
		int[] scores =null; // 성적들을 저장하는 배열
		Scanner scanner = new Scanner(System.in);

		while(run) {
			System.out.println("------------------------------------------------");
			System.out.println("1.학생수 |2.점수입력 |3.점수리스트 |4.분석 |5.종료 ");
			System.out.println("------------------------------------------------");
			System.out.println("선택 >");

			int selectNo = Integer.parseInt(scanner.nextLine());

			if(selectNo == 1) {
				System.out.println("학생수 >");
				studentNum = Integer.parseInt(scanner.nextLine());
				scores = new int[studentNum];
			}else if(selectNo == 2) {
				System.out.println("점수를 입력하세요.");
                for (int i = 0; i < studentNum; i++) {
                    System.out.print("학생 " + (i + 1) + "의 점수: ");
                    scores[i] = Integer.parseInt(scanner.nextLine());
                }
			}else if(selectNo == 3) {
		        System.out.println("점수 리스트");
                for (int i = 0; i < studentNum; i++) {
                    System.out.println("학생 " + (i + 1) + "의 점수: " + scores[i]);
                }
			}else if(selectNo == 4) {
                int max = 0;
                int totalScore = 0;
                for (int score : scores) {
                    totalScore += score;
                    if (score > max) {
                        max = score;
                    }
                }
                System.out.println("최고점수: " + max);
                double avg = (double) totalScore / studentNum;
                System.out.println("평균점수: " + avg);
			}else if(selectNo == 5) {
				//종료
				run = false;
			}
		}
		System.out.println("프로그램 종료");
		
	}

}

