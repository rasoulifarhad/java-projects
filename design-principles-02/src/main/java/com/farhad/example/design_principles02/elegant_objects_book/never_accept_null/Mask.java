package com.farhad.example.design_principles02.elegant_objects_book.never_accept_null;

import java.io.File;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Mask {

    private final String pattern;

    public boolean empty() {
        return "".equals(pattern);
    }

    public boolean matches(File file) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'matches'");
    }
}

