package com.farhad.example.java_tips.null_checking.demo3;

import com.farhad.example.java_tips.null_checking.demo3.our.IJsonParser;
import com.farhad.example.java_tips.null_checking.demo3.our.IOurJObject;
import com.farhad.example.java_tips.null_checking.demo3.our.JsonParser;

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
        return "Hi " + name() + "!";
    }
    
    private String name() {
        // IJsonParser jParser = new JsonParserBetter(); // no  new inline
        IOurJObject jObject = jParser.parse(json);
        return jObject.value(nameKey);
    }

}
