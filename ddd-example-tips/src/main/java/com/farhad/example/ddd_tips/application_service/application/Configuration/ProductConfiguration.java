package com.farhad.example.ddd_tips.application_service.application.Configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.ddd_tips.application_service.domain.model.order.access.OrderAccessPolicy;
import com.farhad.example.ddd_tips.application_service.domain.model.order.access.PremiumProductPolicy;
import com.farhad.example.ddd_tips.application_service.domain.model.order.access.ProductAccessPolicy;

@Configuration
public class ProductConfiguration {
    

    @Bean 
    public OrderAccessPolicy orderAccessPolicy(List<ProductAccessPolicy> productAccessPolicies) {
        return new OrderAccessPolicy(productAccessPolicies);
    }

    @Bean
    PremiumProductPolicy getPolicy() {
        return new PremiumProductPolicy();
    }
}
