package com.farhad.example.collections.employee;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {


    private final long id;
    private final String name; 
    private final Department department;
    private final int salary;
    private final String designation;
    private final int age;

    public static List<String> names(List<Employee> employees) {
        return employees.stream()
                    .map(emp -> emp.getName())
                    .collect(Collectors.toList());
    }

    public static List<Integer> salaries(List<Employee> employees) {
        return employees.stream()
                    .map(emp -> emp.getSalary())
                    .collect(Collectors.toList());
    }

    public static class factory {

        private final static AtomicLong idGenerator = new AtomicLong(0);
        private static String [] names = new String[] {"John", "Jane", "Mary", "Mike", "Bob", "Sue", "Richard", "Robert", "Martin", "Arvind"};
        private static String [] designations = new String[] {"Manager", "Developer", "Engineer", "designer"};
        private static String [] departments = new String[] {"Sales", "Engineering", "Marketing", "Finance"};
        private static int [] salaries = new int[] {10000, 20000, 30000, 40000};
        private static int [] ages = new int[] {20, 30, 40, 50};


        public static List<Employee> employees() {

            Random rnd = new Random();
    
            return Arrays.asList(names)
                            .stream()
                            .map(name -> Employee.builder()
                                                        .id(idGenerator.incrementAndGet())
                                                        .name(name)
                                                        .department(Department.newDepartment( departments[rnd.nextInt(departments.length)] ) )
                                                        .salary(salaries[rnd.nextInt(salaries.length)])
                                                        .designation(designations[rnd.nextInt(designations.length)])
                                                        .age(ages[rnd.nextInt(ages.length)])
                                                    .build()
                                    )
                                    .collect(Collectors.toList());
        }
    }
}
