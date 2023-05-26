package com.farhad.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonJsonUnwrapped {
    private long personId   = 0;

    private String name     = null;

    @JsonUnwrapped
    private Address address = null;

    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class Address {
        private String streetName  = null;
        private String houseNumber = null;
        private String zipCode     = null;
        private String city        = null;
        private String country     = null;
    }

}
