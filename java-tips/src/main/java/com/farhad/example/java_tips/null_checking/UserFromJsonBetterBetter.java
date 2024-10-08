package com.farhad.example.java_tips.null_checking;

import com.farhad.example.java_tips.null_checking.our.IJsonParser;
import com.farhad.example.java_tips.null_checking.our.IOurJObject;
import com.farhad.example.java_tips.null_checking.our.JsonParserBetter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFromJsonBetterBetter  implements User {

    private final String json;
    private final IJsonParser jParser;
    private String nameKey;


    
    public UserFromJsonBetterBetter(String json) {
        this(json, new JsonParserBetter() );
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
