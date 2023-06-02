package com.farhad.example.string;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class CollatorBasedCloseEnoughComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1 == null || o2 == null) {
            return -1;
        }
        if (o1.equals(o2)) {
            return 0;
        }
        Collator usCollator = Collator.getInstance(Locale.US);
        usCollator.setStrength(Collator.PRIMARY);        
        return usCollator.compare(o1, o2)  ;
    }
    
}
