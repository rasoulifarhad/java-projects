package com.farhad.example.models.order;

import lombok.Data;

@Data
public class LineItem {
    private final String product;
    private final double price;
    private final int qty;
}
