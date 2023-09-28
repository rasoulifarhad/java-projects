package com.farhad.example.functional_interface.vehicle_demo.with_try.toolkit;

import java.util.function.UnaryOperator;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LazyTry<T> {
    
    @NonNull
    private final UnaryOperator<T> f;

    public T execute(T t) {
        try {
            return f.apply(t);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return t;
        }
    }

    public static <T> LazyTry<T> to(UnaryOperator<T> f) {
        return new LazyTry<>(f);
    }

    public LazyTry<T> andThen(UnaryOperator<T> after) {
        return new LazyTry<>(t -> after.apply(f.apply(t)));
    }
}
