package com.farhad.example.functional_interface.solid.dip.raw;

import java.io.IOException;

public class HeadingLookupException extends RuntimeException{

    public HeadingLookupException(IOException e) {
        super(e);
    }

}
