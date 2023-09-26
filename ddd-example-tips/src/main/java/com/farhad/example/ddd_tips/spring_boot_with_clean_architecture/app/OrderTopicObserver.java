package com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.app;

import com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.core.OrderDetails;
import com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.core.OrderManagementService;
import com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.core.OrderRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderTopicObserver {
    
    private final OrderManagementService orderManagementService;

    // 
    public void onReceive(OrderMessage message) {
        processPurchase(message);
    }

    private OrderDetails processPurchase(OrderMessage message) {
        OrderRequest orderRequest = convert(message);
        return orderManagementService.processPurchase(orderRequest);
    }

    private OrderRequest convert(OrderMessage message) {
        return null;
    }
}
