package com.farhad.example.functional_interface.vehicle_demo.with_either.toolkit;

import java.util.function.Function;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TryWithError<T, U> {
    
    private final Function<T, U> f;


    public static  <T, U> TryWithError<T, U> to(Function<T, U> f) {
        return new TryWithError<>(f);
    }

    public <V> TryWithError<T, V> andThen(Function<U, V> g) {
        return new TryWithError<>(f.andThen(g));
    }

    public Either<RuntimeException, U> execte(T t) {
        try {
            return Either.withRightValue(f.apply(t));
        } catch (Exception e) {
            return Either.withLeftValue(new RuntimeException(e.getMessage(), e));
        }
    }
}
