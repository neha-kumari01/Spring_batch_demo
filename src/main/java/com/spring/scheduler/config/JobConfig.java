package com.spring.scheduler.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.spring.scheduler.entity.Customer;
import com.spring.scheduler.repo.CustomerRepository;

@Configuration
public class JobConfig {

	private CustomerRepository customerRepository;
	private JobBuilderFactory jobBuilderFactory;

    private StepBuilderFactory stepBuilderFactory;

	

	@Bean
	public FlatFileItemReader<Customer> readCSV() {
		return new FlatFileItemReaderBuilder<Customer>().name("Customer Item Reader")
				.resource(new ClassPathResource("customers.csv")).delimited()
				.names("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob")
				.targetType(Customer.class).linesToSkip(1).build();
	}

	@Bean
	public CustomerProcessor processor() {
		return new CustomerProcessor();
	}

	@Bean
	public RepositoryItemWriter<Customer> writer() {
		RepositoryItemWriter<Customer> writer = new RepositoryItemWriter<>();
		writer.setRepository(customerRepository);
		writer.setMethodName("save");
		return writer;
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("csv-step").<Customer, Customer>chunk(10).reader(readCSV()).processor(processor())
				.writer(writer()).taskExecutor(taskExecutor()).build();
	}

	@Bean
	public Job runJob() {
		return jobBuilderFactory.get("importCustomers").flow(step1()).end().build();

	}

	@Bean
	public TaskExecutor taskExecutor() {
		SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
		asyncTaskExecutor.setConcurrencyLimit(10);
		return asyncTaskExecutor;
	}

}
