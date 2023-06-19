package com.farhad.example.collections.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConvertListToMapDemo {
    
    @Data
    @AllArgsConstructor
    static class Employee {
        private long empId;
        private String name;
        private String designation;

        public static List<Employee> employees() {
            List<Employee> employees = new ArrayList<>();
            employees.add(new Employee(1, "Robert", "Manager"));
            employees.add(new Employee(2, "Martin", "General Manager"));
            employees.add(new Employee(3, "Jack", "Manager"));
            return employees;
        }
    }

    public Map<Long, String> toMap(List<Employee> employees) {
        Objects.requireNonNull(employees);
        log.info("");
        Map<Long, String> employeeMap = new HashMap<>();
        for(Employee emp : employees) {
            employeeMap.put(emp.getEmpId(), emp.getDesignation());
        }
        log.info("List: {}, map: {}", employees, employeeMap);
        return employeeMap;
    }

    public Map<Long, String> toMapWithStream(List<Employee> employees) {
        Objects.requireNonNull(employees);
        log.info("");
        Map<Long, String> employeeMap = 
                employees.stream()
                    .collect(Collectors.toMap(Employee::getEmpId, Employee::getDesignation));
        log.info("List: {}, map: {}", employees, employeeMap);
        return employeeMap;
    }

    public static void main(String[] args) {

        ConvertListToMapDemo demo = new ConvertListToMapDemo();
        List<Employee> employees = Employee.employees();

        demo.toMap(employees);
        demo.toMapWithStream(employees);
    }

}
