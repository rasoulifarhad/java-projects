package com.farhad.example.java_tips.isolate_3rd_party_code.isolated.our;

import com.farhad.example.java_tips.isolate_3rd_party_code.isolated.lib.JObject;

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
