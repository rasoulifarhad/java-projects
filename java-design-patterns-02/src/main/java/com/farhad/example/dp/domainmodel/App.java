package com.farhad.example.dp.domainmodel;

import com.farhad.example.dp.domainmodel.dao.CustomerDao;
import com.farhad.example.dp.domainmodel.dao.ProductDao;
import com.farhad.example.dp.domainmodel.dao.impl.CustomerDaoImpl;
import com.farhad.example.dp.domainmodel.dao.impl.ProductDaoImpl;
import java.time.LocalDate;
import javax.sql.DataSource;

// https://java-design-patterns.com/patterns/domain-model/#explanation
public class App {
    
    public DataSource createDataSource() {
        return null;
    }

    private void createSchema(DataSource dataSource) {

    }

    private void deleteSchema(DataSource dataSource) {
        
    }

    public static void main(String[] args) {
        App app = new App();
        DataSource dataSource = app.createDataSource();
        app.deleteSchema(dataSource);
        app.createSchema(dataSource); 

        CustomerDao customerDao = new CustomerDaoImpl(dataSource);

        Customer tom = Customer.builder()
                            .name("Tom")
                            .money(Double.valueOf(100.0))
                            .customerDao(customerDao)
                            .build();
        tom.save();

        ProductDao productDao = new ProductDaoImpl(dataSource);
        
        Product egg = Product.builder()
                            .name("Eggs")
                            .price(Double.valueOf(10.0)) 
                            .expirationDate(LocalDate.now().plusDays(7))
                            .productDao(productDao)
                            .build();

         Product butter = Product.builder()
                            .name("Butter")
                            .price(Double.valueOf(20.0))
                            .expirationDate(LocalDate.now().plusDays(7))
                            .productDao(productDao)
                            .build();
        
        Product chease = Product.builder()
                            .name("Chease")
                            .price(Double.valueOf(25.0))
                            .expirationDate(LocalDate.now().plusDays(7))
                            .productDao(productDao)
                            .build();
        
        egg.save();
        butter.save();
        chease.save();

       }
}
