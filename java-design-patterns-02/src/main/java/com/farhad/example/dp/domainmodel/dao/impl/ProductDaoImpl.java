package com.farhad.example.dp.domainmodel.dao.impl;

import com.farhad.example.dp.domainmodel.Product;
import com.farhad.example.dp.domainmodel.dao.ProductDao;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {

    Map<String, Product> products = new HashMap<>();
    // private final DataSource dataSource;

    @Override
    public Optional<Product> findByName(String name) throws SQLException {
        return Optional.ofNullable(products.get(name));
    }

    @Override
    public void save(Product product) throws SQLException {
        products.put(product.getName(), product);
    }

    @Override
    public void update(Product product) throws SQLException {
        products.put(product.getName(), product);
    }
    
}
