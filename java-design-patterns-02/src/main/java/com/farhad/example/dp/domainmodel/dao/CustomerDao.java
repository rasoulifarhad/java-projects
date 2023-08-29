package com.farhad.example.dp.domainmodel.dao;

import com.farhad.example.dp.domainmodel.Customer;
import com.farhad.example.dp.domainmodel.Product;
import java.sql.SQLException;
import java.util.Optional;

public interface CustomerDao {

    Optional<Customer> findByName(String name) throws SQLException;

    void update(Customer customer);

    void save(Customer customer);

    void addProduct(Product product, Customer customer) throws SQLException;

    void deleteProduct(Product product, Customer customer) throws SQLException;
}
