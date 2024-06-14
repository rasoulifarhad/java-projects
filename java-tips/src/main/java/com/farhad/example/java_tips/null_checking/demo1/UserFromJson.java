package com.farhad.example.java_tips.null_checking.demo1;

import com.farhad.example.java_tips.null_checking.demo1.our.IOurJObject;
import com.farhad.example.java_tips.null_checking.demo1.our.JsonParser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFromJson  implements User {

    private final String json;
    private String nameKey;

    
    @Override
    public String greeting() {
        String greeting = null;
        if(json != null) {
            String name = name();
            if(name != null){
                greeting = "Hi " + name + "!";
            } else {
                greeting = "Hi!";
            }
        } else {
            greeting = "Please Log In";
        }
        return greeting;
    }

    private String name() {
        IOurJObject jObject = new JsonParser().parse(json);
        return jObject.value(nameKey);
    }

}
