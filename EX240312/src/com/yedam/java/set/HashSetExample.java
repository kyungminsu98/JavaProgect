package com.yedam.java.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		
		// 값을 추가
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP"); 
		set.add("Java"); // 중복
		set.add("iBATIS");
		System.out.println("Set의 현재 크기 : "+ set.size());
		
		// 순환하는 경우 iterator
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.printf("\t %s\n", iterator.next());
		}
		
		// 객체 삭제
		set.remove("Java");
		set.remove("Servlet/JSP");
		
		// 순환하는 경우 향상된 for문
		for(String str : set) {
			System.out.println(str);
		}
	}

}
