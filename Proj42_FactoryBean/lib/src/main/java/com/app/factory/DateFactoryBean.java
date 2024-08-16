package com.app.factory;

import java.util.Date;

import org.springframework.beans.factory.FactoryBean;

public class DateFactoryBean implements FactoryBean<Date> {

	private int year;
	private int month;
	private int date;
	
	
	
	public DateFactoryBean(int year, int month, int date) {
		this.year = year;
		this.month = month;
		this.date = date;
	}

	@Override
	public Date getObject() throws Exception {
		System.out.println("DateFactoryBean.getObject()");
		
		Date dateObject = new Date(year-1900, month, date);
		return dateObject;
		
	}

	@Override
	public Class<?> getObjectType() {
		return Date.class;
	}

	
	
	
	
	
}
