package com.farhad.example.codekata.video_store;

public class Movie {
    
    private MovieType type;
    private String title;
    
    public Movie(String title,int priceCode) {
        this.title = title;
        this.type = MovieType.create(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public double getAmount(int daysRented)     {
        return type.getAmount(daysRented);
    }

    public int getFrequentPoints(int daysRented) {
        return type.getFrequentPoints(daysRented);
    }
    
}
