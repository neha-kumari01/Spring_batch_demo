package com.spring.scheduler.config.divideCustomers;

import java.util.List;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.scheduler.repo.ChinaCustomerRepository;

@Component
public class ChinaItemWriter implements ItemWriter<CompositeCustomer> {

	@Autowired
	private ChinaCustomerRepository repository;
	public static int count = 0;

	@Override
	public void write(Chunk<? extends CompositeCustomer> chunk) throws Exception {
		List<? extends CompositeCustomer> items = chunk.getItems();
		for (CompositeCustomer customer : items) {
			if (customer.getChinaCustomer() != null) {
				count++;
				repository.save(customer.getChinaCustomer());
			}
		}

	}

}
