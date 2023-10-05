package com.farhad.example.ddd_tips.application_service.infrastructure.adapter.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.farhad.example.ddd_tips.application_service.domain.model.order.Order;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderDto {
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) 
    private String id;

    @NotNull 
    List<ProductDto> products;
    
    @NotNull 
    private String clientId;
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) 
    private String status;
    
    public static OrderDto of(Order order) {
        return new OrderDto(order.getId(), ProductDto.of(order.getProducts()), order.getClientId(), order.getStatus().toString());
    }    
}
