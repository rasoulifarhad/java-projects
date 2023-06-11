package com.farhad.example.models.person;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Phone {
    private final String countryCode;
    private final String number;  
}
