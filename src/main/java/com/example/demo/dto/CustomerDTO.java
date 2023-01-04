package com.example.demo.dto;

import com.example.demo.domain.Customer;

public class CustomerDTO {
    public int id;
    public String name;
    public String email;
    public String phone;

    public CustomerDTO(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

     public static CustomerDTO toCustomerDTO(Customer customer) {
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getEmail(), customer.getPhone());
    }

}
