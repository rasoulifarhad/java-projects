package com.farhad.example.guava.model;

import java.time.LocalDate;
import java.util.Objects;

import com.google.common.base.Predicate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class RecentOrderPredicate implements Predicate<PurchaseOrder> {

    private final LocalDate from;
    @Override
    public boolean apply(PurchaseOrder order) {
        Objects.requireNonNull(order);
        return order.getOrderData().isAfter(from);
    }
    
}
