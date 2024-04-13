package com.farhad.example.design_principles02.video_store_demo.demo2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {

	private Customer customer;

	@BeforeEach
	public void setup() {
		customer = new Customer("cust#1");
	}

	    @Test
    public void statementRentRegularMovieForOneDay() throws Exception {
        customer.addRental(getRental("Killer Klowns from Outer Space", Movie.REGULAR, 1));

        String expected = "Rental Record for cust#1\n" +
                "\tKiller Klowns from Outer Space\t2.0\n" +
                "Amount owed is 2.0\n"+
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementRentNewReleaseMovieForOneDay() throws Exception {
        customer.addRental(getRental("Awesome New Release", Movie.NEW_RELEASE, 1));

        String expected = "Rental Record for cust#1\n" +
                "\tAwesome New Release\t3.0\n" +
                "Amount owed is 3.0\n"+
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementRentChildrensMovieForOneDay() throws Exception {
        customer.addRental(getRental("Cars", Movie.CHILDRENS, 1));

        String expected = "Rental Record for cust#1\n" +
                "\tCars\t1.5\n" +
                "Amount owed is 1.5\n"+
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementRentChildrensMovieForFourDays() throws Exception {
        customer.addRental(getRental("Cars", Movie.CHILDRENS, 4));

        String expected = "Rental Record for cust#1\n" +
                "\tCars\t3.0\n" +
                "Amount owed is 3.0\n"+
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementRentRegularMovieForThreeDays() throws Exception {
        customer.addRental(getRental("Killer Klowns from Outer Space", Movie.REGULAR, 3));

        String expected = "Rental Record for cust#1\n" +
                "\tKiller Klowns from Outer Space\t3.5\n" +
                "Amount owed is 3.5\n"+
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementRentNewReleaseMovieForTwoDays() throws Exception {
        customer.addRental(getRental("Awesome New Release", Movie.NEW_RELEASE, 2));

        String expected = "Rental Record for cust#1\n" +
                "\tAwesome New Release\t6.0\n" +
                "Amount owed is 6.0\n"+
                "You earned 2 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void rentOneOfEachTypeForFourDays() throws Exception {
        int daysRented = 4;
        customer.addRental(getRental("Killer Klowns from Outer Space", Movie.REGULAR, daysRented));
        customer.addRental(getRental("Awesome New Release", Movie.NEW_RELEASE, daysRented));
        customer.addRental(getRental("Cars", Movie.CHILDRENS, daysRented));

        String expected = "Rental Record for cust#1\n" +
                "\tKiller Klowns from Outer Space\t5.0\n" +
                "\tAwesome New Release\t12.0\n" +
                "\tCars\t3.0\n" +
                "Amount owed is 20.0\n"+
                "You earned 4 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    private Rental getRental(String title, int priceCode, int daysRented) {
        Movie movie = new Movie(title, priceCode);
        return new Rental(movie, daysRented);
    }
}
