package com.app.service;

//target class 
public class BankService {
	
	public  float  calSi(float p, float r, float t) {
		System.out.println("BankService.calSi()");
		return  p*t*r / 100.0f;
	}

}
