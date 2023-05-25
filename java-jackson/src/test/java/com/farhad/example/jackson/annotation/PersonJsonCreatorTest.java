package com.farhad.example.jackson.annotation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonJsonCreatorTest extends BaseTest {

    @Test
    public void serializeWithJsonCreatorText() throws JsonProcessingException {
        //Given
        PersonJsonCreator personJsonCreator = new PersonJsonCreator(10, "Farhad Rasouli");

        //When
        String jsonString = mapper.writeValueAsString(personJsonCreator);
        log.info("{}", jsonString);

        //Then
        assertThat(jsonString, containsString("id"));
        assertThat(jsonString, containsString("10"));
        assertThat(jsonString, containsString("name"));
        assertThat(jsonString, containsString("Farhad Rasouli"));

    }

    @Test
    public void test() throws JsonMappingException, JsonProcessingException {
        //Given
        String jsonString = "{\"id\": 10, \"name\": \"Farhad Rasouli\"}";

        //When
        PersonJsonCreator personJsonCreator = mapper.readValue(jsonString, PersonJsonCreator.class);
        log.info("{}", personJsonCreator);

        //Then
        assertThat(personJsonCreator.getId(), is(equalTo(10L)));
        assertThat(personJsonCreator.getName(), is(equalTo("Farhad Rasouli")));

    }
}
