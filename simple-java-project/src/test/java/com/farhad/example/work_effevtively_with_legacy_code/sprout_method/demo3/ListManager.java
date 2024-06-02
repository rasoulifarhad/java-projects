package com.farhad.example.work_effevtively_with_legacy_code.sprout_method.demo3;

import java.util.Collection;
import java.util.LinkedList;

public class ListManager {

    @SuppressWarnings("rawtypes")
    private Collection l = new LinkedList();

    @SuppressWarnings("unchecked")
    public void add(Collection l) {
        l.addAll(l);
    }

    public boolean hasEntry(Entry entry) {
        return l.contains(entry);
    }
}
