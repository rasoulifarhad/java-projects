package com.farhad.example.jackson.annotation;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasNoJsonPath;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.isJson;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.withJsonPath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

import com.farhad.example.jackson.annotation.PersonJsonUnwrapped.Address;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonJsonUnwrappedTest extends BaseTest {
    
    @Test
    public void serializeWithJsonUnwrapped() throws JsonProcessingException {
        //Given
        PersonJsonUnwrapped personJsonUnwrapped = new PersonJsonUnwrapped();
        personJsonUnwrapped.setPersonId(10);
        personJsonUnwrapped.setName("Farhad Rasouli");
        Address address = new Address();
        address.setCountry("Iran");
        address.setCity("Tehran");
        address.setZipCode("123456");
        personJsonUnwrapped.setAddress(address);
        //When
        String jsonString = mapper.writeValueAsString(personJsonUnwrapped);
        log.info("{}", jsonString);
        //Then
        assertThat(jsonString, isJson());
        assertThat(jsonString, hasJsonPath("$.name"));
        assertThat(jsonString, hasJsonPath("$.personId"));
        assertThat(jsonString, hasNoJsonPath("$.address"));
        assertThat(jsonString, hasJsonPath("$.country"));
        assertThat(jsonString, hasJsonPath("$.city"));
        assertThat(jsonString, hasJsonPath("$.zipCode"));
        assertThat(jsonString, hasJsonPath("name", equalTo("Farhad Rasouli")));
        assertThat(jsonString, hasJsonPath("$.personId", equalTo(10)));
        assertThat(jsonString, hasJsonPath("$.country",equalTo("Iran")));
        assertThat(jsonString, hasJsonPath("$.city", equalTo("Tehran")));
        assertThat(jsonString, isJson(withJsonPath("$.zipCode", equalTo("123456"))));
    }
}
