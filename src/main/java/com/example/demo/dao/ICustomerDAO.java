/**
 * Interface for data access object for Customer objects.
 */
package com.example.demo.dao;

import com.example.demo.domain.Customer;

import java.util.List;

public interface ICustomerDAO {

    /**
     * Retrieves all customers from the database.
     * @return a list of Customer objects
     */
    List<Customer> getAllCustomers();

    /**
     * Retrieves a Customer object with the given customer ID.
     * @param customerId the ID of the customer to retrieve
     * @return the Customer object with the given ID, or null if no such customer exists
     */
    Customer getCustomerById(int customerId);

    /**
     * Adds a new customer to the database.
     * @param customer the Customer object to add
     */
    void addCustomer(Customer customer);

    /**
     * Updates an existing customer in the database.
     * @param customer the Customer object to update
     */
    void updateCustomer(Customer customer);

    /**
     * Deletes a customer from the database.
     * @param customerId the ID of the customer to delete
     */
    void deleteCustomer(int customerId);
}
