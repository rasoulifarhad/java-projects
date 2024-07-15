package com.farhad.example.codekata.theater_kata;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SeatFinder {

    private Theater theater;
    private List<Seat> booked;
    
    public SeatFinder(Theater theater) {
        this(theater, new ArrayList<>());
    }

    public List<Seat> suggest(int partySize) {

        List<Seat> seats = theater.getAvailableSeats();
        return seats;
    }

    
}
