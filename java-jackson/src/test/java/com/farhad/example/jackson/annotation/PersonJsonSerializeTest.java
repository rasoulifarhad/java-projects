package com.farhad.example.jackson.annotation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.jsonpath.JsonPath;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonJsonSerializeTest extends BaseTest {
    
    @Test
    public void serializeWithJsonSerializeTest() throws JsonProcessingException {
    
        //Given
        PersonJsonSerialize personJsonSerialize;
        personJsonSerialize = new PersonJsonSerialize(10, "Farhad Rasouli", true);

        //When
        String jsonString = mapper.writeValueAsString(personJsonSerialize);

        log.info("{}", jsonString);

        //Then
        assertThat(jsonString, containsString("enabled"));
        Long enabled = JsonPath.parse(jsonString).read("$.enabled",Long.class);
        assertThat(enabled, is(equalTo(1L)));
    }
}
