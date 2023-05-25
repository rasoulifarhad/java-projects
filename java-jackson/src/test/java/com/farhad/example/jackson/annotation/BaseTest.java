package com.farhad.example.jackson.annotation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseTest {

    ObjectMapper mapper ;

    @BeforeEach
    public void setup() {
        mapper = new ObjectMapper();
    }

    @AfterEach
    public void tearDown() {
        mapper = null;
    }

}
