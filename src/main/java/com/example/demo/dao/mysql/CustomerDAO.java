package com.example.demo.dao.mysql;

import com.example.demo.dao.ICustomerDAO;
import com.example.demo.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
@SpringBootApplication
public class CustomerDAO implements ICustomerDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM customers";

        List<Customer> customers = jdbcTemplate.query(sql,
            (resultSet, rowNum) -> new Customer(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getString("phone")
            )
        );

        return customers;

    }

    @Override
    public Customer getCustomerById(int customerId) {
        String sql = "SELECT * FROM customers WHERE id = ?";

//        create prepared statement


        // get the customer and if not found return null
        Customer customer = jdbcTemplate.query(
            sql,
            (PreparedStatement ps) -> ps.setInt(1, customerId),
            (resultSet, rowNum) -> new Customer(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getString("phone")
            )
        ).stream().findFirst().orElse(null);

    return customer;
    }

    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(int customerId) {

    }
}
