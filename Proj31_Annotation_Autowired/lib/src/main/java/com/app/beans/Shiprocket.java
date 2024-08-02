package com.app.beans;

public class Shiprocket implements LogisticsService {

	@Override
	public void trackOrderLocation(int orderId) {
		System.out.println("Your order id: " + orderId + "  is reached to nearest hub. It'll be delivered by Shiprocket agent today.");
	}

}
