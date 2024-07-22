package com.app.beans;

// target class
public final class Amazon {
	
	private LogisticsService logisticsService;

	public void setLogisticsService(LogisticsService logisticsService) {
		this.logisticsService = logisticsService;
	}
	
	
	
	public void trackMyOrder(int orderId) {
		logisticsService.trackOrder(orderId);
	}
	

}
