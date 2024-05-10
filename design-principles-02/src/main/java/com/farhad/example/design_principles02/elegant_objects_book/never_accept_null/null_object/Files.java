package com.farhad.example.design_principles02.elegant_objects_book.never_accept_null.null_object;

import java.io.File;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class Files {

    private Collection<File> files;

    public Files(Collection<File> files) {
        Objects.requireNonNull(files);
        this.files = files;
    }

    public Collection<File> find(Mask mask) {

        return 
            files.stream()
                .filter(mask::matches)
                .collect(Collectors.toList());
    }
}
