package com.farhad.example.ddd_tips.order_aggregate_root_jpa.domain.model.customer;

import java.time.Instant;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.farhad.example.ddd_tips.order_aggregate_root_jpa.domain.model.base.Amount;
import com.farhad.example.ddd_tips.order_aggregate_root_jpa.domain.model.retail.RetailItem;

import lombok.Data;

@Data
public class ShoppingCartItem {

    private int quantity;
    private Instant dateAdded;
    private Amount lastPriceShown;

    @ManyToOne(fetch = FetchType.LAZY)
    private RetailItem retailItem;
}
