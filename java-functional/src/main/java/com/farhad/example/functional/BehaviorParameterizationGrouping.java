package com.farhad.example.functional;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import lombok.AllArgsConstructor;
import lombok.Data;

// Group  employees based on certain criterias like proficiency level, technology type, gender etc or 
// new criterias can be added in future. 
public class BehaviorParameterizationGrouping {
    
    public static Map<String, List<Employee>> groupByTechnology(List<Employee> employees)  {
        Map<String, List<Employee>> groupedBy = new HashMap<>();
        for (Employee employee : employees) {
            groupedBy.putIfAbsent(employee.getTechnology(), new ArrayList<>());
            groupedBy.get(employee.getTechnology()).add(employee);
        }
        return groupedBy;
    }

    public static Map<String, Double>  highestSalaryByTechnology(List<Employee> employees) {
        Map<String, List<Employee>> groupedByTech = groupByTechnology(employees);

        Map<String, Double> highestSalaryBy = new HashMap<>();
        for (Entry<String, List<Employee>> entry : groupedByTech.entrySet()) {
            highestSalaryBy.put(entry.getKey(), maxSalary(entry.getValue()));
        }
        return highestSalaryBy;
    }

    public static Map<String, Double>  highestSalaryByTechnologyStream(List<Employee> employees) {
        return
            employees.stream()
                .collect(
                    groupingBy(
                        Employee::getTechnology, 
                        mapping(Employee::getSalary, collectingAndThen(maxBy(Comparator.naturalOrder()),Optional::get) ) ));
    }

    private static double maxSalary(List<Employee> employees) {
        double max = 0;
        for (Employee employee : employees) {
            max = Double.max(max, employee.getSalary());
        }
        return max;
    }

    public static Map<String, List<Employee>> group(List<Employee> employees, Groupable groupable) {
        Map<String, List<Employee>> groupedMap = new HashMap<>();
        for (Employee employee : employees) {
            String group = groupable.findGroup(employee);
            groupedMap.putIfAbsent(group, new ArrayList<>());
            groupedMap.get(group).add(employee);
        }
        return groupedMap;
    }

    interface Groupable {
        public String findGroup(Employee e);
    }

    static class GroupByExperience implements Groupable {

        @Override
        public String findGroup(Employee e) {
            return e.getYearsOfExpr() >= 7 ? "Expert" : 
                e.getYearsOfExpr() >= 3 ? "Intermediet" : "Fresher";     
        }
    }

    Function<Employee,String>  groupByExperienceFunction = 
        (Employee e) -> e.getYearsOfExpr() >= 7 ? "Expert" : 
                         e.getYearsOfExpr() >= 3 ? "Intermediet" : "Fresher";     
    Predicate<Employee> isJavaEmployee = e -> "java".equals(e.getTechnology());

    BiConsumer<List<Integer>, Integer> addIntoList = (l, i) -> l.add(i); 

    Supplier<Integer> uniqueKey = () -> new Random().nextInt();

    Runnable runnable = () -> "IUt is runnable".length();
    Callable<Integer> callable = () -> "it is callable".length();
     
    static class GroupByTechnology implements Groupable {

        private static Map<String, List<String>> mapping = new HashMap<String, List<String>>() {
            {
                put("Front-end", Arrays.asList("AngularJS", "ExtJS"));
                put("Middleware", Arrays.asList("Java", ".Net"));
                put("Back-end", Arrays.asList("Oracle", "Mysql", "PostgreSQL"));
            }
        };

        @Override
        public String findGroup(Employee e) {
            for (Entry<String, List<String>> entry : mapping.entrySet()) {
                if (entry.getValue().contains(e.getTechnology())){
                    return entry.getKey();
                }
            }
            return "Others";
        }

    }

    @Data
    @AllArgsConstructor
    static class Employee {

        enum Gender {
            MALE, FEMAILE
        }
        private String name;
        private String technology;
        private int yearsOfExpr;
        private Gender sex;
        private double salary;
    }
}
