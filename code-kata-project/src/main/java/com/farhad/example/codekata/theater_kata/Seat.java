package com.farhad.example.codekata.theater_kata;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Seat {

    private final String row;
    private final int seatNumber;


    public Seat(String seatString) {
        this(seatString.substring(0, 1), Integer.parseInt(seatString.substring(1)));
    }


    @Override
    public String toString() {
        return row + seatNumber;
    }

    
}
