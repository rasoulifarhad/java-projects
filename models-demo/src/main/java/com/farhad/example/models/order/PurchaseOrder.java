package com.farhad.example.models.order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PurchaseOrder {
    private final Customer customer;
    private final LocalDate orderData;
    private final OrderStatus status;
    private List<LineItem> lineItems = new ArrayList<>();
    private LocalDate deliveryDate;
}
