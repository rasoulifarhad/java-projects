package com.farhad.example.codekata.theater_kata;

import static com.farhad.example.codekata.theater_kata.ModelObjects.standardTheater2;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

public class SeatFinderTest {

    @Test
    public void suggestSeatsInMiddle() {

        Theater theater = standardTheater2();
        List<Seat> booked = 
            Stream.of("A2", "A3", "A4", "A5", "A6")
                .map(Seat::new)
                .collect(toList());

        SeatFinder seatFinder = new SeatFinder(theater, booked);
        List<Seat> suggestedSeats = seatFinder.suggest(2);
        Approvals.verifyAll("Suggested seats", suggestedSeats);
    }
}
