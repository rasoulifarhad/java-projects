package com.farhad.example.refactoring.videostore.refactored;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Rental {
    @Getter
    private Movie movie;
    private int daysRented;

    public String getTitle() {
        return movie.getTitle();
    }

    public double determineAmount() {
        return movie.determineAmount(daysRented);
    }

    public int determineFrequentRenterPoints() {
        return movie.determineFrequentRenterPoints(daysRented);
    }
}
