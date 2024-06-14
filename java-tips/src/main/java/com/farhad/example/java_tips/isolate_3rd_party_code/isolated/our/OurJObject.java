package com.farhad.example.java_tips.isolate_3rd_party_code.isolated.our;

import com.farhad.example.java_tips.isolate_3rd_party_code.isolated.lib.JObject;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OurJObject implements IOurJObject {

    private final JObject jObject;

    @Override
    public String value(String key) {
        return jObject.value(key);
    }

}
