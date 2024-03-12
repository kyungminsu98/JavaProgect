package com.yedam.java.exam;

import java.util.Scanner;

public class ProductInfoManagement {

	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		
		// 메뉴, 공통 데이터
		Product[] list = null; // 전체 상품 목록
		
		while(run) {
			// 메뉴 출력
			System.out.println("=====================================================");
			System.out.println(" 1.상품수 | 2.상품정보입력 | 3.전체정보출력 | 4.분석 | 5.종료");
			System.out.println("=====================================================");
			
			// 메뉴 선택
			System.out.print("메뉴 선택 > ");
			int menu = Integer.parseInt(sc.nextLine());
			
			// 메뉴별 기능 구현
			if(menu == 1) { //1.상품수
			//- 해당 프로그램에서 입력받을 수 있는 상품이 
			//  최대 몇개인지를 입력받으세요. 
			//=> 배열(값의 데이터타입, 최대크기)
			// Product[], int maxSize
				System.out.print("최대 상품 수 >");

				int maxSize = Integer.parseInt(sc.nextLine());
				list = new Product[maxSize];
			
			}else if(menu == 2) { //2.상품정보입력
			//- 입력한 상품수만큼 상품명과 해당 가격을 입력받으세요.
			// 반복문, 전체 상품에 대해 반복
				for(int i=0; i<= list.length-1; i++) {
					System.out.println("상품 정보를 입력하세요.");
					
					System.out.print("이름 > ");
					String name = sc.nextLine();
					System.out.print("가격 > ");
					int price = Integer.parseInt(sc.nextLine());
					
					Product prd = new Product(name, price);					
					list[i] = prd;
					
					//list[i] = new Product(name, price);
				}				
			}else if(menu == 3) { //3.전체정보출력
				/*
				 - 입력한 제품 정보를 모두 출력하세요.
				 - 출력 예시
				 상품A : 8524원
				 상품B : 6547원
				 상품C : 6578원
				 */
				for(Product p : list) {
					// 상품 한개 정보 출력 
					//System.out.printf("%s : %d원\n", p.name, p.price);
					System.out.printf("%s : %d원\n", p.getName(), p.getPrice());
				}
			}else if(menu == 4) { //4.분석 - 최대값, 평균값(최대값 제외 나머지)
				//1) 최대값 => 상품이름과 상품가격 => 상품정보(이름, 가격)
				// 클래스 Product 사용
				Product maxPrd = list[0]; // 임시로 최대값
				
				for(int i=0; i<=list.length-1; i++) {
					Product p = list[i]; // 비교 상품
					// 임시로 최대값을 가지고 있는 상품의 가격과
					// 비교 상품이 가지고 있는 가격
					if(p.getPrice() > maxPrd.getPrice()) {
						maxPrd = p;
					}
				}
				System.out.printf("최고 가격을 가지는 제품 > %s, %d원\n", 
													maxPrd.getName(), maxPrd.getPrice());
				
				//2) 최대값 제외 나머지 기준 평균값
				int maxPrice = maxPrd.getPrice();//최대값
				double sum = 0;
				int count = 0; //제외한 상품의 갯수
				int num = 0; // 실제 SUM에 더한 갯수
				for(Product p : list) {
					if(p.getPrice() == maxPrice) {
						count++;						
					}else {					
						sum = sum + p.getPrice();
						num++;
					}
				}
				
				double avg = sum / (list.length - count);
				double avgNum = sum / num;
				System.out.print("해당 제품을 제외한 제품들의 ");
				System.out.printf("가격을 다 더한 평균값은 %.1f원입니다.\n", avg);				
			}else if(menu == 5) {
				run = false;
			}else {
				System.out.println("메뉴를 잘못 입력했습니다.");
			}
		}
		System.out.println("프로그램을 종료하겠습니다.");
		sc.close();
		

	}

}
