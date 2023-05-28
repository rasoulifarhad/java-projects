package com.farhad.example.jackson.objectmapper;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String city;
    private int zipcode;
}
