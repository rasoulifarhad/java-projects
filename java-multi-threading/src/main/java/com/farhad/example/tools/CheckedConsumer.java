package com.farhad.example.tools;

import java.util.function.Consumer;


@FunctionalInterface
public interface CheckedConsumer<E extends Exception,T> {

    void accept(T t) throws E ;
    
    static <T> Consumer<T> wrap(CheckedConsumer<Exception,T> CheckedConsumer) {
        return t -> {
            try {
                CheckedConsumer.accept(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    static <T, E extends Exception> Consumer<T> consumerWrapper(Consumer<T> consumer, Class<E> clazz) {

        return t ->  {
            try {
                consumer.accept(t);
            } catch (Exception e) {
                try {
                    E exCast = clazz.cast(e);
                    System.err.println("Exception occured : " + exCast.getMessage());
                } catch (ClassCastException ccEx) {
                    throw e ;
                }
            }
        };
    }

}
