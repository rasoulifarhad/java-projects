package com.farhad.example.java_tips.null_checking.demo4;

import com.farhad.example.java_tips.null_checking.demo4.our.IJsonParser;
import com.farhad.example.java_tips.null_checking.demo4.our.JsonParser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFromJson  implements User {

    private final String json;
    private final IJsonParser jParser;
    private String nameKey;
    
    public UserFromJson(String json) {
        this(json, new JsonParser() );
    }

    public IName name() {
        return new Name(jParser.parse(json));
    }
    @Override
    public String greeting() {
        return "Hi " + name().printableName() + "!";
    }
    
}
