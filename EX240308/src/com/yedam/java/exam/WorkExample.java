package com.yedam.java.exam;

import java.util.Scanner;

public class WorkExample {

	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		Work[] workList = new Work[10];
		int current = 0;
		
		while(run) {
			System.out.println("=============================");
			System.out.println("1.할일추가 |2.할일확인");
			System.out.println("3.할일완료 |4.전체목록 |5.종료");
			System.out.println("=============================");
			
			System.out.println("메뉴 선택 >");
			int menu = Integer.parseInt(sc.nextLine());
			if(menu == 1) { // 할일 추가
				/*
				 * 사용자가 해야하는 애용을 입력하면
				 * 그 내용을 이용해서 Work클래스를 새로 생성하고
				 * 변수 workList에 추가하는 기능
				 */
				System.out.print("할일추가 >");
				String content = sc.nextLine();
				
				Work work = new Work(content);
				workList[current++] = work;
			}else if(menu ==2) {// 할일확인
				/*
				 * 현재 등록된 할일 중 미완료된 할일 출력
				 */
				for(int i=0; i<current; i++) {
					Work work = workList[i];
					if(work.getCompletion()) continue;
					
					String content = work.getWorkContent();
					System.out.printf("%d. %s\n", i, content);
				}
			}else if(menu ==3) {// 할일완료
				/*
				 * 현재 등록된 할일 중 완료하고자 하는 할일 선택 : 인덱스 값
				 */
				System.out.print("완료할 일 >");
				int selected = Integer.parseInt(sc.nextLine());
				
				workList[selected].isCompleted();
				workList[selected].printWork();
			}else if(menu ==4) {// 전체목록
				/*
				 * 현재 등록된 모든 할일들을 출력 
				 */
				for(int i=0; i<current; i++) {
					workList[i].printWork();
				}
			}else if(menu ==5) {// 종료
				run = false;
			}else {
				System.out.println("메뉴를 잘못 입력했습니다");
			}
		}
		System.out.println("프로그램을 종료하겠습니다.");
		sc.close();
	}

}
