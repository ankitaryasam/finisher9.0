package com.app.beans;

public class EcomExpress implements LogisticsService {

	@Override
	public void trackOrder(int orderId) {
		System.out.println("Your orderId : " + orderId + " is reached to the nearest hub. It will be delivered today by EcomExpress");
		
	}

}
