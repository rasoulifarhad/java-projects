package com.farhad.example.codekata.lift_kata;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Lift {

    @Getter
    private final String id;
    @Getter
    private int floor;
    private List<Integer> requests;
    private boolean doorsOpen;

    

    public Lift(String id, int floor) {
        this(id, floor, new ArrayList<>(), false);
    }

    
    public Lift(String id, int floor, List<Integer> requests) {
        this(id, floor, requests, false);
    }

    public Lift(String id, int floor, boolean doorsOpen) {
        this(id, floor, new ArrayList<>(), doorsOpen);
    }

    public boolean hasRequestForFloor(int floor) {
        return requests.contains(floor);
    }

    public boolean areDoorOpen() {
        return doorsOpen;
    }

}
