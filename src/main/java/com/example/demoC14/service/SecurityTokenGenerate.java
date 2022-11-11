package com.example.demoC14.service;

import com.example.demoC14.domain.Customer;

import java.util.Map;

public interface SecurityTokenGenerate {
   Map<String,String> generateToken(Customer customer);
}
