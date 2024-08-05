package com.app.beans;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("myamazon")
public class Amazon {
	
	@Inject
	@Named("courier2")
	private LogisticsService logisticsService;

	@Override
	public String toString() {
		return "Amazon [logisticsService=" + logisticsService + "]";
	}
	
	
	
	

}
