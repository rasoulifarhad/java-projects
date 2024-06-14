package com.farhad.example.java_tips.null_checking;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFromJsonBetter implements User {

    private final String json;

    @Override
    public String greeting() {
        String greeting = null;
        if(json == null) greeting = "Please Log In";
        String name = name();
        if(greeting == null && name != null ) greeting = "Hi " + name + "!";
        if(greeting == null ) greeting = "Hi!";
        return greeting;
    }

    private String name() {
        return null;
    }

}
