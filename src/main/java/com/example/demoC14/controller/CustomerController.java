package com.example.demoC14.controller;

import com.example.demoC14.domain.Customer;
import com.example.demoC14.exception.CustomerNotFoundException;
import com.example.demoC14.service.SecurityTokenGenerate;
import com.example.demoC14.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

public class CustomerController {
    private CustomerService customerService;
    private SecurityTokenGenerate securityTokenGenerator;

    @Autowired
    public CustomerController(CustomerService customerService, SecurityTokenGenerate securityTokenGenerator)
    {
        this.customerService = customerService;
        this.securityTokenGenerator= securityTokenGenerator;

    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Customer customer) throws CustomerNotFoundException {
        Map<String, String> map= null;

        try
        {
            Customer customer1 = customerService.findByCustomerNameAndPassword(customer.getCustomerName(), customer.getPassword());
            if(customer1.getCustomerName().equals(customer.getCustomerName()))
            {
                map= securityTokenGenerator.generateToken(customer);

            }

            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            throw new CustomerNotFoundException();
        }
        catch (Exception se)
        {
            se.printStackTrace();
            return new ResponseEntity<>("Other exception", HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody Customer customer)
    {
        Customer createCustomer = customerService.addCustomer(customer);
        return new ResponseEntity(createCustomer, HttpStatus.CREATED);
    }
    @GetMapping("/customerdata/v1/fetch")
    public ResponseEntity<?> getAllUsers()
    {
        List<Customer> customerList = customerService.getAllCustomer();
        return  new ResponseEntity<>(customerList,HttpStatus.OK);
    }
    @DeleteMapping("/customerdata/v1/del/{customerId}")
    public ResponseEntity<?> deleteData(@PathVariable int customerId) throws CustomerNotFoundException{
        return new ResponseEntity<>(customerService.deleteByCustomerId(customerId), HttpStatus.OK);
    }



}
