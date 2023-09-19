package com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Patron {

    @Getter
    private String id;
    private final String firstName;
    private final String middleInitial;
    private final String lastName;
    private final String street;
    private final String street2;
    private final String city;
    private final String state;
    private final String zip;
    
    public Patron(String id) {
        this(id, "", "", "", "", "", "", "", "");
    }

    public boolean hasId(String expectedId) {
        return id == expectedId; 
    }
    
    public String getFullName() {
        StringBuffer builder = new StringBuffer(firstName);
        if (middleInitial != null) {
            builder
                .append(" ")
                .append(middleInitial)
                .append(".");
        }
        return builder
                    .append(" ")
                    .append(lastName)
                .toString();
    }

    public Object printAddress() {
        StringBuffer builder = new StringBuffer(street);
        if (street2 != null) {
            builder
                .append("\n")
                .append(street2);
        }
        return builder
                    .append("\n")
                    .append(city)
                    .append(", ")
                    .append(state)
                    .append(" ")
                    .append(zip)
                .toString();        
    }
}
