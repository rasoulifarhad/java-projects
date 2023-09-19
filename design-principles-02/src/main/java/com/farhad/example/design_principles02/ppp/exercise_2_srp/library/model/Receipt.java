package com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model;

import java.util.Date;

import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.Money;

import lombok.Getter;
import lombok.Setter;

public class Receipt {
    public static final int OK = 0 ;
    public static final int UNKNOWN_BOOK = 1 ;
    public static final int UNBORROWED_BOOK = 2 ;
    public static final int LATE = 3 ;

    // Receipt Type
    public static final int BORROW_RECEIPT = 0 ;
    public static final int RETURN_RECEIPT = 1 ;

    @Getter
    protected Patron borrower;
   
    @Getter
    protected int type;
    
    @Getter
    @Setter
    protected BookCopy copy;
    
    @Getter
    @Setter
    private int status;
    
    ///////////////////////////////////////////////////////
    ///////////RETURN RECEIPTS
    @Getter
    @Setter
    private Money fine = new Money(0);
    
    ///////////////////////////////////////////////////////
    ///////////BORROW RECEIPTS
    @Setter
    private Date returnDate;

    public Date getDueDate() {
        return returnDate;
    }

    public Receipt(int type) {
        this.type = type;
    }

    public Receipt(Patron patron, int type) {
        this.borrower = patron;
        this.type = type;
    }

    
    
}
