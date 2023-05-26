package com.farhad.example.jackson.annotation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonJsonValueTest extends BaseTest {
    
    @Test
    public void serializeWithJsonValueTest() throws JsonProcessingException {
        
        //Given
        PersonJsonValue personJsonValue = new PersonJsonValue(10, "Farhad Rasouli");

        //When
        String jsonString = mapper.writeValueAsString(personJsonValue);
        log.info("{}", jsonString);

        //Then
        assertThat(jsonString, containsString("10,Farhad Rasouli"));
    }
}
