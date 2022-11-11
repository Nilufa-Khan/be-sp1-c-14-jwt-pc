package com.example.demoC14.domain;

import javax.persistence.Id;

import javax.persistence.Entity;

@Entity
public class Customer {
    @Id
    private int customerId;
    private String customerName,password,email;

    public Customer(int customerId, String customerName, String password, String email) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.password = password;
        this.email = email;
    }

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
