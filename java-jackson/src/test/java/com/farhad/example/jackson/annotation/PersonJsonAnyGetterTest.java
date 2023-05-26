package com.farhad.example.jackson.annotation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonJsonAnyGetterTest extends BaseTest {
    
    @Test
    public void serializeWithJsonAnyGetterTest() throws JsonProcessingException {
        //Given
        Map<String,Object>  attributes = new HashMap<>();
        attributes.put("attribute1", "attribute value 1");
        attributes.put("attribute2", "attribute value 2");
        PersonJsonAnyGetter personJsonAnyGetter = new PersonJsonAnyGetter(10, "Farhad Rasouli", attributes);

        //When
        String jsonString = mapper.writeValueAsString(personJsonAnyGetter);
        log.info("{}", jsonString);

        //Then
        assertThat(jsonString,containsString("10"));
        assertThat(jsonString,containsString("Farhad Rasouli"));
        assertThat(jsonString,containsString("attribute1"));
        assertThat(jsonString,containsString("attribute value 1"));
        assertThat(jsonString,containsString("attribute2"));
        assertThat(jsonString,containsString("attribute value 2"));
    }
}
