package com.farhad.example.stream.collectors.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private final String name;
    private final double salary;
    private final int age;
    private final Sex sex;

    public enum Sex {
        MALE,FEMALE
    }

    public final static Collection<Employee> employees = 
            new ArrayList<>(
                Arrays.asList(
                    new Employee("Karen Smith", 51200.0, 29, Sex.FEMALE),
                    new Employee("John Smith", 24000.0, 32, Sex.MALE),
                    new Employee("Anthony Jackson", 44000.0, 33, Sex.MALE),
                    new Employee("Alyson Palmer", 34320.0, 36, Sex.FEMALE),
                    new Employee("Jessica Sanders", 64329.0, 34, Sex.FEMALE)                
                )
            );

    public final static Map<Sex, List<Employee>> someEmployeesBySex =  
        new HashMap<>() {
            {
                put(Sex.MALE, new ArrayList<>() { { 
                            add( 
                                new Employee(
                                    "Peter Parker", 
                                    28100.0, 
                                    33, 
                                    Sex.MALE) ); } } );
                put(Sex.FEMALE, new ArrayList<>() { { 
                            add( 
                                new Employee(
                                    "Sarah Williams", 
                                    18100.0, 
                                    19, 
                                    Sex.FEMALE) ); } } );
            }
        };
}
