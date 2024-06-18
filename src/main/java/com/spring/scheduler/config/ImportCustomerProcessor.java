package com.spring.scheduler.config;

import org.springframework.batch.item.ItemProcessor;

import com.spring.scheduler.entity.Customer;

public class ImportCustomerProcessor implements ItemProcessor<Customer, Customer> {

	@Override
	public Customer process(Customer customer) throws Exception {
		return customer;
	}
}
