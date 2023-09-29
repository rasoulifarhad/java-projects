package com.farhad.example.functional_interface.vehicle_demo.with_either.toolkit;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Either<T, V> {
    
    private final T left; // exception comes here
    private final V right;

    public static <T, V> Either<T, V> withLeftValue(final T value){
        return new Either<T,V>(value, null);
    }

    public static <T, V> Either<T, V> withRightValue(final V value){
        return new Either<T,V>(null, value);
    }

}
