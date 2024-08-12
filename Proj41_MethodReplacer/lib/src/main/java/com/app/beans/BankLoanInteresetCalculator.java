package com.app.beans;

public class BankLoanInteresetCalculator {
	
	public float calLoanInterest(float p, float r, float t) {
		System.out.println("loan interest:: si");
		return (p*t*r) / 100;
	}

}
