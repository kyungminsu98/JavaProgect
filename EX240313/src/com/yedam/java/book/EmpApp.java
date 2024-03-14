package com.yedam.java.book;

import java.util.Scanner;

public class EmpApp {

	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);

		EmpDAO dao = new EmpDAO();
		
		while (run) {
			System.out.println("===============================================================");
			System.out.println(" 1.등록 | 2.목록 | 3.수정(급여) | 4.삭제 | 5.조회(조건:입사일자) | 6.종료");
			System.out.println("===============================================================");

			System.out.print("메뉴 > ");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) { // 등록
				System.out.println("==== 등록할 사원정보를 입력하세요 ====");
				System.out.print("사원번호 > ");
				int id = Integer.parseInt(sc.nextLine());
				System.out.print("이름 > ");
				String name = sc.nextLine();
				System.out.print("연락처 > ");
				String phone = sc.nextLine();
				System.out.print("입사일 > ");
				String hireDate = sc.nextLine();
				System.out.print("급여 > ");
				int salary = Integer.parseInt(sc.nextLine());
				
				dao.addEmplnfo(id, name,  phone, hireDate, salary);
				
			}else if (menu == 2) { // 목록
				System.out.println("==== 사원 전체 목록 ====");
				
				dao.printEmpAll();
			}else if (menu == 3) { // 수정
				System.out.println("==== 수정할 사원정보를 입력하세요 ====");
				System.out.print("사원번호 > ");
				int id = Integer.parseInt(sc.nextLine());
				System.out.print("급여 > ");
				int salary = Integer.parseInt(sc.nextLine());
				
				dao.updateEmpSalary(id, salary);
			}else if (menu == 4) { // 삭제
				System.out.println("==== 삭제할 사원번호를 입력하세요 ====");
				System.out.print("사원번호 > ");
				int id = Integer.parseInt(sc.nextLine());

				dao.delEmplnfo(id);
			}else if (menu == 5) {
				System.out.println("==== 조회할 입사일자를 입력하세요 ====");
				System.out.print("입사일 > ");
				String hireDate = sc.nextLine();
				
				System.out.println("사원번호\t이름\t입사일자");
				dao.searchHireDate(hireDate);
			}else if (menu == 6) {
				run = false;
			}else {
				System.out.println("메뉴를 잘못 입력했습니다.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
		sc.close();
	}
}

