package com.spring.scheduler.config;

import java.util.Iterator;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.scheduler.entity.Customer;
import com.spring.scheduler.repo.CustomerRepository;

public class CustomerItemReader implements ItemReader<Customer> {
	@Autowired
	private CustomerRepository repository;

	private Iterator<Customer> customerIterator;

	@Override
	public Customer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (customerIterator == null) {
			customerIterator = repository.findAll().iterator();
		}
		return customerIterator.hasNext() ? customerIterator.next() : null;
	}
}
