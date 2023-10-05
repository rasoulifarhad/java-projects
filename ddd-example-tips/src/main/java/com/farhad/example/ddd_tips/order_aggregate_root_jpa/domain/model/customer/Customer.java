package com.farhad.example.ddd_tips.order_aggregate_root_jpa.domain.model.customer;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.farhad.example.ddd_tips.order_aggregate_root_jpa.domain.model.base.Address;

import lombok.Data;

@Data
public class Customer {
    
    private URI customerUri;
    private String firstName;
    private String lastName;

    @OneToMany(fetch = FetchType.EAGER)
    Set<Address> addresses = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER)
    private ShoppingCart shoppingCart;
}
