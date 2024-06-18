package com.spring.scheduler.config;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.scheduler.entity.ChinaCustomer;
import com.spring.scheduler.entity.USCustomer;
import com.spring.scheduler.repo.ChinaCustomerRepository;
import com.spring.scheduler.repo.USCustomerRepository;

public class USItemWriter  implements ItemWriter<USCustomer> {

	@Autowired
    private USCustomerRepository repository;
	@Override
	public void write(Chunk<? extends USCustomer> chunk) throws Exception {
		repository.saveAll(chunk);
		
	}

}
