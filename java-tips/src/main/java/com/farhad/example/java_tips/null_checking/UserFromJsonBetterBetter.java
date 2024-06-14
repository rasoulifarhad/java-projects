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
        return "Hi " + name() + "!";
    }
    
    private String name() {
        IOurJObject jObject = new JsonParserBetter().parse(json);
        return jObject.value(nameKey);
    }

}
