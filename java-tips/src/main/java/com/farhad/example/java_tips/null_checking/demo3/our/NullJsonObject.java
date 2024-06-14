package com.farhad.example.java_tips.null_checking.demo3.our;

public class NullJsonObject implements IOurJObject{

    private static final IOurJObject instance = new NullJsonObject(); 
    private NullJsonObject() {

    }

    @Override
    public String value(String key) {
        return "";
    }

    public static IOurJObject instance() {
        return instance;
    }

}
