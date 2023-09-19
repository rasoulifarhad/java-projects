package com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model;

import lombok.Getter;
import lombok.Setter;

public class BookCopy {
    @Getter
    @Setter
    private BookTitle title;
    @Getter
    private String id;
    private Receipt receipt;
    
    public BookCopy(BookTitle title, String id) {
        this.title = title;
        this.id = id;
    }

    public boolean isBorrowed() {
        return receipt != null;
    }

    public void setBorrowed(Receipt receipt) {
        this.receipt = receipt;
    }
}
