package com.farhad.example.ddd_tips.application_service.application.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.farhad.example.ddd_tips.application_service.domain.model.order.OrderRepository;
import com.farhad.example.ddd_tips.application_service.domain.model.order.OrderRepositoryStub;


@Profile("mock-order-repository")
@Configuration
public class RepositoryMockConfiguration {
    

    @Bean
    OrderRepository orderRepository(){
        return new OrderRepositoryStub();
    }
}
