package com.farhad.example.dp.domainmodel.dao.impl;

import com.farhad.example.dp.domainmodel.Customer;
import com.farhad.example.dp.domainmodel.Product;
import com.farhad.example.dp.domainmodel.dao.CustomerDao;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerDaoImpl implements CustomerDao {

    Map<String, Customer> customers = new HashMap<>();
    //  private final DataSource dataSource;

    @Override
    public Optional<Customer> findByName(String name) throws SQLException {
        return Optional.ofNullable(customers.get(name));
    }

    @Override
    public void update(Customer customer) {
        customers.put(customer.getName(), customer);
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getName(), customer);
    }

    @Override
    public void addProduct(Product product, Customer customer) throws SQLException {
        if(customers.containsKey(customer.getName())) {
            customers.get(customer.getName()).getPurchases().add(product);
        }
    }

    @Override
    public void deleteProduct(Product product, Customer customer) throws SQLException {
        if(customers.containsKey(customer.getName())) {
            customers.get(customer.getName()).getPurchases().remove(product);
        }
    }
    
}
