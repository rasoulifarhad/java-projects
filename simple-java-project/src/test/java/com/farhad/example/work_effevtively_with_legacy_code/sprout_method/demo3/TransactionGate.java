package com.farhad.example.work_effevtively_with_legacy_code.sprout_method.demo3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// We need to add code to verify that none of the new entries are already in
// transactionBundle before we post their dates and add them.
public class TransactionGate {

    TransactionBundle transactionBundle;

    @SuppressWarnings("rawtypes")
    public void postEntries(List entries) {
        List entriesToAdd = uniqueEntries(entries);
        for (Iterator<?> it = entries.iterator(); it.hasNext();) {
            Entry entry = (Entry) it.next();
            entry.postDate();
        }
        transactionBundle.getListManager().add(entriesToAdd);
    }

    private List uniqueEntries(List entries) {
        List result = new ArrayList<>();
        for (Iterator<?> it = entries.iterator(); it.hasNext();) {
            Entry entry = (Entry) it.next();
            if (!transactionBundle.getListManager().hasEntry(entry)) {
                result.add(entry);

            }
        }
        return result;
    }
}
