package com.farhad.example.design_principles02.ppp.exercise_2_srp.library.mocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.data.DataServices;
import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model.BookCopy;
import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model.BookTitle;
import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model.Patron;

public class MockDataServices implements DataServices {

    private static long lastId = 0;

    public BookCopy addedBookCopy;
    private Map<String, List<BookCopy>> bookCopies = new HashMap<>();

    @Override
    public BookCopy addCopy(BookTitle title) {
        BookCopy bookCopy = new BookCopy(title, "" + (++lastId));
        String isbn = title.getIsbn();
        bookCopies.computeIfAbsent(isbn, k -> new LinkedList<BookCopy>()).add(bookCopy);
        // List<BookCopy> list = bookCopies.compute(isbn, (k, v) -> v == null ? new LinkedList<BookCopy>() : v );
        // list.add(bookCopy);
        addedBookCopy = bookCopy;
        return bookCopy;
    }

    @Override
    public BookCopy findCopy(String isbn) {
        return bookCopies.containsKey(isbn) ? bookCopies.get(isbn).get(0) : null; 
    }

    @Override
    public boolean containsTitle(String isbn) {
        return bookCopies.containsKey(isbn);
    }

    @Override
    public BookCopy findAvailableCopy(String isbn) {
        List<BookCopy> copies = findAllCopy(isbn);
        return copies.stream()
                .filter(copy -> !copy.isBorrowed())
                .findFirst()
                .orElse(null);
    }

    @Override
    public BookCopy findCopyById(String copyId) {
        return bookCopies.entrySet().stream()
                .flatMap(e -> e.getValue().stream())
                .filter(copy -> copy.getId().equals(copyId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<BookCopy> findAllCopy(String isbn) {
        return bookCopies.getOrDefault(isbn, new ArrayList<>());
    }


    @Override
    public int bookCount() {
        return bookCopies.size();
    }

    public String wasLastCalledWithThisIsbn;    
	Map<String, BookTitle> titles = new HashMap<String, BookTitle>(); 

    public void setBookToReturn(BookTitle title) {
        titles.put(title.getIsbn(), title);
    }

    @Override
    public BookTitle findTitleByIsbn(String isbn) {
        wasLastCalledWithThisIsbn = isbn;
        return titles.get(isbn);
    }

    Map<String, Patron> patronMap = new HashMap<String, Patron>();

    @Override
    public void addPatron(Patron patron) {
        patronMap.put(patron.getId(), patron);
    }


    @Override
    public Patron findPatronById(String id) {
        return patronMap.get(id);
    }

    @Override
    public int countActivePatrons() {
        return patronMap.size();
    }
    
}
