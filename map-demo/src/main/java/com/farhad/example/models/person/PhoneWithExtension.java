package com.farhad.example.models.person;

import lombok.Data;

@Data
public class PhoneWithExtension extends Phone {

    private final String extension;

    public PhoneWithExtension(String countryCode, String number, final String extension) {
        super(countryCode, number);
        this.extension = extension;
    }
    
}
