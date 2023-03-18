package com.farhad.example.tools;

import lombok.AllArgsConstructor;

/**
 * The  Try type is something that is very similar to the  Either type. It has, again, two cases: “success” or “failure.”
 * 
 * The failure can only hold the type Exception, while the success can hold anything type you want.
 * 
 * So, the Try is nothing more than a specific implementation of the  Either where the left type (the failure) is fixed to type 
 * Exception.
 * 
 */

 @AllArgsConstructor
public class Try<Exception,R> {

    private final Exception failure;
    private final R succes;

}
