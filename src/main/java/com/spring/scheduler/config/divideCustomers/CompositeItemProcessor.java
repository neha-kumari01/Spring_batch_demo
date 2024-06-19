package com.spring.scheduler.config.divideCustomers;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.scheduler.entity.Customer;

@Component
public class CompositeItemProcessor implements ItemProcessor<Customer, CompositeCustomer> {

	@Autowired
	private ChinaCustomerProcessor chinaProcessor;
	@Autowired
	private USCustomerProcessor usProcessor;

	@Override
	public CompositeCustomer process(Customer item) throws Exception {
		CompositeCustomer compositeCustomer = new CompositeCustomer();
		if (item.getCountry().equals("China"))
			compositeCustomer.setChinaCustomer(chinaProcessor.process(item));
		if (item.getCountry().equals("United States"))
			compositeCustomer.setUsCustomer(usProcessor.process(item));
		return compositeCustomer;
	}

}

