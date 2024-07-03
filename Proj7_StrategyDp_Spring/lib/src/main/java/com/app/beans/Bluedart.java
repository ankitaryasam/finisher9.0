package com.app.beans;

//dependent spring bean
public final  class Bluedart implements LogisticsService {

	@Override
	public final String checkDeliveryStatus(int orderId) {
	    String status = "Your order id : " + orderId
	    		         + " is reached to the nearest hub."
	    		         + "It'll be delivered today by bluedart delivery agent.";
		return status;
	}

	@Override
	public String orderReturnRequest(int orderId) {
		String returnRequestStatus = "Your order id : " + orderId 
				 + " A return request is accepted. Bluedart agent will pick up your item soon";
		return returnRequestStatus;
	}

	@Override
	public String orderReplaceRequest(int orderId) {
		String replaceStatus = "Your order id : " + orderId 
				 + " A replace request is accepted. Bluedart agent will pick up your item soon."
				 + " Please keep your item with the invoice ready";
		return replaceStatus;
	}
	
	
}
