package com.farhad.example.design_principles02.ppp.exercise_2_srp.library;

import java.util.Calendar;
import java.util.Date;

import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.data.DataServices;
import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model.BookCopy;
import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model.Patron;
import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model.Receipt;
import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.utils.DateUtil;

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
        BookCopy copy = catalog.findCopyById(copyId);
        Patron borrower = dataServices.findPatronById(borrowerId);
        Receipt borrowReceipt = new Receipt(borrower, Receipt.BORROW_RECEIPT);
        if(copy == null) {
            borrowReceipt.setStatus(Receipt.UNKNOWN_BOOK);
        } else {
            copy.setBorrowed(borrowReceipt);
            borrowReceipt.setStatus(Receipt.OK);
            borrowReceipt.setCopy(copy);
            borrowReceipt.setReturnDate(getReturnDate());
        }
        return borrowReceipt;
    }

    public Receipt returnCopy(String copyId) {
        BookCopy copy = catalog.findCopyById(copyId);
        Receipt receipt = new Receipt(Receipt.RETURN_RECEIPT);
        if(copy == null) {
            receipt.setStatus(Receipt.UNKNOWN_BOOK);
        } else if (!copy.isBorrowed()) {
            receipt.setStatus(Receipt.UNBORROWED_BOOK);
            receipt.setCopy(copy);
        } else {
            Receipt borrowReceipt = copy.getReceipt();
            if(timeSource.getTime().compareTo(borrowReceipt.getDueDate()) > 0) {
                receipt.setStatus(Receipt.LATE);
                receipt.setFine(calculateFine(receipt));
            } else {
                receipt.setStatus(Receipt.OK);
            }
            copy.setBorrowed(null);
            receipt.setCopy(copy);
        }
        return receipt;
    }
  
    private Money calculateFine(Receipt receipt) {
        int days = DateUtil.daysLate(timeSource.getTime(), receipt.getDueDate());
        return new Money(days * 50);    
    }

    private Date getReturnDate() {
        Date now = timeSource.getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.add(Calendar.DAY_OF_YEAR, 14);
        return c.getTime();
    }  
}
