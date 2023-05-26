package com.farhad.example.jackson.annotation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonAnySetterTest extends BaseTest {
    
    @Test
    public void deSerializeWithJsonAnySetter() throws JsonMappingException, JsonProcessingException {

        //Given
        String jsonString = "{\"personId\":10,\"name\":\"Farhad Rasouli\",\"attribute1\":\"attribute value 1\",\"attribute2\":\"attribute value 2\"}";

        //When
        PersonAnySetter personAnySetter = mapper.readValue(jsonString, PersonAnySetter.class);
        log.info("{}", personAnySetter);

        //Then
        assertThat(personAnySetter.getPersonId(), is(equalTo(10L)));
        assertThat(personAnySetter.getAttribute("attribute1"), is(equalTo("attribute value 1")));
        assertThat(personAnySetter.getAttribute("attribute2"), is(equalTo("attribute value 2")));
    }

}
