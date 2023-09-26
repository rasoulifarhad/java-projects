package com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.details;

import java.util.List;

import com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.core.Order;
import com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.core.OrderQuery;
import com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.core.OrderRepository;

public class PostgressOrderRepository implements OrderRepository {

    @Override
    public List<Order> find(OrderQuery query) {
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }
    
}
