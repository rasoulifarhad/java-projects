package com.farhad.example.jackson.annotation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import org.junit.jupiter.api.Test;

import com.farhad.example.jackson.annotation.PersonIgnoreType.Address;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonIgnoreTypeTest extends BaseTest {
    
    @Test
    public void serializeWithIgnoreTypeTest() throws JsonProcessingException{

        //Given 
        PersonIgnoreType personIgnoreType = new PersonIgnoreType();
        personIgnoreType.setPersonId(10);
        personIgnoreType.setName("Farhad Rasouli");
        Address address = new Address();
        address.setCountry("Iran");
        address.setCity("Tehran");
        address.setZipCode("123456");
        personIgnoreType.setAddress(address);

        //When
        String jsonString = mapper.writeValueAsString(personIgnoreType);
        log.info("{}", jsonString);
        
        //Then
        assertThat(jsonString, is(containsString("personId")));
        assertThat(jsonString, is(containsString("Farhad Rasouli")));
        assertThat(jsonString, is(not(containsString("country"))));
        assertThat(jsonString, is(not(containsString("address"))));
    }

    @Test
    public void deSerializeWithIgnoreTypeTest() throws JsonMappingException, JsonProcessingException {

        //Given
        String jsonString ="{\"personId\":10,\"name\":\"Farhad Rasouli\",\"address\":{\"streetName\":\"test\",\"houseNumber\":\"test\",\"zipCode\":\"123456\",\"city\":\"Tehran\",\"country\":\"Iran\"}}";

        //When
        PersonIgnoreType personIgnoreType = mapper.readValue(jsonString, PersonIgnoreType.class);
        log.info("{}", personIgnoreType);

        //Then
        assertThat(personIgnoreType.getPersonId(), is(equalTo(10L)));
        assertThat(personIgnoreType.getName(), is(equalTo("Farhad Rasouli")));
        assertThat(personIgnoreType.getAddress(), is(nullValue()));

    }
}
