package com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.core;

import java.time.Instant;
import java.util.UUID;

import com.farhad.example.ddd_tips.spring_boot_with_clean_architecture.app.Foo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class OrderDetails {
   
    private UUID orderId;
    private Instant date;
    private Foo otherThings;

    public static OrderDetails from(Order order) {
        return new OrderDetails(order.getId().getUuid(), order.getDate(), null);
    }
}
