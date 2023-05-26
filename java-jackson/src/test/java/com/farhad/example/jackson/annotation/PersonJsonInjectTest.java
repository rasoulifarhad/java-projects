package com.farhad.example.jackson.annotation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonJsonInjectTest extends BaseTest {

    @Test
    public void deSerializeWithJsonInject() throws JsonMappingException, JsonProcessingException {

        //Given
        String jsonString = "{\"id\":10,\"name\":\"Farhad Rasouli\"}";

        //When
        InjectableValues injectableValues = new InjectableValues.Std().addValue(String.class, "value from InjectableValues");
        PersonJsonInject personJsonInject = new ObjectMapper().reader(injectableValues)
                                                    .forType(PersonJsonInject.class)
                                                    .readValue(jsonString);
        log.info("{}", personJsonInject);

        //Then
        assertThat(personJsonInject.getId(), is(equalTo(10L)));
        assertThat(personJsonInject.getSource(), is(equalTo("value from InjectableValues")));
    }
    
}
