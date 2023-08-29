package com.farhad.example.dp.domainmodel;

import com.farhad.example.dp.domainmodel.dao.ProductDao;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Product {
    
    private static final int DAYS_UNTIL_EXPIRATION_WHEN_DISCOUNT_ACTIVE = 4;
    private static final double DISCOUNT_RATE = 2.0;

    private String name;
    private Double price;
    private LocalDate expirationDate;

    private final ProductDao productDao;

    public void save() {
        try {
            Optional<Product> optional = productDao.findByName(name);
            if(optional.isPresent()) {
                productDao.update(this);
            } else {
                productDao.save(this);
            }
        } catch (SQLException e) {
            log.error("Exception: ", e);
        }
    }

    public double getSalesPrice() {
        return price - calculateDiscount();
    }

    private double calculateDiscount() {
        if (ChronoUnit.DAYS.between(LocalDate.now(), expirationDate) < DAYS_UNTIL_EXPIRATION_WHEN_DISCOUNT_ACTIVE) {
            return  round(price * DISCOUNT_RATE, 2);
        }
        return 0.0;

    }

    private static double round(double value, int place) {
        BigDecimal bigDecimal = new BigDecimal(Double.toString(value));
        bigDecimal = bigDecimal.setScale(place, RoundingMode.DOWN);
        return bigDecimal.doubleValue();
    }

}
