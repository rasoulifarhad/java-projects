package com.farhad.example.models;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NameTest {

    @Test
    void demonstrateNameSort()  {

        Name [] nameArray = {
            new Name("John", "Smith"),
            new Name("Karl", "Ng"),
            new Name("Jeff", "Smith"),
            new Name("Tom", "Rich")        
        };
        List<Name> names = Arrays.asList(nameArray);  
        log.info("");
        log.info("Before sort: {}", names);
        Collections.sort(names);
        log.info("After  sort: {}", names);

    }
}
