package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.example.demo.dao.ICustomerDAO;
import com.example.demo.dao.mysql.CustomerDAO;
import com.example.demo.domain.Customer;
import com.example.demo.dto.CustomerDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    private static CustomerController controller;

    @BeforeAll
    public static void setUp() {
        controller = new CustomerController();
    }

    @Test
    public void testGetAllCustomers() {
        // ----- Arrange -----
        List<Customer> mockingCustomers = List.of(
                new Customer(1, "John", "Doe", "1234567890"),
                new Customer(2, "Jane", "Doe", "0987654321"));
        List<CustomerDTO> expectedCustomers = List.of(
                new CustomerDTO(1, "John", "Doe", "1234567890"),
                new CustomerDTO(2, "Jane", "Doe", "0987654321"));

        // ----- Mock -----
        ICustomerDAO customerDAO = mock(CustomerDAO.class);
        controller.setCustomerDAO(customerDAO);

        when(customerDAO.getAllCustomers()).thenReturn(mockingCustomers);

        // ----- Act -----
        ResponseEntity<List<CustomerDTO>> response = controller.getAllCustomers();

        // ----- Assert -----
        verify(customerDAO, times(1)).getAllCustomers();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<CustomerDTO> actualCustomers = response.getBody();
        assertEquals(expectedCustomers.get(0).id, actualCustomers.get(0).id);
        assertEquals(expectedCustomers.get(0).name, actualCustomers.get(0).name);
        assertEquals(expectedCustomers.get(0).email, actualCustomers.get(0).email);
        assertEquals(expectedCustomers.get(0).phone, actualCustomers.get(0).phone);
        assertEquals(expectedCustomers.get(1).id, actualCustomers.get(1).id);
        assertEquals(expectedCustomers.get(1).name, actualCustomers.get(1).name);
        assertEquals(expectedCustomers.get(1).email, actualCustomers.get(1).email);
        assertEquals(expectedCustomers.get(1).phone, actualCustomers.get(1).phone);
    }

    @Test
    public void testGetCustomerById() {
        // ----- Arrange -----
        Customer mockingCustomer = new Customer(1, "John", "Doe", "1234567890");
        CustomerDTO expectedCustomer = new CustomerDTO(1, "John", "Doe", "1234567890");

        // ----- Mock -----
        ICustomerDAO customerDAO = mock(CustomerDAO.class);
        controller.setCustomerDAO(customerDAO);

        when(customerDAO.getCustomerById(1)).thenReturn(mockingCustomer);
        when(customerDAO.getCustomerById(2)).thenReturn(null);

        // ----- Act -----
        ResponseEntity<CustomerDTO> response = controller.getCustomerById(1);
        ResponseEntity<CustomerDTO> response2 = controller.getCustomerById(2);

        // ----- Assert -----
        verify(customerDAO, times(1)).getCustomerById(1);
        verify(customerDAO, times(1)).getCustomerById(2);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        CustomerDTO actualCustomer = response.getBody();
        assertEquals(expectedCustomer.id, actualCustomer.id);
        assertEquals(expectedCustomer.name, actualCustomer.name);
        assertEquals(expectedCustomer.email, actualCustomer.email);
        assertEquals(expectedCustomer.phone, actualCustomer.phone);

        assertEquals(HttpStatus.NOT_FOUND, response2.getStatusCode());




    }
}