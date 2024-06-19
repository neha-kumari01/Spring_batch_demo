package com.spring.scheduler.config.divideCustomers;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.spring.scheduler.entity.Customer;
import com.spring.scheduler.entity.USCustomer;

@Component
public class USCustomerProcessor implements ItemProcessor<Customer, USCustomer> {

	public static int count=0;
	@Override
	public USCustomer process(Customer customer) throws Exception {
		if (customer.getCountry().equals("United States")) {
			count++;
			USCustomer entity = new USCustomer();
			entity.setFirstName(customer.getFirstName());
			entity.setGender(customer.getGender());
			entity.setContactNo(customer.getContactNo());
			entity.setCountry(customer.getCountry());
			entity.setDob(customer.getDob());
			entity.setEmail(customer.getEmail());
			entity.setLastName(customer.getLastName());

			return entity;
		}
		return null;
	}
}
