package com.farhad.example.jackson.annotation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class PersonJsonIncludeTest extends BaseTest {

    @Test
    public void serializeWithJsonIncludeTest() throws JsonProcessingException {
        
        //Given
        PersonJsonInclude personJsonInclude = new PersonJsonInclude();

        //When
        String jsonString = mapper.writeValueAsString(personJsonInclude);
        log.info("{}", jsonString);

        //Then
        assertThat(jsonString, is(not(containsString("name"))));
        assertThat(jsonString, is(containsString("personId")));
    }

}
