package com.farhad.example.codekata.event_proccessing_design_kata.option2;

import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;

import com.farhad.example.codekata.event_proccessing_design_kata.Spike;

public class EventParserTest {

    private InputStream inputStream;

    @BeforeEach
    public void setup() {
        String filename = "com/farhad/example/codekata/event_proccessing_design_kata/sample_store.xml";
        ClassLoader classLoader = Spike.class.getClassLoader();
        inputStream = classLoader.getResourceAsStream(filename);
    }
}
