package com.farhad.example.ddd_tips.application_service.domain.model.order;

import com.farhad.example.ddd_tips.application_service.domain.model.client.Client;

import io.vavr.control.Either;

public interface OrderAccessPolicy {

    Either<?, Boolean> check(Order intermediateOrder, Client client);
    
}
