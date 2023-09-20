package com.farhad.example.codekata.video_store;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    
    private String name;
    private Vector<Rental> rentals = new Vector<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {

    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        String result = "Rental Record for " + getName() + "\n";

        while (rentals.hasMoreElements()) {
            Rental rental = (Rental) rentals.nextElement();

            // determines the amount for each line
            double thisAmount = rental.amount();

            result += "\t" + rental.getTitle() + "\t"
                    + String.valueOf(thisAmount) + "\n";

            frequentRenterPoints += rental.frequentPoints();
            totalAmount += thisAmount;
        }

        result += "You owed " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";

        return result;
    }
}
