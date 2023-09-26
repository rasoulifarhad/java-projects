package com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.app;

import java.util.List;
import java.util.stream.Collectors;

import com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.core.Order;
import com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.core.OrderDetails;
import com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.core.OrderManagementService;
import com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.core.OrderQuery;
import com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.core.OrderRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderController {
    
    private final OrderManagementService orderManagementService;

    public List<OrderDetails> search(Params params) {
        return convert(orderManagementService.handle(OrderQuery.from(params)));
    }

    private List<OrderDetails> convert(List<Order> orders) {
        return orders.stream()
            .map(OrderDetails::from)
            .collect(Collectors.toList());
    }

    public OrderDetails purchase(Params params) {
        OrderRequest orderRequest = convert(params);
        OrderDetails orderDetails = orderManagementService.processPurchase(orderRequest);
        return orderDetails;
    }

    private OrderRequest convert(Params params) {
        return null;
    }


}
