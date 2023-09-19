package com.farhad.example.ddd_tips.factories;

import com.farhad.example.ddd_tips.factories.Customer.CustomerId;

public class ShipmentRecipient {

    private String fullName;
    private StreetAddress streetAddress;

    public ShipmentRecipient(String fullName, StreetAddress streetAddress) {
        this.fullName = fullName;
        this.streetAddress = streetAddress;
    }

    public void associateWithCustomer(CustomerId id) {
    }

}
