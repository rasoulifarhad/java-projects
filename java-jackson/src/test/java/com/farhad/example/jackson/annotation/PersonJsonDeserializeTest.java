package com.farhad.example.jackson.annotation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonJsonDeserializeTest extends BaseTest {

    @Test
    public void deSerializeWithJsonDeserialize() throws JsonMappingException, JsonProcessingException {

        //Given
        String jsonString = "{\"id\":10,\"name\":\"Farhad Rasouli\",\"enabled\":1}";

        //When
        PersonJsonDeserialize personJsonDeserialize = mapper.readValue(jsonString, PersonJsonDeserialize.class);
        log.info("{}", personJsonDeserialize);

        //Then
        assertThat(personJsonDeserialize.isEnabled(), equalTo(true));
    }
}

