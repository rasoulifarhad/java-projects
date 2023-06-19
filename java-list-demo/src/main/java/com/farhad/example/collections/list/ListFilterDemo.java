package com.farhad.example.collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListFilterDemo {
    
    @Data
    @AllArgsConstructor
    static class Employee {
        private long id;
        private String name;
        private int age;
        private String designation;

        public static List<Employee> employees() {
            List<Employee> employees = new ArrayList<>();
            employees.add(new Employee(1,"Robert",35,"Manager"));
            employees.add(new Employee(2,"Martin",35,"General Manager"));
            employees.add(new Employee(1,"Jack",25,"Manager"));
            employees.add(new Employee(3,"Akshay",20,"Developer"));
            employees.add(new Employee(1,"Arvind",40,"Manager"));
            employees.add(new Employee(1,"Dinesh",45,"Manager"));        
            return employees;
        }
    }

    public List<Employee> findByDesignationAndFromAge(String designation, int age) {
        Objects.requireNonNull(designation);
        log.info("");
        List<Employee> employees = Employee.employees();
        List<Employee> selectedEmps = new ArrayList<>();
        for( Employee emp : employees) {
            if( emp.getDesignation().equalsIgnoreCase(designation) && emp.getAge() > age ) {
                selectedEmps.add(emp);
            }
        } 
        log.info("Selected List: {}", selectedEmps);
        return selectedEmps;
    }

    public List<Employee> findByDesignationAndFromAgeWithStream(String designation, int age) {
        Objects.requireNonNull(designation);
        log.info("");
        List<Employee> employees = Employee.employees();
        List<Employee> selectedEmps = 
                    employees
                        .stream()
                        .filter(e -> e.getDesignation().equalsIgnoreCase(designation) && e.getAge() > age )
                        .collect(Collectors.toList());
        log.info("Selected List: {}", selectedEmps);
        return selectedEmps;
    }

    public static void main(String[] args) {
        
        ListFilterDemo demo = new ListFilterDemo();

        demo.findByDesignationAndFromAge("Manager", 30);
        demo.findByDesignationAndFromAgeWithStream("Manager", 30);
    }

}
