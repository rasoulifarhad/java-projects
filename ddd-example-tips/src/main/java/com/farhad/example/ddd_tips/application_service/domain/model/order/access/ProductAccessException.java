package com.farhad.example.ddd_tips.application_service.domain.model.order.access;

public class ProductAccessException extends RuntimeException {
    
    private final String productId;

    public ProductAccessException(String message, String productId) {
        super(message);
        this.productId = productId;
    }
}
