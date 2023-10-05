package com.farhad.example.ddd_tips.application_service.domain.model.order.access;

import static java.util.stream.Collectors.toList;

import java.util.List;

import com.farhad.example.ddd_tips.application_service.domain.model.client.Client;
import com.farhad.example.ddd_tips.application_service.domain.model.order.Order;
import com.farhad.example.ddd_tips.application_service.domain.model.product.Product;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderAccessPolicy {

    private final List<ProductAccessPolicy> productPolicies;

    public Either<ProductAccessExceptions, Boolean> check(Order order, Client client){
        List<Either<ProductAccessExceptions, Boolean>> result = 
            order.getProducts()
                .stream()
                .map(product -> check(product, client))
                .collect(toList());
        List<ProductAccessException> errors =
            result.stream()
                .filter(Either::isLeft)
                .map(Either::getLeft)
                .flatMap(productAccessExceptions -> 
                        productAccessExceptions
                            .getExceptions()
                            .stream())
                .collect(toList());
        return errors.isEmpty() 
                ? Either.right(true) 
                : Either.left(new ProductAccessExceptions(errors));
    }

    private Either<ProductAccessExceptions, Boolean> check(Product product, Client client) {
        List<Either<ProductAccessException, Boolean>> result = 
            productPolicies.stream()
                .map(productAccessPolicy ->  productAccessPolicy.ckeck(product, client))
                .collect(toList());
        List<ProductAccessException> errors = 
            result.stream()
                .filter(Either::isLeft)
                .map(Either::getLeft)
                .collect(toList());
        return errors.isEmpty()
                    ? Either.right(true)
                    : Either.left(
                        new ProductAccessExceptions(errors));
    }
    
}
