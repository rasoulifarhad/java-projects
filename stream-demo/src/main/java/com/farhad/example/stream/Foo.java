package com.farhad.example.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Foo {
    private final String name;
    private List<Bar> bars = new ArrayList<>();

    public static List<Foo> foos() {
        List<Foo> foos = new ArrayList<>();
        IntStream
            .range(1, 4)
            .forEach(i -> foos.add(new Foo("Foo" + i)));
        return foos;
    }

    public static List<Foo> foosWithBars() {
        List<Foo> foos = new ArrayList<>();
        // create foos
        IntStream
            .range(1, 4)
            .forEach(i -> foos.add(new Foo("Foo" + i)));
        
        // create bars
        foos.forEach(f -> 
            IntStream
                .range(1, 4)
                .forEach(i -> 
                    f.getBars().add(
                        new Bar(
                            String.format("Bar%d <- %s", i, f.getName())))));
        return foos;
    }

}
