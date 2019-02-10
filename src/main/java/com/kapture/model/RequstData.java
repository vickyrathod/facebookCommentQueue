package com.kapture.model;

import org.springframework.data.annotation.Id;

public class RequstData {
	
	@Id
	int a;
	int b;
	
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
}
