package com.farhad.example.java_tips.null_checking;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFromJson  implements User {

    private final String json;

    @Override
    public String greeting() {
        String name = name();
        String greeting = null;
        if(name != null){
            greeting = "Hi " + name + "!";
        } else {
            greeting = "Hi!";
        }
        return greeting;
    }

    private String name() {
        return null;
    }

}
