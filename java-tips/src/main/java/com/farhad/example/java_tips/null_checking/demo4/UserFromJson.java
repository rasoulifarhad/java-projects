package com.farhad.example.java_tips.null_checking.demo4;

import com.farhad.example.java_tips.null_checking.demo4.our.IJsonParser;
import com.farhad.example.java_tips.null_checking.demo4.our.IOurJObject;
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

    @Override
    public String greeting() {
        IOurJObject jObject = jParser.parse(json);
        IName name = new Name(jObject);
        return "Hi " + name.printableName() + "!";
    }
    
}
