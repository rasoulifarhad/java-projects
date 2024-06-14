package com.farhad.example.java_tips.null_checking.demo4;

import com.farhad.example.java_tips.null_checking.demo4.our.IOurJObject;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Name implements IName {    

    private final IOurJObject jObject;
    private String nameKey;

    
    @Override
    public String name() {
        return jObject.value(nameKey);
    }

}
