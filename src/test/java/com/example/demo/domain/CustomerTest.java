package com.example.demo.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    /**
     * This unit test will verify that the Customer constructor correctly sets the object's
     * fields and that the getter methods return the correct values.
     */
    @Test
    public void testCustomer() {
        // ----- Arrange -----
        int id = 1;
        String name = "John Doe";
        String email = "j.doe@example.com";
        String phone = "1234567890";

        // ----- Act -----
        Customer customer = new Customer(id, name, email, phone);

        // ----- Assert -----
        assertEquals(id, customer.getId());
        assertEquals(name, customer.getName());
        assertEquals(email, customer.getEmail());
        assertEquals(phone, customer.getPhone());
    }
}