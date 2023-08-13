package com.farhad.example.designpatterns.anotherspecification.newera;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Product {
    
    double price;
    int units;

    public Product(double price, int units) {
        this.price = price;
        this.units = units;
    }

    public boolean satisfies(SearchCriteria criteria) {
        return criteria.isSatisfiedBy(this); 
    }
}
