package com.farhad.example.java_tips.technical_practices.no_getters;

public class Cash01 {
    private final int value;

    public Cash01(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
