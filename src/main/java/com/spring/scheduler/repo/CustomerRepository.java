package com.spring.scheduler.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.scheduler.entity.Customer;

public interface CustomerRepository  extends JpaRepository<Customer,Integer> {
}
