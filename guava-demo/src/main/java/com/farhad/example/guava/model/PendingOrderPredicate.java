package com.farhad.example.guava.model;

import java.util.Objects;

import com.google.common.base.Predicate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class PendingOrderPredicate implements Predicate<PurchaseOrder> {@Override

    public boolean apply(PurchaseOrder order) {
        Objects.requireNonNull(order);
        return OrderStatus.PENDING.equals(order.getStatus());
    }
    
}
