package com.farhad.example.models.person;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {
    private String street;
    private String city;
    private String country;
    private List<Phone> phoneNumbers;   
}
