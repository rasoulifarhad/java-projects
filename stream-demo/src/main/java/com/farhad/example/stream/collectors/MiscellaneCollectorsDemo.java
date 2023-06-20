package com.farhad.example.stream.collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.farhad.example.stream.collectors.model.Employee;
import com.farhad.example.stream.collectors.model.Employee.Sex;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MiscellaneCollectorsDemo {
    
    public void demonstrateEmployeesBySex() {
        final Map<Sex, List<Employee>> bySex = 
                    Employee.employees
                                .stream()
                                .collect(groupingBy(Employee::getSex));
        log.info("{}", bySex);
    }

    public void demonstrateEmployeesBySexInSet() {
        final Map<Sex, Set<Employee>> bySex = 
                    Employee.employees
                                .stream()
                                .collect(groupingBy(Employee::getSex, toSet()));
        log.info("{}", bySex);

    }

    public void demonstrateEmployeesAverageAgeBySex() {

        Map<Sex, Double> averageAgeBySex = 
                    Employee.employees
                                .stream()
                                .collect(
                                    groupingBy(
                                        Employee::getSex, 
                                        averagingInt(Employee::getAge)));
        log.info("{}", averageAgeBySex);
    }

    public void demonstrateEmployeesBySexAndAge() {
        Map<Sex, Map<Integer, List<Employee>>> bySexAndAge = 
                        Employee.employees
                                    .stream()
                                    .collect(
                                        groupingBy(
                                            Employee::getSex, 
                                            groupingBy(
                                                Employee::getAge)));
        log.info("{}", bySexAndAge);
    }

    public void demonstrateYoungestEmployeBySex() {
        Map<Sex, Optional<Employee>> youngestBySex = 
                            Employee.employees
                                        .stream()
                                        .collect(
                                            groupingBy(
                                                Employee::getSex,
                                                minBy(
                                                    comparing(Employee::getAge))
                                                ));
        log.info("");
        log.info("{}", youngestBySex);
    }

    // Java provides a very easy way to provide comparators now by using Comparator.comparing(keyExtractor). KeyExtractor 
    // is a Function, so passing in a method reference is enough in this case.
    public void demonstrateOldestEmployeeBySex() {
        Map<Sex, Optional<Employee>> oldestBySex = 
                Employee.employees
                            .stream()
                            .collect(
                                groupingBy(
                                    Employee::getSex, 
                                    maxBy(
                                        comparing(Employee::getAge))));
        log.info("");
        log.info("{}", oldestBySex);
    }

    public void demonstrateEmployeesOverThirtyBySex() {

        Map<Sex, List<Employee>> overThityBySex = 
                    Employee.employees
                                .stream()
                                .collect(
                                    groupingBy(
                                        Employee::getSex,
                                        filtering( 
                                            emp -> emp.getAge() > 30, 
                                            toList())));

        log.info("");
        log.info("{}", overThityBySex);
    }

    public void demonstrateEmployeesOverThirtyBySexWithMapFactory() {
        Map<Sex, List<Employee>> overThityBySex = 
                    Employee.employees
                                .stream()
                                .collect(
                                    groupingBy(
                                        Employee::getSex, 
                                        () -> someEmployeesBySex(), 
                                        filtering(
                                            emp -> emp.getAge() > 30 , 
                                            toList())));
        log.info("");
        log.info("{}", overThityBySex);
    }

    private Map<Sex, List<Employee>> someEmployeesBySex() {
        final Map<Sex, List<Employee>> someEmployeesBySex =  
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
        return someEmployeesBySex;
    }

    public static void main(String[] args) {
        MiscellaneCollectorsDemo demo = new MiscellaneCollectorsDemo();

        demo.demonstrateEmployeesBySex();
        demo.demonstrateEmployeesBySexInSet();
        demo.demonstrateEmployeesAverageAgeBySex();
        demo.demonstrateEmployeesBySexAndAge();
        demo.demonstrateYoungestEmployeBySex();
        demo.demonstrateOldestEmployeeBySex();
        demo.demonstrateEmployeesOverThirtyBySex();
        demo.demonstrateEmployeesOverThirtyBySexWithMapFactory();
    }
}
