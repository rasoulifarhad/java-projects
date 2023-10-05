package com.farhad.example.ddd_tips.application_service.domain.model.product;

import lombok.Getter;

@Getter
public class Product {

    private String productId;
    private int amount;

    public Product(String productId, int amount) {
        this.productId = productId;
        this.amount = amount;
    }

    public String render() {
        return "id=" + productId + ", amount=" + amount;
    }
    
}
