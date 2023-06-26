package com.farhad.example.guava.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeTest {

    @Test
    void demonstrateToString() {
        Employee employee = new Employee("Farhad", Integer.valueOf(45), Job.DEVELOPER);
        log.info("Employee: {}", employee.toString());
    }

    @Test
    public void demonstrateEqualAndHash() {
        Employee farhadEmployee = new Employee("Farhad", Integer.valueOf(45), Job.DEVELOPER);
        Employee aliEmployee = new Employee("Ali", Integer.valueOf(30), Job.DESIGNER);
        Employee other = new Employee("Farhad", Integer.valueOf(45), Job.DEVELOPER);

        assertEquals(farhadEmployee, other);
        assertFalse(farhadEmployee.equals(aliEmployee));

        assertEquals(farhadEmployee.hashCode(), other.hashCode());
    }
}
