package com.farhad.example.refactoring.videostore.refactored;

import java.util.ArrayList;
import java.util.List;

public class RentalStatement {
    private String name;
    private List<Rental> rentals = new ArrayList<>();
    private double totalAmount;
    private int frequentRenterPoints;
    
    public RentalStatement(String customerName) {
        this.name = customerName;
    }

    public String getName() {
        return name;
    }
    
    public double getAmountOwed() {
        return totalAmount;
    }
    
    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }    

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String makeRentalStatement() {
        cleareToTal();
        return makeHeader() + makeRentalLines() + makeSummary();
    }

    private String makeSummary() {
        return 
                "You owed " + totalAmount + "\n" +
                "You earned " + frequentRenterPoints +
                " frequent renter points\n";
    }

    private String makeRentalLines() {
        String rentalLines = "";
        for (Rental rental : rentals) {
            rentalLines += makeRentalLine(rental);
        }
        return rentalLines;
    }

    private String makeRentalLine(Rental rental) {
        double thisAmount = rental.determineAmount();
        frequentRenterPoints += rental.determineFrequentRenterPoints();
        totalAmount += thisAmount;

        return formatRentalLine(rental, thisAmount);
    }

    private String formatRentalLine(Rental rental, double thisAmount) {
        return "\t" + rental.getTitle() + "\t" + thisAmount + "\n";
    }

    private String makeHeader() {
            return "Rental Record for " + getName() + "\n";
    }

    private void cleareToTal() {
        this.totalAmount = 0;
        this.frequentRenterPoints = 0;
    }
    

}
