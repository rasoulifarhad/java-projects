package com.farhad.example.jackson.annotation;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasNoJsonPath;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.isJson;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.withJsonPath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonManagedAndBackReferenceTest extends BaseTest {
    
    @Test
    public void serializePersonManagedAndBackReferenceTest() throws JsonProcessingException {
        //Given
        ManagerBackReference manager = new ManagerBackReference(20, "Manager of employees", new ArrayList<>());
        PersonManagedReference employee01 = new PersonManagedReference(10, "Farhad Rasouli", manager);
        manager.addEmployee(employee01);
        PersonManagedReference employee02 = new PersonManagedReference(11, "Another One", manager);
        manager.addEmployee(employee02);

        //When
        String employee01JsonString = mapper.writeValueAsString(employee01);
        String employee02JsonString = mapper.writeValueAsString(employee02);
        String managerJsonString = mapper.writeValueAsString(manager);
        log.info("Employee#01: {}",employee01JsonString);
        log.info("Employee#02: {}",employee02JsonString);
        log.info("Manager    : {}",managerJsonString);

        //Then
        assertThat(managerJsonString, hasJsonPath("$.personId", equalTo(20)));
        assertThat(managerJsonString, isJson(withJsonPath("$.name", equalTo("Manager of employees"))));
        assertThat(managerJsonString, hasNoJsonPath("$.employees"));

        assertThat(employee01JsonString, isJson(withJsonPath("$.personId", equalTo(10))));
        assertThat(employee01JsonString, hasJsonPath("$.manager"));
        assertThat(employee01JsonString, isJson(withJsonPath("$.manager.personId", equalTo(20))));


        assertThat(employee02JsonString, isJson(withJsonPath("$.personId", equalTo(11))));
        assertThat(employee02JsonString, hasJsonPath("$.manager"));
        assertThat(employee02JsonString, isJson(withJsonPath("$.manager.personId", equalTo(20))));
    }

}
