package com.farhad.example.design_principles02.elegant_objects_book.never_accept_null.null_object;

import java.io.File;

public class AnyFile implements Mask {

    @Override
    public boolean matches(File file) {
        return true;
    }

}
