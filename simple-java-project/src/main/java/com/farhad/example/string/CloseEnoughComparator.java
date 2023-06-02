package com.farhad.example.string;

import java.util.Comparator;

public class CloseEnoughComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1 == null || o2 == null) {
            return -1;
        }
        if (o1.equals(o2)) {
            return 0;
        }
        
        return o1.trim().compareToIgnoreCase(o2.trim())  ;
    } 
    
}
