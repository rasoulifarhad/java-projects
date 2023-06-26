package com.farhad.example.guava.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Lists;

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

    @Test
    public void demonstrateCompareTo() {
        Employee farhad = new Employee("Farhad", Integer.valueOf(45), Job.DEVELOPER);
        Employee ali = new Employee("Ali", Integer.valueOf(30), Job.DESIGNER);
        Employee ceoAli = new Employee("Ali", Integer.valueOf(30), Job.CEO);
        Employee biggestAli = new Employee("Ali", Integer.valueOf(50), Job.DESIGNER);
        Employee mohammad = new Employee("Mohammad", Integer.valueOf(45), Job.DEVELOPER);
        Employee biggerFarhad = new Employee("Mohammad", Integer.valueOf(48), Job.DESIGNER);

        List<Employee> employees = Lists.newArrayList(farhad, ali, ceoAli, biggestAli, mohammad, biggerFarhad);
        Collections.sort(employees);
        employees.forEach(emp -> log.info("{}", emp));
    }
}
