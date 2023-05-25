package com.farhad.example.jackson.annotation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonAutoDetectTest extends BaseTest {
    
    @Test
    public void serializeWithAutoDetectFieldVisibilityAny() throws JsonProcessingException {
        //Given
        PersonAutoDetect personAutoDetect = new PersonAutoDetect(10, "Farhad Rasouli");

        //When 
        String jsonString = mapper.writeValueAsString(personAutoDetect);
        log.info("{}", jsonString);

        //Then
        assertThat(jsonString,containsString("personId"));
        assertThat(jsonString,containsString("10"));
        assertThat(jsonString,containsString("Farhad Rasouli"));

    }
}
