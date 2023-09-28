package com.farhad.example.functional_interface.vehicle_demo.with_lazy_try.toolkit;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class LazyTry<T> {
    
    @NonNull
    private final UnaryOperator<T> f;
    private final Consumer<Exception> exceptionHandler;

    public LazyTry(final  UnaryOperator<T> f) {
        this(f, 
            exception -> 
                System.out.printf("Exception caught while trying to execute f: %s with parameter: %s; \n",
                                        f.getClass().getSimpleName(),
                                        exception)); 
    }

    public static <T> LazyTry<T> to(UnaryOperator<T> f) {
        return new LazyTry<>(f);
    }

    public LazyTry<T> andThen(UnaryOperator<T> after) {
        return new LazyTry<>(t -> after.apply(f.apply(t)), exceptionHandler);
    }

    public LazyTry<T> onError(Consumer<Exception> exceptionHandler) {
        return new LazyTry<>(f, exceptionHandler);
    }

    public T execute(T t) {
        try {
            return f.apply(t);
        } catch (RuntimeException e) {
            exceptionHandler.accept(e);
            return t;
        }
    }

}
