package com.farhad.example.guava.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PurchaseOrder implements CustomerSpecific {
    private final Customer customer;
    private final LocalDate orderData;
    private final OrderStatus status;
    // private List<LineItem> lineItems = new ArrayList<>();
    // private Date deliveryDate;

    public boolean isInStatus(OrderStatus s) {
        return this.status.equals(s);
    }

    public boolean isPending() {
        return isInStatus(OrderStatus.PENDING);
    }

    public boolean isShipped() {
        return isInStatus(OrderStatus.SHIPPED);
    }

    public boolean isDelivered() {
        return isInStatus(OrderStatus.DELIVERED);   
    }
}
