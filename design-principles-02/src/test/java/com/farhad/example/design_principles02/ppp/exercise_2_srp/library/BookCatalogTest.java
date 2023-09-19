package com.farhad.example.design_principles02.ppp.exercise_2_srp.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.data.IsbnDoesNotExistException;
import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.mocks.MockDataServices;
import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model.BookCopy;
import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model.BookTitle;
import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model.Patron;
import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model.Receipt;

public class BookCatalogTest {

    private MockDataServices dataServices;
    private BookCatalog catalog;

    @BeforeEach
    public void setup() {
        dataServices = new MockDataServices();
        catalog = new BookCatalog(dataServices);
    }

    @Test 
    public void testAddBookShouldLookUpISBN() {
        addCopy("ISBN");
        assertThat(dataServices.wasLastCalledWithThisIsbn).isEqualTo("ISBN");
    }

    @Test 
    public void testAddBookShouldAddBookReturnedByIsbnService() {
        BookCopy copy = addCopy("ISBN");
        assertThat(dataServices.addedBookCopy.getTitle()).isEqualTo(copy.getTitle());
    }

    @Test
    public void testShouldReturnCorrectBookAmongMany() {
        BookCopy copy1 = addCopy("ISBN 1");
        BookCopy copy2 = addCopy("ISBN 2");

        assertSame(copy1, catalog.findCopy("ISBN 1"));
        assertSame(copy2, catalog.findCopy("ISBN 2"));
    }

    @Test
    public void testUnfoundISBN() {
        assertThrows(
            IsbnDoesNotExistException.class, 
            () -> catalog.addCopy("not exist"));
    }

    @Test
    public void testCanFindMoreThanOneBook() {
        BookCopy copy1 = addCopy("ISBN");
        BookCopy copy2 = addCopy("ISBN");

        List<BookCopy> copies = catalog.findAllCopy("ISBN");

        assertTrue(copies.size() == 2);
        assertTrue(copies.contains(copy1));
        assertTrue(copies.contains(copy2));
    }

    @Test
	public void testFindAvailableCopyReturnsCopyWhenOneCopyOfManyIsBorrowed(){

        BookCopy copy1 = addCopy("ISBN");
        BookCopy copy2 = addCopy("ISBN");

        List<BookCopy> copies = catalog.findAllCopy("ISBN");
        BookCopy copy = copies.get(0);
        copy.setBorrowed(new Receipt(new Patron("borrower"), Receipt.BORROW_RECEIPT));
        assertNotNull(catalog.findAvailableCopy("ISBN"));
    } 

    private BookCopy addCopy(String isbn) {
        dataServices.setBookToReturn(new BookTitle(isbn));
        return catalog.addCopy(isbn);
    }
}
