package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.demo.dao.mysql.CustomerDAO;
import com.example.demo.domain.Customer;
import com.example.demo.dto.CustomerDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @Mock
    private static CustomerDAO customerDAO;
    private static CustomerController controller;


    @BeforeAll
    public static void setUp() {
        // Todo: Mocking doesnt quite work yet. It just gives an empty list.
        customerDAO = mock(CustomerDAO.class);
        controller = new CustomerController(customerDAO);
    }

    @Test
    public void testGetAllCustomers() {
        // ----- Arrange -----
        List<Customer> mockingCustomers = List.of(
                new Customer(1, "John", "Doe", "1234567890"),
                new Customer(2, "Jane", "Doe", "0987654321"),
                new Customer(3, "John", "Smith", "1234567890"));

        List<CustomerDTO> expectedCustomers = List.of(
                new CustomerDTO(1, "John", "Doe", "1234567890"),
                new CustomerDTO(2, "Jane", "Doe", "0987654321"),
                new CustomerDTO(3, "John", "Smith", "1234567890"));


        // ----- Mock -----
        // Configure the mock to return the expected customers
        // when the getAllCustomers() method is called
        when(customerDAO.getAllCustomers()).thenReturn(mockingCustomers);

        // ----- Act -----
        ResponseEntity<List<CustomerDTO>> response = controller.getAllCustomers();

        // ----- Assert -----
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<CustomerDTO> actualCustomers = response.getBody();
        assertEquals(expectedCustomers, actualCustomers);
    }

    @Test
    public void testGetCustomerById() {
        // ----- Arrange -----
        Customer mockingCustomer = new Customer(1, "John", "Doe", "1234567890");
        CustomerDTO expectedCustomer = new CustomerDTO(1, "John", "Doe", "1234567890");

        // ----- Mock -----
        // Configure the mock to return the expected customer
        // when the getCustomerById() method is called
        when(customerDAO.getCustomerById(1)).thenReturn(mockingCustomer);
        when(customerDAO.getCustomerById(2)).thenReturn(null);

        // ----- Act -----
        ResponseEntity<CustomerDTO> response = controller.getCustomerById(1);
        ResponseEntity<CustomerDTO> response2 = controller.getCustomerById(2);

        // ----- Assert -----
        assertEquals(HttpStatus.OK, response.getStatusCode());
        CustomerDTO actualCustomer = response.getBody();
        assertEquals(expectedCustomer, actualCustomer);

        assertEquals(HttpStatus.NOT_FOUND, response2.getStatusCode());




    }
}