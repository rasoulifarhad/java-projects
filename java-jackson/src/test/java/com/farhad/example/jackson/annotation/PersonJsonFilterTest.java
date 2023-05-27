package com.farhad.example.jackson.annotation;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.isJson;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.withJsonPath;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.withoutJsonPath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonJsonFilterTest extends BaseTest {

    @Test
    public void serializePersonJsonFilterTest() throws JsonProcessingException {
        //Given
        PersonJsonFilter personJsonFilter = new PersonJsonFilter(10, "Farhad Rasouli", "male");
        FilterProvider filterProvider = new SimpleFilterProvider()
                                                            .addFilter("myCustomFilter", SimpleBeanPropertyFilter.filterOutAllExcept("personId","name"));

        //When
        String jsonString = mapper.writer(filterProvider).writeValueAsString(personJsonFilter);
        log.info("{}", jsonString);

        //Then
        assertThat(jsonString, isJson(withJsonPath("$.personId", is(equalTo(10)))));
        assertThat(jsonString, isJson(withJsonPath("$.name", is(equalTo("Farhad Rasouli")))));
        assertThat(jsonString, isJson(withoutJsonPath("$.gender")));

    }
    
}
