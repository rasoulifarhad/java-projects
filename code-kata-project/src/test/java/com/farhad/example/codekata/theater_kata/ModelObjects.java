package com.farhad.example.codekata.theater_kata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelObjects {

    public static Theater standardTheater() {
        Map<String, List<Integer>> seats = new HashMap<String, List<Integer>>();
        seats.put("A", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        seats.put("B", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        seats.put("C", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        seats.put("D", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        seats.put("E", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        seats.put("F", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        seats.put("G", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        return new Theater(seats);
    }    

    public static Theater standardTheater2() {
        Map<String, List<Integer>> seats = new HashMap<String, List<Integer>>();
        seats.put("A", Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        seats.put("B", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        seats.put("C", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        seats.put("D", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        seats.put("E", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        seats.put("F", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        seats.put("G", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        return new Theater(seats);
    }    
}
