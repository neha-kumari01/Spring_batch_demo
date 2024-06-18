package com.spring.scheduler.config;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.scheduler.entity.ChinaCustomer;
import com.spring.scheduler.repo.ChinaCustomerRepository;

public class ChinaItemWriter  implements ItemWriter<ChinaCustomer> {

	@Autowired
    private ChinaCustomerRepository repository;
	@Override
	public void write(Chunk<? extends ChinaCustomer> chunk) throws Exception {
		repository.saveAll(chunk);
		
	}

}
