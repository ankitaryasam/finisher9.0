package com.app.beans;

public class EcomExpress  implements LogisticsService{
	@Override
	public void trackOrderLocation(int orderId) {
		// TODO Auto-generated method stub
		System.out.println("Your order id: " + orderId + "  is reached to nearest hub. It'll be delivered by EcomExpress agent today.");
	}

	

}
