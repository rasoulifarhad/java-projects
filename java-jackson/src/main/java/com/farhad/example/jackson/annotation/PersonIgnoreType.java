package com.farhad.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The @JsonIgnoreType Jackson annotation is used to mark a whole type (class) to be ignored everywhere that type is used. 
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonIgnoreType {
    
    private long personId   = 0;

    private String name     = null;

    private Address address = null;

    @JsonIgnoreType
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
