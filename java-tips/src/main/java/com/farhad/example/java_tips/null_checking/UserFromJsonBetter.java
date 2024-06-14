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

    public String anotherGreeting() {
        if(json == null) return "Please Log In";
        if(name() == null) return "Hi!";
        return "Hi " + name() + "!";
    }
}
