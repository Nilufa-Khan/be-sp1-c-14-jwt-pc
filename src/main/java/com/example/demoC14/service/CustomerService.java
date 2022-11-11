package com.example.demoC14.service;

import com.example.demoC14.domain.Customer;
import com.example.demoC14.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    public Customer addCustomer(Customer customer);
    public Customer findByCustomerNameAndPassword(String customerName, String password) throws CustomerNotFoundException;
    List<Customer> getAllCustomer();
   public boolean deleteByCustomerId(int customerId) throws CustomerNotFoundException;
}
