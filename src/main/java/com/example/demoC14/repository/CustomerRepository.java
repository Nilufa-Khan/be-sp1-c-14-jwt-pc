package com.example.demoC14.repository;

import com.example.demoC14.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
public Customer findByCustomerNameAndPassword(String customerName, String password);

}
