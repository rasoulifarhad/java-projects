package com.farhad.example.java_tips.null_checking.demo5;

import com.farhad.example.java_tips.null_checking.demo5.our.IOurJObject;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Name implements IName {    

    private final IOurJObject jObject;
    private String nameKey;


    private String printableName() {
        String value = jObject.value(nameKey);
        return value.trim().isEmpty() ? "" : " " + value;
    }

    @Override
    public String greeting() {
        return "Hi " + printableName() + "!";
    }


}
