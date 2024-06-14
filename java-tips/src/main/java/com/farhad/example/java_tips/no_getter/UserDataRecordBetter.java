package com.farhad.example.java_tips.no_getter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDataRecordBetter {

    private final String name;

    public String greeting() {
        return String.format("Hi %s!", name);
    }
}
