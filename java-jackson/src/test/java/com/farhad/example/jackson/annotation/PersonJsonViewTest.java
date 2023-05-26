package com.farhad.example.jackson.annotation;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasNoJsonPath;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.isJson;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.withJsonPath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonJsonViewTest extends BaseTest {

    @Test
    public void serializeWithJsonViewTest() throws JsonProcessingException {
        //Given
        PersonJsonView personJsonView = new PersonJsonView(10, "Farhad Rasouli", "male");

        //When
        String jsonPublicString = mapper.writerWithView(Views.Public.class)
                                  .writeValueAsString(personJsonView);
        String jsonInternalString = mapper.writerWithView(Views.Internal.class)
                                  .writeValueAsString(personJsonView);
        log.info("Public: {}", jsonPublicString);
        log.info("Internal: {}", jsonInternalString);

        //Then
        assertThat(jsonPublicString, hasJsonPath("$.name", is(equalTo("Farhad Rasouli"))));
        assertThat(jsonPublicString, hasJsonPath("$.personId", is(equalTo(10))));
        assertThat(jsonPublicString, hasNoJsonPath("$.gender"));

        assertThat(jsonInternalString, isJson(withJsonPath("$.name", equalTo("Farhad Rasouli"))));
        assertThat(jsonInternalString, isJson(withJsonPath("$.personId", equalTo(10))));
        assertThat(jsonInternalString, isJson(withJsonPath("$.gender", equalTo("male"))));
    }
    
}
