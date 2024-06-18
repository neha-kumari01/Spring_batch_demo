package com.spring.scheduler.config;

import java.util.Arrays;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import com.spring.scheduler.entity.ChinaCustomer;
import com.spring.scheduler.entity.Customer;
import com.spring.scheduler.entity.USCustomer;
import com.spring.scheduler.repo.ChinaCustomerRepository;
import com.spring.scheduler.repo.USCustomerRepository;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class JobConfig {

	@Autowired
	private USCustomerRepository customerRepository;

	@Autowired
	private ChinaCustomerRepository chinaCustomerRepository;

	@Autowired
	private CustomerItemReader customerItemReader;

	@Autowired
	private CustomerItemProcessor customerItemProcessor;
	@Autowired
	private ChinaItemWriter chinaWriter;
	@Autowired
	private USItemWriter usWriter;

	/*
	 * @Bean("divide") public Job runJob(JobRepository jobRepository,
	 * PlatformTransactionManager transactionManager) throws Exception { return new
	 * JobBuilder("segregateCustomers", jobRepository).flow(step1(jobRepository,
	 * transactionManager)).end() .build(); }
	 * 
	 * 
	 * @Bean public Step step1(JobRepository jobRepository,
	 * PlatformTransactionManager transactionManager) throws Exception { return new
	 * StepBuilder("segregate", jobRepository).<Customer, ChinaCustomer>chunk(200,
	 * transactionManager)
	 * .reader(customerItemReader).processor(customerItemProcessor).writer(writer1()
	 * ) .taskExecutor(taskExecutor()).build(); }
	 * 
	 * 
	 * @Bean public CompositeItemWriter<Object> compositeItemWriter() {
	 * CompositeItemWriter<Object> writer = new CompositeItemWriter<>();
	 * writer.setDelegates(Arrays.asList(writer1(), writer2())); return writer; }
	 * 
	 * @Bean public ItemWriter<ChinaCustomer> writer1() { return new
	 * ItemWriter<ChinaCustomer>() {
	 * 
	 * @Override public void write(Chunk<? extends ChinaCustomer> chunk) throws
	 * Exception { chinaCustomerRepository.saveAll(chunk); } }; }
	 * 
	 * @Bean public ItemWriter<USCustomer> writer2() { return new
	 * ItemWriter<USCustomer>() {
	 * 
	 * @Override public void write(Chunk<? extends USCustomer> chunk) throws
	 * Exception { customerRepository.saveAll(chunk); } }; }
	 * 
	 * @Bean public TaskExecutor taskExecutor() { SimpleAsyncTaskExecutor
	 * asyncTaskExecutor = new SimpleAsyncTaskExecutor();
	 * asyncTaskExecutor.setConcurrencyLimit(10); return asyncTaskExecutor; }
	 */

}
