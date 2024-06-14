package com.farhad.example.java_tips.null_checking.demo2;


import com.farhad.example.java_tips.null_checking.demo2.our.IOurJObject;
import com.farhad.example.java_tips.null_checking.demo2.our.JsonParser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFromJson implements User {

    private final String json;
    private String nameKey;

    @Override
    public String greeting() {
        if(json == null) return "Please Log In";
        if(name() == null) return "Hi!";
        return "Hi " + name() + "!";
    }
    
    private String name() {
        IOurJObject jObject = new JsonParser().parse(json);
        if(jObject == null) return null;
        return jObject.value(nameKey);
    }

    // @Override
    // public String greeting() {
    //     String greeting = null;
    //     if(json == null) greeting = "Please Log In";
    //     String name = name();
    //     if(greeting == null && name != null ) greeting = "Hi " + name + "!";
    //     if(greeting == null ) greeting = "Hi!";
    //     return greeting;
    // }

}
