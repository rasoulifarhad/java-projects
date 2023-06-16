package com.farhad.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogGeneratorTest {

    private LogGenerator logGenerator;

    @BeforeEach
    public void setUp() {
        logGenerator = new LogGenerator();
    }

    @AfterEach
    public void tearDown() {
        logGenerator = null;
    }
 
    @Test
    void testGenerateData() {
        log.info("");
        logGenerator.generateData(1, 1);
    }

    @Test
    void testGenerateData2() {
        logGenerator.generateData2(1, 1);
    }
}
