package com.farhad.example.design_principles02.ppp.exercise_2_srp.library;

import java.util.Calendar;
import java.util.Date;

import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.data.DataServices;
import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model.BookCopy;
import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model.Receipt;

import lombok.Setter;

public class Library {
    
    private BookCatalog catalog;

    @Setter
    private TimeSource timeSource;

    private DataServices dataServices;

    public Library(DataServices dataServices) {
        this.dataServices = dataServices;
        this.catalog = new BookCatalog(dataServices);
        timeSource = new StandardTimeSource();
    }

    public BookCopy acceptBook(String isbn) {
        return catalog.addCopy(isbn);
    }

    public Receipt borrow(String copyId, String borrowerId) {

    }

    public Receipt returnCopy(String copyId) {

    }
  
    private Date getReturnDate() {
        Date now = timeSource.getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.add(Calendar.DAY_OF_YEAR, 14);
        return c.getTime();
    }  
}
