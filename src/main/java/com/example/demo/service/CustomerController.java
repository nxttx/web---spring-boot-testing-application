package com.example.demo.service;

import com.example.demo.dao.ICustomerDAO;
import com.example.demo.domain.Customer;
import com.example.demo.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    public ICustomerDAO customerDAO;

    /**
     * Sets the customerDAO to the given customerDAO
     * @param customerDAO
     */
    public void setCustomerDAO(ICustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }


    /**
     * Get all customers
     * @return String JSON with all customers
     */
    @RequestMapping("/")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<Customer> customers = customerDAO.getAllCustomers();
        List<CustomerDTO> customerDTOs = new ArrayList<>();
        for (Customer customer : customers) {
            customerDTOs.add(CustomerDTO.toCustomerDTO(customer));
        }

        return new ResponseEntity<>(customerDTOs, HttpStatus.OK);
    }

    /**
     * Get customer by id
     * @param id
     * @return String JSON with customer | 404 if not found
     */
    @RequestMapping("/{id}/")
    public ResponseEntity<CustomerDTO>  getCustomerById(@PathVariable("id") int id) {
        Customer customer = customerDAO.getCustomerById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(CustomerDTO.toCustomerDTO(customer), HttpStatus.OK);
    }

}
