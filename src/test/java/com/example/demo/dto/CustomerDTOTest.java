package com.example.demo.dto;

import com.example.demo.domain.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerDTOTest {

    @Test
    public void testToCustomerDTO() {
        // ----- Arrange -----
        Customer customer = new Customer(1, "John Doe", "j.doe@example.com", "1234567890");

        // ----- Act -----
        CustomerDTO customerDTO = CustomerDTO.toCustomerDTO(customer);

        // ----- Assert -----
        assertEquals(customer.getId(), customerDTO.id);
        assertEquals(customer.getName(), customerDTO.name);
        assertEquals(customer.getEmail(), customerDTO.email);
        assertEquals(customer.getPhone(), customerDTO.phone);
    }
}
