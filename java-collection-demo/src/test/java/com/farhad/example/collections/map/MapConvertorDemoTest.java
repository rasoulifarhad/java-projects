package com.farhad.example.collections.map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapConvertorDemoTest {
    

    private MapConvertorDemo mapConvertorDemo ;

    @BeforeEach
    public void setup() {
        mapConvertorDemo = new MapConvertorDemo();
    }

    @AfterEach
    public void tearDown() {
        mapConvertorDemo = null;
    }

    @Test 
    public void convertIntegerMapKeysToListTest() {

        //Given
        Map<Integer,String> employeeIdMap = employeesCode();
        //When
        List<Integer> employeeIds = mapConvertorDemo.convertIntegerMapKeysToList(employeeIdMap);
        log.info("{}", employeeIds);
        //Then
        assertThat(employeeIds, not(emptyIterable()));
        assertThat(employeeIds, not(equalTo(Collections.EMPTY_LIST)));
        assertThat(employeeIds, not(IsEmptyCollection.empty()));
        assertThat(employeeIds, hasSize(4));
        assertThat(employeeIds, containsInAnyOrder(100, 200, 300, 400));
        assertThat(employeeIds, hasItems(200, 300));
        assertThat(employeeIds, not(hasItem(500)));
        assertThat(employeeIds, everyItem(greaterThan(90)));
    }
    
    @Test
    public void convertStringMapValuesToListTest() {

        //Given
        Map<Integer,String> employeeIdMap = employeesCode();
        //When
        List<String> employeeNames = mapConvertorDemo.convertStringMapValuesToList(employeeIdMap);
        log.info("{}", employeeNames);
        //Then
        assertThat(employeeNames, not(emptyIterable()));
        assertThat(employeeNames, hasSize(4));
        assertThat(employeeNames, containsInAnyOrder("Employee #100", "Employee #200", "Employee #300", "Employee #400"));
    }

    @Test
    public void convertIntegerMapKeysToListWithStreamTest() {

        //Given
        Map<Integer,String> employeeIdMap = employeesCode();
        //When
        List<Integer> employeeIds = mapConvertorDemo.convertIntegerMapKeysToList(employeeIdMap);
        log.info("{}", employeeIds);
        //Then
        assertThat(employeeIds, not(emptyIterable()));
        assertThat(employeeIds, not(equalTo(Collections.EMPTY_LIST)));
        assertThat(employeeIds, not(IsEmptyCollection.empty()));
        assertThat(employeeIds, hasSize(4));
        assertThat(employeeIds, containsInAnyOrder(100, 200, 300, 400));
        assertThat(employeeIds, hasItems(200, 300));
        assertThat(employeeIds, not(hasItem(500)));
        assertThat(employeeIds, everyItem(greaterThan(90)));
    }

    private Map<Integer,String> employeesCode() {

        Map<Integer,String> employeeIdMap = new HashMap<>();
        employeeIdMap.put(100, "Employee #100");
        employeeIdMap.put(200, "Employee #200");
        employeeIdMap.put(300, "Employee #300");
        employeeIdMap.put(400, "Employee #1400");
        return employeeIdMap ;
    }
}
