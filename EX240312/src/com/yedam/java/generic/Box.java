package com.yedam.java.generic;

public class Box<P,C>{
	private P p;
	private C c;
	
	public P getProduct() {
		return this.p;
	}
	public void setProduct(P p) {
		this.p = p;
	}
	
	public C getCount() {
		return this.c;	
	}
	public void setCount(C c) {
		this.c = c;
	}
}
