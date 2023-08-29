package com.farhad.example.dp.domainmodel;

import com.farhad.example.dp.domainmodel.dao.CustomerDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
@Builder
@AllArgsConstructor
public class Customer {
    
    private String name;
    private Double money;
    @Builder.Default
    private List<Product> purchases = new ArrayList<>(); 
    private final CustomerDao customerDao;

    public void save() {

        try {
            Optional<Customer> optional = customerDao.findByName(name);
            if(optional.isPresent()) {
                customerDao.update(this);
            } else {
                customerDao.save(this);
            }

        } catch (Exception e) {
            log.error("Exception: ", e);
        }

    }

    // Add product to purchase, save to db and withdraw money
    public void buyProduct(Product product) {
        log.info(
            String.format("%s want to buy product %s(%.2f)",name, product.getName(), product.getSalesPrice()));
        
        try {
            withdraw(product.getSalesPrice());
        } catch (IllegalArgumentException e) {
            log.info("Exception: ", e);
        }

        try {
            customerDao.addProduct(product, this);
            purchases.add(product);
            log.info("{} bought {}", name, product.getName());
        } catch (SQLException e) {
            receiveMoney(product.getSalesPrice());
            log.info("{} returned {}", name, product.getName());
        }
    }

    private void withdraw(double amount) throws IllegalArgumentException {
        if (money.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Not enough money");
        }
        money -= amount;
    }

    private void receiveMoney(double amount) {
        money += amount;
    }

    public void returnProduct(Product product) {
        log.info(
            String.format("%s want to return product %s(%.2f)",name, product.getName(), product.getSalesPrice()));
        
        if(purchases.contains(product)) {
            try {
                customerDao.deleteProduct(product, this);
                purchases.remove(product);
                receiveMoney(product.getSalesPrice());
                log.info("{} returned {}", name, product.getName());
            } catch (Exception e) {
                log.error("Exception: ", e);
            }
        } else {
            log.info(String.format("%s did not buy product %s",name, product.getName()));            
        }

    }

    // Print customer's money balance.
    public void showBalance() {
        log.info("{} balance: {}", name, money);
    }

    // Print customer's purchases.
    public void showPurchase() {
        Optional<String> purchasesToShow = 
            purchases.stream()
                .map(p -> p.getName() + "$ " + p.getSalesPrice() )
                .reduce((p1, p2) -> p1 + ", " + p2);
        if (purchasesToShow.isPresent()) {
            log.info("{} bought: {}", name, purchasesToShow);
        } else {
            log.info("{} did not bought anything.");
        }

    }
}
