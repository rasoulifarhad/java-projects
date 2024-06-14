package com.farhad.example.java_tips.null_checking.demo4.lib;

public class JObject {

    private String json;

    private JObject(String json) {
        this.json = json;
    }

    public static JObject parse(String json) {
        return new JObject(json);
    }

    public String value(String nameKey) {
        return "";
    }

}
