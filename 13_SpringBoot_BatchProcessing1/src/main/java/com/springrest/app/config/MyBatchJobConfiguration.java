package com.springrest.app.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;import org.springframework.batch.repeat.CompletionPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springrest.app.listener.JobExecutionListenerImpl;
import com.springrest.app.processor.ItemProcessorImpl;
import com.springrest.app.reader.ItemReaderImpl;
import com.springrest.app.writer.ItemWriterImpl;

@Configuration
@EnableBatchProcessing
public class MyBatchJobConfiguration {
	
//	5. StepBuilderFactory
	@Autowired
	private StepBuilder stepBuilderFactory;
	
//	7. JobBuilderFactory
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	//1. reader object
	@Bean
	public ItemReader itemReader(){
		return new ItemReaderImpl();
	}
	
	//2. ItemProcessor object
		@Bean
		public ItemProcessor itemProcessor(){
			return new ItemProcessorImpl();
		}
		
//		3. ItemWriter object
		@Bean
		public ItemWriter itemWriter() {
			return new ItemWriterImpl();
		}
		
//		4. JobExecutionListener object if you have 
		@Bean
		public JobExecutionListener jobExeListener() {
			return new JobExecutionListenerImpl();
			
		}

//		6. Step object
		
		@Bean
		public Step step1() {
			return stepBuilderFactory
						.chunk(5)
						.reader(itemReader())
						.processor(itemProcessor())
						.writer(itemWriter())
						.build();
					
		}
		
		
//		8. Job object
		
		@Bean
		public Job myBatchJob() {
			return jobBuilderFactory
					.get("myBatchJob")
					.incrementer(new RunIdIncrementer())
					.flow(step1())
					.end()
					.build();
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
}
