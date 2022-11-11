package com.example.demoC14.service;

import com.example.demoC14.domain.Customer;
import com.example.demoC14.exception.CustomerNotFoundException;
import com.example.demoC14.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findByCustomerNameAndPassword(String userName, String password) throws CustomerNotFoundException {
        Customer customer = customerRepository.findByCustomerNameAndPassword(userName,password);
        if(customer ==null){
            throw new CustomerNotFoundException();
        }
        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public boolean deleteByCustomerId(int customerId) throws CustomerNotFoundException {
        boolean result = false;
        if(customerRepository.findById(customerId).isEmpty()){
            throw new CustomerNotFoundException();
        }else{
            customerRepository.deleteById(customerId);
            result = true;
        }
        return result;
    }
}
