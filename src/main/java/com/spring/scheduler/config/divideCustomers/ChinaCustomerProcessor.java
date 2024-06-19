package com.spring.scheduler.config.divideCustomers;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.spring.scheduler.entity.ChinaCustomer;
import com.spring.scheduler.entity.Customer;

@Component
public class ChinaCustomerProcessor implements ItemProcessor<Customer, ChinaCustomer> {

	public static int count=0;
	@Override
	public ChinaCustomer process(Customer customer) throws Exception {
		if (customer.getCountry().equals("China")) {
			count++;
			ChinaCustomer entity = new ChinaCustomer();
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
