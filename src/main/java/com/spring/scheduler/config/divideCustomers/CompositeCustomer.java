package com.spring.scheduler.config.divideCustomers;

import com.spring.scheduler.entity.ChinaCustomer;
import com.spring.scheduler.entity.USCustomer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompositeCustomer {
	
	private ChinaCustomer chinaCustomer;
	private USCustomer usCustomer;
}