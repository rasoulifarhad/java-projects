package com.farhad.example.ddd_tips.order_aggregate_root_jpa.domain.model.customer;

import java.time.Instant;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import lombok.Data;

@Data
public class ShoppingCart {
    
    private Instant lastVisited;

    @OneToMany(fetch = FetchType.EAGER)
    @OrderColumn
    private List<ShoppingCartItem> shoppingCartItems;
}
