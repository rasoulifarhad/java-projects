package com.farhad.example.ddd_tips.application_service.infrastructure.adapter.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.ddd_tips.application_service.application.service.OrderService;
import com.farhad.example.ddd_tips.application_service.domain.model.order.Order;
import com.farhad.example.ddd_tips.application_service.infrastructure.adapter.dto.OrderDto;
import com.farhad.example.ddd_tips.application_service.infrastructure.adapter.dto.ProductDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    
    private final OrderService orderService;  
    
   @PostMapping
   public OrderDto order(@RequestBody @Valid OrderDto orderDto) {
      log.info("Creating order {}", orderDto);
      Order order = orderService.placeOrder(ProductDto.convert(orderDto.getProducts()), orderDto.getClientId());
      return OrderDto.of(order);
   }    
}
