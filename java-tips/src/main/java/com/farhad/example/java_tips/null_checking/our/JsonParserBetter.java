package com.farhad.example.java_tips.null_checking.our;

import com.farhad.example.java_tips.null_checking.lib.JObject;

public class JsonParserBetter  implements IJsonParser {

    @Override
    public IOurJObject parse(String json) {
        try {
            return new OurJObject(JObject.parse(json));
        } catch (Throwable e) {
            return NullJsonObject.instance();
        }
    }
}
