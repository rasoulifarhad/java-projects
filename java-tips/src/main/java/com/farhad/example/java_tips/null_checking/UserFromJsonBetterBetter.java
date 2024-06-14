package com.farhad.example.java_tips.null_checking;

import com.farhad.example.java_tips.null_checking.our.IOurJObject;
import com.farhad.example.java_tips.null_checking.our.JsonParserBetter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFromJsonBetterBetter  implements User {

    private final String json;
    private String nameKey;

    @Override
    public String greeting() {
        if(json == null) return "Please Log In";
        if(name() == null) return "Hi!";
        return "Hi " + name() + "!";
    }
    
    private String name() {
        IOurJObject jObject = new JsonParserBetter().parse(json);
        if(jObject == null) return null;
        return jObject.value(nameKey);
    }

}
