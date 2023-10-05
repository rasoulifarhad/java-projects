package com.farhad.example.ddd_tips.application_service.domain.model.order.access;

import java.util.Arrays;
import java.util.List;

import com.farhad.example.ddd_tips.application_service.domain.model.client.Client;
import com.farhad.example.ddd_tips.application_service.domain.model.product.Product;

import io.vavr.control.Either;

public class PremiumProductPolicy implements ProductAccessPolicy{

    private static final List<String> PREMIUM_PRODUCTS = Arrays.asList("premium_1", "premium_2");    
    @Override
    public Either<ProductAccessException, Boolean> ckeck(Product product, Client client) {
        if(isPremium(product) && !hasPremiumSubscription(client)) {
            return Either.left(
                new ProductAccessException(
                    String.format(
                        "Client %s cannot access premium product %s", 
                        client.getName(),
                        product.getProductId()), 
                        product.getProductId()));
        }
        return Either.right(true);
    }
    private boolean hasPremiumSubscription(Client client) {
        return client.isHasPremiumSubscription();
    }
    private boolean isPremium(Product product) {
        return PREMIUM_PRODUCTS.contains(product.getProductId());
    }
    
}
