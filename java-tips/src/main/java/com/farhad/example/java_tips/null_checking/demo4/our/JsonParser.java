package com.farhad.example.java_tips.null_checking.demo4.our;

import com.farhad.example.java_tips.null_checking.demo4.lib.JObject;

public class JsonParser  implements IJsonParser {

    @Override
    public IOurJObject parse(String json) {
        try {
            return new OurJObject(JObject.parse(json));
        } catch (Throwable e) {
            return NullJsonObject.instance();
        }
    }
}
