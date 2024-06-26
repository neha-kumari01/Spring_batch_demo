package com.spring.scheduler.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.scheduler.entity.ChinaCustomer;
import com.spring.scheduler.entity.Customer;
import com.spring.scheduler.entity.USCustomer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
