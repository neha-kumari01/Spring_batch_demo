package com.spring.scheduler.config;

import org.springframework.batch.item.ItemProcessor;

import com.spring.scheduler.entity.ChinaCustomer;
import com.spring.scheduler.entity.Customer;
import com.spring.scheduler.entity.USCustomer;

public class CustomerItemProcessor implements ItemProcessor<Customer, Object> {

	@Override
	public Object process(Customer item) throws Exception {
		if (item.getCountry().equals("China")) {
			USCustomer target1 = new USCustomer();
			return target1;
		} else {
			ChinaCustomer target2 = new ChinaCustomer();
			return target2;
		}
	}
}
