package com.farhad.example.jackson.annotation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.jsonpath.JsonPath;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonJsonRawValueTest extends BaseTest {
    
    @Test
    public void serializeJsonRawValueTest() throws JsonProcessingException {

        //Given 
        PersonJsonRawValue personJsonRawValue = new PersonJsonRawValue(10, 
                                                "Farhad Rasouli", 
                                                "{\"streetName\":\"test\",\"houseNumber\":\"test\",\"zipCode\":\"123456\",\"city\":\"Tehran\",\"country\":\"Iran\"}", 
                                                "{\"streetName\":\"test\",\"houseNumber\":\"test\",\"zipCode\":\"123456\",\"city\":\"Tehran\",\"country\":\"Iran\"}");
        //When
        String jsonString = mapper.writeValueAsString(personJsonRawValue);
        log.info("{}", jsonString);

        String jsonPathAddress = JsonPath.parse(jsonString).read("$.address");
        log.info("{}", jsonPathAddress);
        
        Map<String,?> rawAddressMap  = JsonPath.parse(jsonString).read("$.rawAddress", Map.class);
        log.info("{}", rawAddressMap);
        //Then
        assertThat(jsonPathAddress, is(notNullValue()));
        assertThat(jsonPathAddress, containsString("Tehran"));
        assertThat(rawAddressMap.keySet(), contains("streetName", "houseNumber", "zipCode", "city", "country"));
    }
}
