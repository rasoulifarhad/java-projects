package com.farhad.example.java_tips.null_checking.demo1.our;

import com.farhad.example.java_tips.null_checking.demo1.lib.JObject;

public class JsonParser implements IJsonParser {

    @Override
    public OurJObject parse(String json) {
        try {
            return new OurJObject(JObject.parse(json));
        } catch (Throwable e) {
            return null;
        }
    }

}
