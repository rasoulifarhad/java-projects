package com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.core;

import java.util.List;

public interface OrderRepository {

    List<Order> find(OrderQuery query);
    
}
