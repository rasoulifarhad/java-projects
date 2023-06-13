package com.farhad.example.collections.ordering;

import org.junit.jupiter.api.Test;

public class EmployeeSortTest {

    @Test
    public void demonstrateSeniorityOrder() {
        EmployeeSort demo = new EmployeeSort();
        demo.demonstrateSeniorityOrder();        
    }


    @Test
    public void demonstrateCorrectSeniorityOrder() {
        EmployeeSort demo = new EmployeeSort();
        demo.demonstrateCorrectSeniorityOrder();        
    }

    @Test
    void testDemonstrateIntegerMinValueWhenNegated() {
        EmployeeSort demo = new EmployeeSort();
        demo.demonstrateIntegerMinValueWhenNegated();
    }


}
