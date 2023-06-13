package com.farhad.example.collections.ordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeSort {
    
    // The Comparator in the preceding program works fine for sorting a List, but it does have one deficiency: It cannot be used to 
    // order a sorted collection, such as TreeSet, because it generates an ordering that is not compatible with equals. This means 
    // that this Comparator equates objects that the equals method does not. In particular, any two employees who were hired on the 
    // same date will compare as equal. 
    //
    // When you're sorting a List, this doesn't matter; but when you're using the Comparator to order a sorted collection, it's fatal. 
    // If you use this Comparator to insert multiple employees hired on the same date into a TreeSet, only the first one will be added 
    // to the set; the second will be seen as a duplicate element and will be ignored.
    static final Comparator<Employee> SENIORITY_ORDER = new Comparator<Employee>() {

        @Override
        public int compare(Employee o1, Employee o2) {
            return o2.getHireDate().compareTo(o1.getHireDate());
        }
    };

    static final Comparator<Employee> CORRECT_SENIORITY_ORDER = new Comparator<Employee>() {

        @Override
        public int compare(Employee o1, Employee o2) {
            int empCmp = o2.getHireDate().compareTo(o1.getHireDate());
            if (empCmp != 0) {
                return empCmp;
            }
            return o1.getNumber() < o2.getNumber()? -1 : ( o1.getNumber() == o2.getNumber()? 0 : 1 );
        }
        
    };
    static List<Employee> _EMPLOYEES  = Employee.factory.employees();

    public void demonstrateSeniorityOrder() {
        List<Employee> employees  = new ArrayList<>(_EMPLOYEES);
        log.info("");
        log.info("Employees: {}", employees);
        Collections.sort(employees, SENIORITY_ORDER);
        log.info("Sorted: {}",employees);
    }

    public void demonstrateCorrectSeniorityOrder() {
        List<Employee> employees  = new ArrayList<>(_EMPLOYEES);
        log.info("");
        log.info("Employees: {}", employees);
        Collections.sort(employees, CORRECT_SENIORITY_ORDER);
        log.info("Sorted: {}",employees);
    }

    public void demonstrateIntegerMinValueWhenNegated() {
        log.info("");
        log.info("Integer.MIN_VALUE: {}, -Integer.MIN_VALUE: {}", Integer.MIN_VALUE, -Integer.MIN_VALUE);
    }

    public static void main(String[] args) {
    
        EmployeeSort demo = new EmployeeSort();
        demo.demonstrateSeniorityOrder();
        demo.demonstrateCorrectSeniorityOrder();
        demo.demonstrateIntegerMinValueWhenNegated();
    }
}
