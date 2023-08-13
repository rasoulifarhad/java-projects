package com.farhad.example.designpatterns.anotherspecification;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Product {
    
    double price;
    int units;
    public Product(double price, int units) {
        this.price = price;
        this.units = units;
    }
}
