package com.farhad.example.optional;

import java.util.Objects;

public class OptionalDemo {
    
    public String tokenizeName(String name) {
        
        Objects.requireNonNull(name);
        return (name.length() < 5) ? null : name;
    }
}
