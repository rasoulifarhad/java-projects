package com.farhad.example.ddd_tips.application_service.domain.model.order.access;

import com.farhad.example.ddd_tips.application_service.domain.model.client.Client;
import com.farhad.example.ddd_tips.application_service.domain.model.product.Product;

import io.vavr.control.Either;

public interface ProductAccessPolicy {
    Either<ProductAccessException, Boolean> ckeck(Product product, Client client);
}
