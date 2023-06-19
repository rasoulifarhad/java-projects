package com.farhad.example.collections.list;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.farhad.example.collections.list.ListFilterDemo.Employee;

public class ListFilterDemoTest {
    @Test
    void testFindByDesignationAndFromAge() {
        ListFilterDemo demo = new ListFilterDemo();
        List<Employee> emps = demo.findByDesignationAndFromAge("Manager", 30);

        assertThat(emps)
            .hasSize(3);
    }

    @Test
    void testFindByDesignationAndFromAgeWithStream() {
        ListFilterDemo demo = new ListFilterDemo();
        List<Employee> emps = demo.findByDesignationAndFromAgeWithStream("Manager", 30);

        assertThat(emps)
            .hasSize(3);
    }
}
