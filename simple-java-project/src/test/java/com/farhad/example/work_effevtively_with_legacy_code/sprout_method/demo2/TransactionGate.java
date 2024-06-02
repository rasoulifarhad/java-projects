package com.farhad.example.work_effevtively_with_legacy_code.sprout_method.demo2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


// We need to add code to verify that none of the new entries are already in
// transactionBundle before we post their dates and add them.
public class TransactionGate {

    TransactionBundle transactionBundle;

    @SuppressWarnings("rawtypes")
    public void postEntries( List entries)  {
        List entriesToAdd = new LinkedList();
        for(Iterator<?> it = entries.iterator(); it.hasNext();) {
            Entry entry = (Entry) it.next();
            if(!transactionBundle.getListManager().hasEntry(entry)) {
                entry.postDate();
                entriesToAdd.add(entry);
                
            }
        }
        transactionBundle.getListManager().add(entriesToAdd);
    }
}
