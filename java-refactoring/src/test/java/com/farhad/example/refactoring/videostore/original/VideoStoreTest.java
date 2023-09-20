package com.farhad.example.refactoring.videostore.original;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VideoStoreTest {
   
    @Test
    public void testStatementNoRental() {
        Customer customer = new Customer("Me");
        assertEquals("Rental Record for Me\n" +
                "You owed 0.0\n" +
                "You earned 0 frequent renter points\n", customer.statement());
    }

    @Test
    public void testStatementRegularShortRental() {
        Customer customer = new Customer("Me");
        customer.addRental(new Rental(new Movie("RRRrrrr!!!", Movie.REGULAR), 2));
        assertEquals("Rental Record for Me\n" +
                "\tRRRrrrr!!!\t2.0\n" +
                "You owed 2.0\n" +
                "You earned 1 frequent renter points\n", customer.statement());
    }

    @Test
    public void testStatementRegularLongRental() {
        Customer customer = new Customer("Me");
        customer.addRental(new Rental(new Movie("RRRrrrr!!!", Movie.REGULAR), 10));
        assertEquals("Rental Record for Me\n" +
                "\tRRRrrrr!!!\t14.0\n" +
                "You owed 14.0\n" +
                "You earned 1 frequent renter points\n", customer.statement());
    }

    @Test
    public void testStatementNewReleaseShortRental() {
        Customer customer = new Customer("Me");
        customer.addRental(new Rental(new Movie("Interstellar", Movie.NEW_RELEASE), 1));
        assertEquals("Rental Record for Me\n" +
                "\tInterstellar\t3.0\n" +
                "You owed 3.0\n" +
                "You earned 1 frequent renter points\n", customer.statement());
    }

    @Test
    public void testStatementNewReleaseLongRental() {
        Customer customer = new Customer("Me");
        customer.addRental(new Rental(new Movie("Interstellar", Movie.NEW_RELEASE), 3));
        assertEquals("Rental Record for Me\n" +
                "\tInterstellar\t9.0\n" +
                "You owed 9.0\n" +
                "You earned 2 frequent renter points\n", customer.statement());
    }

    @Test
    public void testStatementChildrensShortRental() {
        Customer customer = new Customer("Me");
        customer.addRental(new Rental(new Movie("Zootopie", Movie.CHILDRENS), 2));
        assertEquals("Rental Record for Me\n" +
                "\tZootopie\t1.5\n" +
                "You owed 1.5\n" +
                "You earned 1 frequent renter points\n", customer.statement());
    }

    @Test
    public void testStatementChildrensLongRental() {
        Customer customer = new Customer("Me");
        customer.addRental(new Rental(new Movie("Zootopie", Movie.CHILDRENS), 6));
        assertEquals("Rental Record for Me\n" +
                "\tZootopie\t6.0\n" +
                "You owed 6.0\n" +
                "You earned 1 frequent renter points\n", customer.statement());
    }

    @Test
    public void testStatementSeveralRentals() {
        Customer customer = new Customer("Me");
        customer.addRental(new Rental(new Movie("Zootopie", Movie.CHILDRENS), 1));
        customer.addRental(new Rental(new Movie("Interstellar", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("RRRrrrr!!!", Movie.REGULAR), 1));
        assertEquals("Rental Record for Me\n" +
                "\tZootopie\t1.5\n" +
                "\tInterstellar\t6.0\n" +
                "\tRRRrrrr!!!\t2.0\n" +
                "You owed 9.5\n" +
                "You earned 4 frequent renter points\n", customer.statement());
    }    
}
