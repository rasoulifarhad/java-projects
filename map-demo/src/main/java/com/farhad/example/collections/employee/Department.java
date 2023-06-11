package com.farhad.example.collections.employee;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Department {
    
    private static final AtomicLong idGenerator = new AtomicLong(0);


    @EqualsAndHashCode.Exclude
    private final long id ;
    private final String name;

    private Department(long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public static Department newDepartment(String name) {
        return new Department(idGenerator.incrementAndGet(), name);
    }


    public static List<Department> departments() {
        return  Arrays.asList("a", "b", "c", "d")
                        .stream()
                        .map(Department::newDepartment)
                        .collect(Collectors.toList());       
    }

}
