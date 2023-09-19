package com.farhad.example.design_principles02.ppp.exercise_2_srp.library.data;

import java.util.List;

import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model.BookCopy;
import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model.BookTitle;
import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model.Patron;

public interface DataServices {
    
    BookCopy addCopy(BookTitle title);
    void addPatron(Patron patron);

    BookCopy findCopy(String isbn);
    BookTitle findTitleByIsbn(String isbn);
    List<BookCopy> findAllCopy(String isbn);
    BookCopy findAvailableCopy(String isbn);
    BookCopy findCopyById(String copyId);
    Patron findPatronById(String id);

    boolean containsTitle(String isbn);
    int countActivePatrons();
    int bookCount();
}
