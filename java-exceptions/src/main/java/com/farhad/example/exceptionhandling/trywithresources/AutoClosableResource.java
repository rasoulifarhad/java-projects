package com.farhad.example.exceptionhandling.trywithresources;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * You can add a catch block to a try-with-resources block just like you can to a standard try block. If an exception is thrown from within 
 * the try block of a try-with-resources block, the catch block will catch it, just like it would when used with a standard try construct.
 * 
 * Before the catch block is entered, the try-with-resources construct will attempt to close the resources opened inside the try block. In 
 * case an exception is thrown when attempting to close one of the resources, these exceptions will be available from the exception's 
 * getSuppressed() method inside the catch block. 
 * 
 * It is also possible to add a finally block to a Java try-with-resources block. It will behave just like a standard finally block, meaning 
 * it will get executed as the last step before exiting the try-with-resources block - after any catch block has been executed.
 * 
 * In case you throw an exception from within the finally block of a try-with-resources construct, all previously thrown exceptions will be lost!
 * 
 * Notice, that the exception thrown from within the catch block will be ignored because a new exception is thrown from within the finally 
 * block. This would also be true if there was no catch block. Then any exception thrown from inside the try block would get lost because a 
 * new exception is thrown from inside the finally block. Any previous exceptions are not suppressed, so they are not available from within 
 * the exception thrown from the finally block.
 * 
 * The Throwable class has a method named addSuppressed() which takes a Throwable object as parameter. Using the addSuppressed() method it 
 * is possible to add suppressed exceptions to another exception, in case you need that.
 */
@Slf4j
@AllArgsConstructor
public class AutoClosableResource implements AutoCloseable {

    private String  name                  = null;
    private boolean throwExceptionOnClose = false ;

    public void doSomething(boolean throwException) throws Exception {
        log.info("Resource {} doing something", name);
        if (throwException) {
            throw new Exception(String.format("Error when calling doSomething on resource %s", name));
        }
    }

    @Override
    public void close() throws Exception {
        log.info("Resource {} close() called", name);
        if (throwExceptionOnClose) {
            throw new Exception(String.format("Error when trying to close resource %s", name));
        }    
    }
    
}
