package com.farhad.example.work_effevtively_with_legacy_code.fake_objects;

import lombok.Value;

@Value
public class Price {

    private final double amount;

    public String asDisplayText() {
        return "$" + amount;
    }
}
