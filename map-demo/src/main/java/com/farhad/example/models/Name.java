package com.farhad.example.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Name implements Comparable<Name>{

    private final String firstName, lastName;
    @Override
    public int compareTo(Name o) {
        int lastCmp = lastName.compareTo(o.lastName);
        return ( lastCmp != 0 ? lastCmp : firstName.compareTo(o.firstName));
    }

    public String toString() {
        return String.format("%s %s", lastName, firstName) ;
    }
    
}
