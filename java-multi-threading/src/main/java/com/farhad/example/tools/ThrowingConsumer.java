package com.farhad.example.tools;

import java.util.function.Consumer;

@FunctionalInterface
public interface ThrowingConsumer<T, E extends Exception> {
    void accept(T t) throws E ;

    static <T> Consumer<T> throwingConsumerWrapper(ThrowingConsumer<T, Exception> throwingConsumer) {
        return t -> {
            try {
                throwingConsumer.accept(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    static <T, E extends Exception> Consumer<T> handlingConsumerWrapper(ThrowingConsumer<T, E> throwingConsumer, Class<E> exceptionClass) {
        return t -> {
            try {
                throwingConsumer.accept(t);
            } catch (Exception e) {
                try {
                    E exCast = exceptionClass.cast(e);
                    System.err.println("Exception occured: " + exCast.getMessage());
                } catch (ClassCastException ccEx) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}
