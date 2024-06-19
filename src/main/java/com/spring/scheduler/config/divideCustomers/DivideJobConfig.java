package com.spring.scheduler.config.divideCustomers;

import java.util.Arrays;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import com.spring.scheduler.entity.Customer;

@Configuration
public class DivideJobConfig {

	private CustomerItemReader customerItemReader;

	private CompositeItemProcessor compositeItemProcessor;

	private ChinaItemWriter chinaWriter;

	private USItemWriter usWriter;

	@Autowired
	public DivideJobConfig(CustomerItemReader customerItemReader, CompositeItemProcessor compositeItemProcessor,
			ChinaItemWriter chinaWriter, USItemWriter usWriter) {
		super();
		this.customerItemReader = customerItemReader;
		this.compositeItemProcessor = compositeItemProcessor;
		this.chinaWriter = chinaWriter;
		this.usWriter = usWriter;
	}

	@Bean(name="segregateCustomers")
	public Job divideCustomers(JobRepository jobRepository, PlatformTransactionManager transactionManager) throws Exception {
		return new JobBuilder("segregateCustomers", jobRepository).flow(divideStep(jobRepository, transactionManager)).end()
				.build();
	}

	@Bean
	public Step divideStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) throws Exception {
		return new StepBuilder("segregate", jobRepository).<Customer, CompositeCustomer>chunk(200, transactionManager)
				.reader(customerItemReader).processor(compositeItemProcessor).writer(compositeItemWriter())
				.taskExecutor(dividetaskExecutor()).build();
	}

	@Bean
	public CompositeItemWriter<CompositeCustomer> compositeItemWriter() {
		CompositeItemWriter writer = new CompositeItemWriter();
		writer.setDelegates(Arrays.asList(chinaWriter, usWriter));
		return writer;
	}

	@Bean
	public TaskExecutor dividetaskExecutor() {
		SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
		asyncTaskExecutor.setConcurrencyLimit(10);
		return asyncTaskExecutor;
	}

}
