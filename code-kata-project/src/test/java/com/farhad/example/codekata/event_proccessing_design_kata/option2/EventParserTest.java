package com.farhad.example.codekata.event_proccessing_design_kata.option2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.farhad.example.codekata.event_proccessing_design_kata.Spike;
import com.farhad.example.codekata.event_proccessing_design_kata.StoreEvent;

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
        EventParser eventParser = new EventParser(inputStream);

        assertEquals("boutique", eventParser.getStoreType());
    }

    @Test
    public void parseProfile() {
        EventParser eventParser = new EventParser(inputStream);

        long profile = eventParser.getStoreProfile();
        assertEquals(2342534656L, profile);
    }

    @Test
    public void parseEventName() {
        EventParser eventParser = new EventParser(inputStream);

        String nextEvent = eventParser.getEventName();
        assertEquals("Eyeshadow Masterclass", nextEvent);
    }

    @Test
    public void parseNextEvent() {
        EventParser eventParser = new EventParser(inputStream);
        StoreEvent event = eventParser.getNextEvent();

        assertEquals("boutique", event.getStoreType());
        assertEquals(2342534656L, event.getStoreProfile());
        assertEquals("Eyeshadow Masterclass", event.getName());
    }


}
