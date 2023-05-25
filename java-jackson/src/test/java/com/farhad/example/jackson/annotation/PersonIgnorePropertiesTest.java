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
public class PersonIgnorePropertiesTest {
    
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
    public void serializeWithIgnoreProperties() throws JsonProcessingException {

        //Given
        PersonIgnoreProperties personIgnoreProperties = new PersonIgnoreProperties(10, "Farhad", "Rasouli");

        //When
        String jsonString =  mapper.writeValueAsString(personIgnoreProperties);
        log.info("{}", jsonString);

        //Then
        assertThat(jsonString, containsString("personId"));
        assertThat(jsonString, not(containsString("Farhad")));
        assertThat(jsonString, not(containsString("Rasouli")));
    }

    @Test
    public void deSerializeWithIgnoreProperties() throws JsonMappingException, JsonProcessingException {

        //Given
        String jsonString = "{ \"personId\": 10, \"firstName\": \"Farhad\", \"lastName\": \"Rasouli\"}";

        //When
        PersonIgnoreProperties personIgnoreProperties = mapper.readValue(jsonString,PersonIgnoreProperties.class);
        log.info("{}", personIgnoreProperties);

        //Then
        assertThat(personIgnoreProperties.getPersonId(), is(equalTo(10L)));
        assertThat(personIgnoreProperties.getFirstName(), is(not(equalTo("Farhad"))));
        assertThat(personIgnoreProperties.getLastName(), is(not(equalTo("Rasouli"))));
    }

}
