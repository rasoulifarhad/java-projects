package com.farhad.example.jackson.annotation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class PersonIgnoreTest {
    
    private ObjectMapper mapper ;

    @BeforeEach
    public void setup() {
        mapper = new ObjectMapper();
    }

    @AfterEach
    public void tearDown() {
        mapper = null;
    }

    @Test
    public void serializ2WithIgnoreTest() throws JsonProcessingException {
        //Given
        PersonIgnore personIgnore = new PersonIgnore(10, "Farhad Rasouli");

        //When
        String personIgnoreJsonString = mapper.writeValueAsString(personIgnore);
        log.info("{}", personIgnoreJsonString);
        //Then
        assertThat(personIgnoreJsonString,containsString("Farhad Rasouli"));
        assertThat(personIgnoreJsonString, not(containsString("personId")));
    }

    @Test
    public void deSerializeWithIgnoreTest() throws JsonMappingException, JsonProcessingException {
        
        //Given
        String personIgnoreJsonString = "{ \"personId\": 10, \"name\": \"Farhad Rasouli\"}";

        //When
        PersonIgnore personIgnore =  mapper.readValue(personIgnoreJsonString, PersonIgnore.class);
        log.info("{}", personIgnore);

        //Then
        assertThat(personIgnore.getName(), is(equalTo("Farhad Rasouli")));
        assertThat(personIgnore.getPersonId(), is(not(equalTo(10))));
    }
}
