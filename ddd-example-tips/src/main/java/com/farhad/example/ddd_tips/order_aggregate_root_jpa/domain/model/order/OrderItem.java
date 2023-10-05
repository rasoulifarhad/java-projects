package com.farhad.example.ddd_tips.order_aggregate_root_jpa.domain.model.order;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.farhad.example.ddd_tips.order_aggregate_root_jpa.domain.model.base.Amount;
import com.farhad.example.ddd_tips.order_aggregate_root_jpa.domain.model.retail.RetailItem;

import lombok.Data;

@Data
public class OrderItem {

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    private RetailItem retailItem;

    private Amount price;

    private int quantity;
}
