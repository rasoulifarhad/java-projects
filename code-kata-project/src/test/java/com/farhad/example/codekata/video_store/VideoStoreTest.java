package com.farhad.example.codekata.video_store;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class VideoStoreTest {

    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer("Fred");
    }

    @Test
    public void testSingleNewReleaseStatement() {
        customer.addRental(
            new Rental(
                new Movie("The Cell", MovieType.NEW_RELEASE), 
                3));

        assertThat(
            customer.statement(),
            is("Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n"));
    }

    @Test
    public void testDualNewReleaseStatement() {
        customer.addRental(
            new Rental(
                new Movie("The Cell", MovieType.NEW_RELEASE), 
                3));
        customer.addRental(
            new Rental(
                new Movie("The Tigger Movie", MovieType.NEW_RELEASE), 
                3));

        assertThat(
            customer.statement(),
            is("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n"));
    }

    @Test
    public void testSingleChildrensStatement() {
        customer.addRental(
            new Rental(
                new Movie("The Tigger Movie", MovieType.CHILDRENS), 
                3));

        assertThat(
            customer.statement(),
            is("Rental Record for Fred\n\tThe Tigger Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n"));
    }

    @Test
    public void testSingleChildrensStatementRentedMoreThanThreeDaysAgo() {
        customer.addRental(
            new Rental(
                new Movie("The Tigger Movie", MovieType.CHILDRENS), 
                4));

        assertThat(
            customer.statement(),
            is("Rental Record for Fred\n\tThe Tigger Movie\t3.0\nYou owed 3.0\nYou earned 1 frequent renter points\n"));
    }

    @Test
    public void testMultipleRegularStatement() {
        customer.addRental(
            new Rental(
                new Movie("Plan 9 from Outer Space", MovieType.REGULAR), 
                1));
        customer.addRental(
            new Rental(
                new Movie("8 1/2", MovieType.REGULAR), 
                2));
        customer.addRental(
            new Rental(
                new Movie("Eraserhead", MovieType.REGULAR), 
                3));

        assertThat(
            customer.statement(),
            is("Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n"));
    }    
}
