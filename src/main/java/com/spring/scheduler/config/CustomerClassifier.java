package com.spring.scheduler.config;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.classify.Classifier;

import com.spring.scheduler.entity.ChinaCustomer;
import com.spring.scheduler.entity.USCustomer;

public class CustomerClassifier implements Classifier<Object, ItemWriter<? super Object>> {

	private transient RepositoryItemWriter<ChinaCustomer> chinaItemWriter;
	private transient RepositoryItemWriter<USCustomer> writer;

	public CustomerClassifier(RepositoryItemWriter<ChinaCustomer> chinaItemWriter,
			RepositoryItemWriter<USCustomer> writer) {
		this.chinaItemWriter = chinaItemWriter;
		this.writer = writer;
	}

	@Override
	public ItemWriter<? super Object> classify(Object item) {
		/*
		 * if (item instanceof ChinaCustomer) { return (ItemWriter<? super
		 * Object>)chinaItemWriter; } else if (item instanceof USCustomer) { return
		 * (ItemWriter<? super Object>) writer; } else { throw new
		 * IllegalArgumentException("Unknown item type: " + item.getClass()); }
		 */

		return null;
}
}