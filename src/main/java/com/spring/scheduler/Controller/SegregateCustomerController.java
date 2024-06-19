package com.spring.scheduler.Controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.scheduler.config.divideCustomers.ChinaCustomerProcessor;
import com.spring.scheduler.config.divideCustomers.ChinaItemWriter;
import com.spring.scheduler.config.divideCustomers.USCustomerProcessor;
import com.spring.scheduler.config.divideCustomers.USItemWriter;

@RestController
public class SegregateCustomerController {

	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	@Qualifier("segregateCustomers")
	private Job divideCustomers;

	@GetMapping("/segregateCustomers")
	public String populateDB() {
		JobParameters jobParameters = new JobParametersBuilder().addLong("startAt", System.currentTimeMillis())
				.toJobParameters();
		try {
			jobLauncher.run(divideCustomers, jobParameters);
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			e.printStackTrace();
		}
		return "Segregate Job Completed, China records processed:" + ChinaCustomerProcessor.count +", US records processed: "+USCustomerProcessor.count
+"/n China records write count: "+ ChinaItemWriter.count +", US records write count: "+USItemWriter.count;
	}
}