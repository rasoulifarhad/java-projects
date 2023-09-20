package com.farhad.example.refactoring.videostore.refactored;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public abstract class Movie {
    
    private final String title;

    public abstract double determineAmount(int daysRented);
    public abstract int determineFrequentRenterPoints(int daysRented);
}
