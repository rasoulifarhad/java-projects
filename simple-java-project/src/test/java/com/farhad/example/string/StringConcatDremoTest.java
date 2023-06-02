package com.farhad.example.string;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringConcatDremoTest {
    
    @Test
    public void getAllColorsTest() {
        StringConcatDremo stringConcatDremo = new StringConcatDremo();
        String allColorNames = stringConcatDremo.getAllColors();
        log.info("{}", allColorNames);
    }

    @Test
    public void getAllColorsWithStringBuilderTest() {
        StringConcatDremo stringConcatDremo = new StringConcatDremo();
        String allColorNames = stringConcatDremo.getAllColorsWithStringBuilder();
        log.info("{}", allColorNames);
    }

}
