package com.farhad.example.codekata.event_proccessing_design_kata.option3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.farhad.example.codekata.event_proccessing_design_kata.Spike;

public class EventParserTest {

    private InputStream inputStream;

    @BeforeEach
    public void setup() {
        String filename = "com/farhad/example/codekata/event_proccessing_design_kata/sample_store.xml";
        ClassLoader classLoader = Spike.class.getClassLoader();
        inputStream = classLoader.getResourceAsStream(filename);
    }

    @Test
    public void parseStoreType() {
        String storeClass = EventParser.getStoreType(inputStream);

        assertEquals("boutique", storeClass);
    }

    @Test
    public void parseProfile() {
        long profile = EventParser.getProfile(inputStream);

        assertEquals(2342534656L, profile);
    }

    @Test
    public void parseEventName() {
        String nextEvent = EventParser.getNextEvent(inputStream);

        assertEquals("Eyeshadow Masterclass", nextEvent);
    }


}
