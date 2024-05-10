package com.farhad.example.design_principles02.elegant_objects_book.never_accept_null;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class MaskDemo {

    public Iterable<File> find(Mask mask) {
        if(mask.empty()) {
            // find all files
        } else {
            // find files bu mask
        }

        return new ArrayList<>();
    }

    public Iterable<File> betterFind(Mask mask, Collection<File> files) {
        Collection<File> filesByMask = new LinkedList<>();
        for (File file : files) {
            if(mask.matches(file)) {
                filesByMask.add(file);
            }
        }
        return filesByMask;
    }}
