package com.farhad.example.refactoring.videostore.refactored;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VideoStoreTest {

    private RentalStatement statement;
    private Movie newRelease1;
    private Movie newRelease2;
    private Movie childrens;
    private Movie regular1;
    private Movie regular2;
    private Movie regular3;
    
    @BeforeEach
    public void setup() {
        statement = new RentalStatement("Customer name");
        newRelease1 = new NewReleaseMovie("New Release 1");
        newRelease2 = new NewReleaseMovie("New Release 2");
        childrens = new ChildrensMovie("Childrens");
        regular1 = new RegularMovie("Regular 1");
        regular2 = new RegularMovie("Regular 2");
        regular3 = new RegularMovie("Regular 3");
    }

    @Test
    public void testSingleNewReleaseStatement() {
        statement.addRental(new Rental(newRelease1, 3));
        statement.makeRentalStatement();
        assertAmountAndPointsForReport(9.0, 2);
    }

    @Test
    public void testDualNewReleaseStatement() {
        statement.addRental(new Rental(newRelease1, 3));
        statement.addRental(new Rental(newRelease2, 3));
        statement.makeRentalStatement();
        assertAmountAndPointsForReport(18.0, 4);
    }

    @Test
    public void testSingleChildrensStatement() {
        statement.addRental(new Rental(childrens, 3));
        statement.makeRentalStatement();
        assertAmountAndPointsForReport(1.5, 1);
    }


    @Test
    public void testMultipleRegularStatement() {
        statement.addRental(new Rental(regular1, 1));
        statement.addRental(new Rental(regular2, 2));
        statement.addRental(new Rental(regular3, 3));
        statement.makeRentalStatement();
        assertAmountAndPointsForReport(7.5, 3);
    }

    @Test
    public void testRentalStatementFormat() {
        statement.addRental(new Rental(regular1, 1));
        statement.addRental(new Rental(regular2, 2));
        statement.addRental(new Rental(regular3, 3));
        statement.makeRentalStatement();

        String string =
        "Rental Record for Customer name\n" +
        "\tRegular 1\t2.0\n" + 
        "\tRegular 2\t2.0\n" +
        "\tRegular 3\t3.5\n" +
        "You owed 7.5\n" +
        "You earned 3 frequent renter points\n";
        Assertions.assertThat(statement.makeRentalStatement()).isEqualTo(string);
    }

    private void assertAmountAndPointsForReport(double expectedAmount, int expectedPoints) {
        Assertions.assertThat(statement.getAmountOwed()).isEqualTo(expectedAmount);
        Assertions.assertThat(statement.getFrequentRenterPoints()).isEqualTo(expectedPoints);
    }
}
