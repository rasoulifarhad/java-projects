package com.farhad.example.jackson.annotation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonWithType {
    private long personId   = 0;

    private String name     = null;

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
