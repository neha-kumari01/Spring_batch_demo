package com.spring.scheduler.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.scheduler.entity.USCustomer;

@Repository
public interface USCustomerRepository extends JpaRepository<USCustomer, Integer> {
}
