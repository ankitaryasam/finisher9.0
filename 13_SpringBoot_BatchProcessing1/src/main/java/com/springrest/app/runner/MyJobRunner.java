package com.springrest.app.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class MyJobRunner implements CommandLineRunner{
	
//	1. Job object
	@Autowired
	private Job myBatchJob;
	
//	2. JobLauncher
	@Autowired
	private JobLauncher jobLauncher;
	
	

	@Override
	public void run(String... args) throws Exception {
		
	  JobParameters jobParams = new JobParametersBuilder()
			  							.addLong("time", System.currentTimeMillis())
			  							.toJobParameters();
	  
	  jobLauncher.run(myBatchJob, jobParams);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
