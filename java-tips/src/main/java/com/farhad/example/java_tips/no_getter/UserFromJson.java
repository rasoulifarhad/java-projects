package com.farhad.example.java_tips.no_getter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFromJson implements User {

    private final String name;

    @Override
    public String greeting() {
        return String.format("Hi %s!", name);
    }

}
