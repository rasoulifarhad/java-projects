package com.farhad.example.java_tips.isolate_3rd_party_code.isolated;

import com.farhad.example.java_tips.isolate_3rd_party_code.isolated.our.IOurJObject;
import com.farhad.example.java_tips.isolate_3rd_party_code.isolated.our.JsonParser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFromJson implements User {

    private final String json;
    private String nameKey;
    
    @Override
    public String greeting() {
        return String.format("Hi $s!", name());
    }

    private String name() {
        IOurJObject jObject = new JsonParser().parse(json);
        return jObject.value(nameKey);
    }

}
