package com.farhad.example.ddd_tips.application_service.domain.model.order.access;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductAccessExceptions extends RuntimeException{
    
    @Getter
    private final List<ProductAccessException> exceptions;
}
