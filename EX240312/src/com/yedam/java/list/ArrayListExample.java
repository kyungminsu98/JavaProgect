package com.yedam.java.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		String[] strList = new String[10];
		List<String> list = new ArrayList<>();

		System.out.println("배열 크기 :"+ strList.length);
		System.out.println("List 크기 :"+ list.size());
		
		// list 의 값을 추가
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP"); //Java, JDBC, Servlet/JSP
		list.add(2,"Database");
		list.add("iBATIS");
		// list의 현재 크기
		System.out.println("List 현재 크기 :"+ list.size());
		
		// 값을가져옴
		String skill = list.get(0);
		System.out.println("2 : "+ skill);
		
		// 전체 출력
		for(int i = 0; i <=list.size()-1;i++) {
			System.out.println(i+":"+list.get(i));
		}
		
		// 특정 인덱스에 위치한 값을 삭제
		list.remove(2);
		list.remove(2);
		
		System.out.println(list);
		
		// 향상된 for문 배열, List, Set
		for(String str : list) {
			System.out.println(str);
		}
	}

}
