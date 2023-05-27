package com.farhad.example.jackson.annotation;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasNoJsonPath;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.isJson;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.withJsonPath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonIgnorePropertiesTest extends BaseTest {
    
    @Test
    public void serializeWithIgnoreProperties() throws JsonProcessingException {

        //Given
        PersonIgnoreProperties personIgnoreProperties = new PersonIgnoreProperties(10, "Farhad", "Rasouli");

        //When
        String jsonString =  mapper.writeValueAsString(personIgnoreProperties);
        log.info("{}", jsonString);

        //Then
        assertThat(jsonString, isJson());
        assertThat(jsonString, hasJsonPath("$.personId"));
        assertThat(jsonString, isJson(withJsonPath("$.personId", is(equalTo(10)))));
        assertThat(jsonString, hasNoJsonPath("$.firstName"));
        assertThat(jsonString, hasNoJsonPath("$.lasttName"));
        // assertThat(jsonString, not(containsString("Farhad")));
        // assertThat(jsonString, not(containsString("Rasouli")));
        // assertThat(jsonString, containsString("personId"));
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
