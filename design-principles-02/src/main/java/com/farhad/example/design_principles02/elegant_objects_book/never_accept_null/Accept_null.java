package com.farhad.example.design_principles02.elegant_objects_book.never_accept_null;

import java.io.File;
import java.util.ArrayList;

public class Accept_null {

    public Iterable<File> find(String mask){
        if(mask == null) {
            // find all files
        } else {
            // find files by mask
        }
        return new ArrayList<>();
    }
}
