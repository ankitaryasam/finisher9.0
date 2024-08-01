package com.app.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Amazon {
	
	
//	@Autowired(required = true)
//	@Qualifier("delhivery")
//	private LogisticsService logisticsService;
	
	@Autowired
	private LogisticsService logisticsService;
	
	public Amazon() {
		System.out.println("Amazon.Amazon()");
	}
	
	public void trackOrder(int orderId) {
		logisticsService.trackOrderLocation(orderId);
	}

}
