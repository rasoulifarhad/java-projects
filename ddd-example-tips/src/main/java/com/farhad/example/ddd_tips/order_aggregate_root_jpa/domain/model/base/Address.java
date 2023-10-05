package com.farhad.example.ddd_tips.order_aggregate_root_jpa.domain.model.base;

import lombok.Data;

@Data
public class Address {


    private String street1;
    private String street2;
    private String city;
    private StateCode state;
    private ZipCode zip;
}
