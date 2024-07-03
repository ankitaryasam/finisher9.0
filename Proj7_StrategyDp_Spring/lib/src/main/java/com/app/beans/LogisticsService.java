package com.app.beans;

public interface LogisticsService {
	
	public String checkDeliveryStatus(int orderId);
	public String orderReturnRequest(int orderId);
	public String orderReplaceRequest(int orderId);

}
