package com.farhad.example.java_tips.null_checking.demo3.our;

import com.farhad.example.java_tips.null_checking.demo3.lib.JObject;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OurJObject implements IOurJObject {

    private final JObject jObject;

    @Override
    public String value(String key) {
        return jObject.value(key);
    }

}
