package com.app.beans;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Amazon {
	
	
//	@Autowired(required = true)
//	@Qualifier("delhivery")
//	private LogisticsService logisticsService;
	
	@Autowired
	@Qualifier("delhivery")
	private LogisticsService logisticsService;
	

	
	
	
	

	

	
	
		

		@Autowired
		@Qualifier("ecomExp")
		public void setLogisticsService(LogisticsService logisticsService) {
			this.logisticsService = logisticsService;
		}
		
		// @Autowired annotation at arbitrary method
				@Autowired
				@Qualifier("bluedart")
				public void deliveryPartner(LogisticsService logisticsService, LogisticsService logisticsService2) {
					System.out.println("gjisgh some another code ");
					this.logisticsService=logisticsService;
				}
	
	

	//Autowired annotation at constructor level
	
		@Autowired
		public Amazon(@Qualifier("shiprocket") LogisticsService logisticsService) {
			this.logisticsService=logisticsService;
		}
	
	
	

	public Amazon() {
		System.out.println("Amazon.Amazon()");
	}
	
	public void trackOrder(int orderId) {
		logisticsService.trackOrderLocation(orderId);
	}

}
