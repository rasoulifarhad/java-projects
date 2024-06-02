package com.farhad.example.work_effevtively_with_legacy_code.sprout_method.demo1;

import java.util.Iterator;
import java.util.List;

public class TransactionGate {

    TransactionBundle transactionBundle;

    public void postEntries(List<?> entries)  {
        for(Iterator<?> it = entries.iterator(); it.hasNext();) {
            Entry entry = (Entry) it.next();
            entry.postDate();
        }
        transactionBundle.getListManager().add(entries);
    }
}
