package com.app.beans;

import org.springframework.context.annotation.Primary;


public class Bluedart implements LogisticsService {

	@Override
	public void trackOrderLocation(int orderId) {
		// TODO Auto-generated method stub
		System.out.println("Your order id: " + orderId + "  is reached to nearest hub. It'll be by Bluedart agent today.");
	}

}
