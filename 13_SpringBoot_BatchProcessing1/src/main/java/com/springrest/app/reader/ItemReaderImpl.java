package com.springrest.app.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class ItemReaderImpl implements ItemReader<String>{

	@Override
	public String read() throws Exception, 
								UnexpectedInputException, 
								ParseException, 
								NonTransientResourceException {
	
		System.out.println("ItemReader....reading");
		return "Reading Item";
	}

}
