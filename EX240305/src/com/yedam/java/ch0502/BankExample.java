package com.yedam.java.ch0502;

import java.util.Scanner;

public class BankExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run = true;
		Scanner sc =new Scanner(System.in);
		
		// 프로그램에서 사용할 공용 변수
		int[] accountList = new int[20]; // 보유계좌 목록
		int currentMax = 0; // 현재 보유한 계좌
		
		while(run){
			// 메뉴출력
			System.out.println("---------------------------------");
			System.out.println("1.계좌개설 | 2.예금 | 3.출금 ");
			System.out.println("4.계좌이체 | 5.잔액조회 | 6.종료");
			System.out.println("---------------------------------");
			// 메뉴선택
			System.out.println("메뉴 선택 >");
			int menu = sc.nextInt();
			// 각 메뉴별 기능 수행
			if(menu == 1) { // 계좌개설
				if(currentMax == accountList.length) {
					System.out.println("계좌를 생성할 수 없습니다.");
					System.out.println("은행이 보유할 수 있는 계좌 수는 20개입니다.");
				}else {
					currentMax++;
					int account =currentMax-1;
					System.out.println("계좌를 개설했습니다.");
					System.out.println("계좌번호는" + account + "입니다.");
					System.out.printf("현재 잔액은 %d원입니다.\n",accountList[account]);
				}
			}else if(menu == 2) { // 예금
				System.out.println("예금할 계좌번호 >");
				int account = sc.nextInt(); // accountList의 인덱스
				System.out.println("예금할 금액 >");
				int money = sc.nextInt(); // 해당 인덱스의 값에 더해야하는 값
				accountList[account] = accountList[account] + money;
				System.out.printf("현재 잔액은 %d원입니다.\n",accountList[account]);
			}else if(menu == 3) { // 출금
				System.out.println("출금할 계좌번호 >");
				int account = sc.nextInt(); // accountList의 인덱스
				System.out.println("출금할 금액 >");
				int money = sc.nextInt(); // 해당 인덱스의 값에 더해야하는 값
				accountList[account] = accountList[account] - money;
				if(accountList[account] < money) {
					System.out.println("요청한 출금 금액이 계좌 잔액보다 큽니다");
				}
				System.out.printf("현재 잔액은 %d원입니다.\n",accountList[account]);
			}else if(menu == 4) {// 계좌이체
				System.out.print("출금할 계좌번호 > ");
				int account = sc.nextInt(); // accountList의 인덱스
				System.out.printf("현재 잔액은 %d원입니다.\n", accountList[account]);
				
				System.out.print("출금할 금액 > ");
				int money = sc.nextInt();   // 해당 인덱스의 값에 빼야하는 값
				if( accountList[account] < money ){
					System.out.println("요청한 출금 금액이 계좌잔액보다 큽니다.");
					continue;
				}
				accountList[account] = accountList[account] - money;
			
				System.out.print("입금할 계좌번호 > ");
				account = sc.nextInt(); // accountList의 인덱스
				if( account >= currentMax ){
					System.out.println("없는 계좌번호 입니다.");
					//continue;
				}else{
					accountList[account] = accountList[account] + money;
				}
				System.out.printf("현재 잔액은 %d원입니다.\n",accountList[account]);
			}else if(menu == 5) {// 잔액조회
				System.out.println("조회할 계좌번호 >");
				int account = sc.nextInt(); 
				System.out.printf("현재 잔액은 %d원입니다.\n",accountList[account]);
			}else if(menu == 6) { // 종료
				run = false;
			}else {
				System.out.println("메뉴를 잘못 선택했습니다.");
			}
		}
		System.out.println("프로그램을 종료 하겠습니다");
	}

}
