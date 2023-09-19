package com.farhad.example.design_principles02.ppp.exercise_2_srp.library;

import java.util.List;

import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.data.DataServices;
import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.data.IsbnDoesNotExistException;
import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model.BookCopy;
import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model.BookTitle;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookCatalog {
    private final DataServices dataServices;

    public BookCopy addCopy(String isbn) {
        BookTitle title = dataServices.findTitleByIsbn(isbn);
        if (title == null) {
            throw new IsbnDoesNotExistException();
        }
        return dataServices.addCopy(title);
    }

    public BookCopy findCopy(String isbn) {
        return dataServices.findCopy(isbn);
    }

    public List<BookCopy> findAllCopy(String isbn) {
        return dataServices.findAllCopy(isbn);
    }

    public BookCopy findAvailableCopy(String isbn) {
        return dataServices.findAvailableCopy(isbn);
    }

    public BookCopy findCopyById(String copyId) {
        return dataServices.findCopyById(copyId);
    }

    public boolean containsTitle(String isbn) {
        return dataServices.containsTitle(isbn);
    }

    public int bookCount() {
        return dataServices.bookCount();
    }
}
