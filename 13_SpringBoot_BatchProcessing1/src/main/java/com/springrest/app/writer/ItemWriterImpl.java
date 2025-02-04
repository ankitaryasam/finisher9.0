package com.springrest.app.writer;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

public class ItemWriterImpl implements ItemWriter<String>{

	@Override
	public void write(Chunk<? extends String> chunk) throws Exception {
		
		System.out.println("Writing Item to Destination...");
		
	}

}
