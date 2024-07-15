package com.farhad.example.codekata.theater_kata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Theater {


    private final List<Seat> seats = new ArrayList<>();

    public Theater(Map<String, List<Integer>> seatData) {

        for (String row : seatData.keySet()) {
            for (Integer seatNumber : seatData.get(row)) {
                seats.add(new Seat(row, seatNumber));
            }
        }
    }

    public List<Seat> getAvailableSeats() {
        return new ArrayList<>(seats);
    }

    
}
