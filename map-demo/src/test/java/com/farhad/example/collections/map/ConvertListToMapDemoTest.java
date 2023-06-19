package com.farhad.example.collections.map;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.farhad.example.collections.map.ConvertListToMapDemo.Employee;

public class ConvertListToMapDemoTest {
    @Test
    void testToMap() {
        ConvertListToMapDemo demo = new ConvertListToMapDemo();
        Map<Long, String> map = demo.toMap(Employee.employees());

        assertThat(map)
                .hasSize(3)
                .containsEntry(Long.valueOf(1), "Manager")
                .containsEntry(Long.valueOf(2), "General Manager")
                .containsEntry(Long.valueOf(3), "Manager");
    }

    @Test
    void testToMapWithStream() {
        ConvertListToMapDemo demo = new ConvertListToMapDemo();
        Map<Long, String> map = demo.toMapWithStream(Employee.employees());

        assertThat(map)
                .hasSize(3)
                .containsEntry(Long.valueOf(1), "Manager")
                .containsEntry(Long.valueOf(2), "General Manager")
                .containsEntry(Long.valueOf(3), "Manager");
    }
}
