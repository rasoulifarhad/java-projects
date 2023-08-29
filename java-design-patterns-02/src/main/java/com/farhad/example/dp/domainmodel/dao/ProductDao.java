package com.farhad.example.dp.domainmodel.dao;

import com.farhad.example.dp.domainmodel.Product;
import java.sql.SQLException;
import java.util.Optional;

public interface ProductDao {

    Optional<Product> findByName(String name)throws SQLException;
    void save(Product product) throws SQLException;
    void update(Product product) throws SQLException;
}
